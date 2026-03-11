package io.hamza.recipemanagement.init;

import io.hamza.recipemanagement.customer.Customer;
import io.hamza.recipemanagement.customer.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.text.SimpleDateFormat;  
import java.util.Date;


@Component
public class DataInitializerTwo implements CommandLineRunner {

    private final CustomerService customerService;

    public DataInitializerTwo(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(customerService.getNumberOfCustomers() > 1) {
            System.out.println("Customers already initialized!");
            return;
        }

        Customer customer1 = new Customer("Gordon Ramsay","jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta","01/08/1998");
        Customer customer2 = new Customer("Jamie Oliver","jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta","02/08/1998");
        Customer customer3 = new Customer("Anthony Bourdainnn","jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta","03/08/1998");

        customerService.createCustomer(customer1);
        customerService.createCustomer(customer2);
        customerService.createCustomer(customer3);

    }
}
