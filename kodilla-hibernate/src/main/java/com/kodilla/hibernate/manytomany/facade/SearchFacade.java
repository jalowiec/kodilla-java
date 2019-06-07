package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.CompanyDao;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchFacade {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    List<Company> findCompanyByString(String arg) {
        return companyDao.searchingByString(arg);
    }

    List<Employee> findEmployeeByString(String arg) {
        return employeeDao.searchingByString(arg);
    }

}
