package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;




    private static final String PRODUCT1_NAME = "Buty do biegania";
    private static final String PRODUCT2_NAME = "Rakieta do tenisa";

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product(PRODUCT1_NAME);
        Product product2 = new Product(PRODUCT2_NAME);

        Item item1 = new Item(new BigDecimal(20.00), 2, new BigDecimal(40.00));
        Item item2 = new Item(new BigDecimal(100.00), 1, new BigDecimal(100.00));


        item1.setProduct(product1);
        item2.setProduct(product2);


        product1.getItems().add(item1);
        product2.getItems().add(item2);


        Invoice invoice = new Invoice("07/15/04/2019");


        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);



        //When
        //invoiceDao.save(invoice);
        invoiceDao.save(invoice);
        /*        int id = invoice.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        invoiceDao.deleteById(id);
*/

    }



}