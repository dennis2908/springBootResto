package io.hamza.recipemanagement.customer;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer createCustomer(Customer customer){

        // recipes.stream().forEach(recipe -> recipe.setCustomer(customer));

        this.customerRepository.save(customer);

        return customer;
    }

    public List<Customer> getCustomers(){
        System.out.println(this.customerRepository.findAll());
        return this.customerRepository.findAll();
    }

    public Long getNumberOfCustomers(){
        return this.customerRepository.count();
    }
}
