package com.example.bigbowlxp.common;

import com.example.bigbowlxp.model.Customer;
import com.example.bigbowlxp.model.Employee;
import com.example.bigbowlxp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import static javax.print.attribute.Size2DSyntax.MM;

@Configuration
public class InitalData {

    @Autowired
    CustomerRepository customerRepository;

    @PostConstruct
    public void initializeData() {

        Customer customer1 = new Customer("Laura", "Anne", "+455599959");

        customerRepository.save(customer1);


    }
}
