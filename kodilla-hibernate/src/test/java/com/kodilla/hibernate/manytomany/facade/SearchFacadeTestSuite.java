package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.CompanyDao;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchFacadeTestSuite {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    SearchFacade searchFacade;

    @Test
    public void testEmployeeNamedQueries() {

        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        //When
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);

       //Then
        try{
            Assert.assertEquals(1, searchFacade.findEmployeeByString("i").size());
            Assert.assertEquals(2, searchFacade.findEmployeeByString("k").size());
            Assert.assertEquals(0, searchFacade.findEmployeeByString("x").size());


        } finally {
         //CleanUp
            employeeDao.deleteAll();
         }


    }

    @Test
    public void testCompanyNamedQueries() {

        //Given
        Company bonito = new Company("BONITO");
        Company matras = new Company("MATRAS");
        Company bonprix = new Company("BON-PRIX");

        //When
        companyDao.save(bonito);
        companyDao.save(matras);
        companyDao.save(bonprix);

        //Then
        try{
            Assert.assertEquals(1, searchFacade.findCompanyByString("-").size());
            Assert.assertEquals(0, searchFacade.findCompanyByString("Y").size());
            Assert.assertEquals(1, searchFacade.findCompanyByString("x").size());
            Assert.assertEquals(2, searchFacade.findCompanyByString("r").size());


        } finally {
            //CleanUp
            companyDao.deleteAll();
        }


    }



}

