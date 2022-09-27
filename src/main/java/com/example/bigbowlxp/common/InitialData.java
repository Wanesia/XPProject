package com.example.bigbowlxp.common;

import com.example.bigbowlxp.model.BowlingLane;
import com.example.bigbowlxp.model.Customer;
import com.example.bigbowlxp.model.Employee;
import com.example.bigbowlxp.model.User;
import com.example.bigbowlxp.repository.BowlingLaneRepository;
import com.example.bigbowlxp.repository.CustomerRepository;
import com.example.bigbowlxp.repository.EmployeeRepository;
import com.example.bigbowlxp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import java.time.LocalDate;

@Configuration
public class InitialData {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BowlingLaneRepository bowlingLaneRepository;


    @PostConstruct
    public void initializeData() {

        Customer customer1 = new Customer("Laura", "Anne", "+455599959");
        customerRepository.save(customer1);

        LocalDate date = LocalDate.of(1975, 6, 4);
        Employee employee1 = new Employee("Zaland", "Malasy", "+4566666", date);
        employeeRepository.save(employee1);

        User user1 = new User("user", "pass");
        userRepository.save(user1);

        BowlingLane bowlingLane = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane);

    }
}
