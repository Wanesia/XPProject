package com.example.bigbowlxp.common;

import com.example.bigbowlxp.model.*;
import com.example.bigbowlxp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

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

    @Autowired
    StockRepository stockRepository;

    @Autowired
    DiningTableRepository diningTableRepository;

    @Autowired
    HockeyTableRepository hockeyTableRepository;

    @Autowired
    HockeyBookingRepository hockeyBookingRepository;

    @Autowired
    DiningBookingRepository diningBookingRepository;

    @Autowired
    BowlingBookingRepository bowlingBookingRepository;

    // @PostConstruct
    public void initializeData() {

        Customer customer1 = new Customer("Laura", "Anne", "+455599959");
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Roman", "Roy", "+455666666");
        customerRepository.save(customer2);

        LocalDate date = LocalDate.of(1975, 6, 4);
        Employee employee1 = new Employee("Zaland", "Malasy", "+4566666", date);
        employeeRepository.save(employee1);

        User user1 = new User("user", "pass", employee1);
        userRepository.save(user1);

        BowlingLane bowlingLane1 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane1);
        BowlingLane bowlingLane2 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane2);
        BowlingLane bowlingLane3 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane3);
        BowlingLane bowlingLane4 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane4);
        BowlingLane bowlingLane5 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane5);
        BowlingLane bowlingLane6 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane6);
        BowlingLane bowlingLane7 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane7);
        BowlingLane bowlingLane8 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane8);
        BowlingLane bowlingLane9 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane9);
        BowlingLane bowlingLane10 = new BowlingLane(true, true);
        bowlingLaneRepository.save(bowlingLane10);
        BowlingLane bowlingLane11 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane11);
        BowlingLane bowlingLane12 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane12);
        BowlingLane bowlingLane13 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane13);
        BowlingLane bowlingLane14 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane14);
        BowlingLane bowlingLane15 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane15);
        BowlingLane bowlingLane16 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane16);
        BowlingLane bowlingLane17 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane17);
        BowlingLane bowlingLane18 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane18);
        BowlingLane bowlingLane19 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane19);
        BowlingLane bowlingLane20 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane20);
        BowlingLane bowlingLane21 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane21);
        BowlingLane bowlingLane22 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane22);
        BowlingLane bowlingLane23= new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane23);
        BowlingLane bowlingLane24 = new BowlingLane(false, true);
        bowlingLaneRepository.save(bowlingLane24);

        Stock stock1 = new Stock("Bowling pin", 100);
        stockRepository.save(stock1);
        Stock stock2 = new Stock("Bowling ball", 100);
        stockRepository.save(stock2);
        Stock stock3 = new Stock("Socks", 200);
        stockRepository.save(stock3);
        Stock stock4 = new Stock("Shoes", 300);
        stockRepository.save(stock4);

        DiningTable diningTable1 = new DiningTable(false);
        diningTableRepository.save(diningTable1);
        DiningTable diningTable2 = new DiningTable(false);
        diningTableRepository.save(diningTable2);
        DiningTable diningTable3 = new DiningTable(false);
        diningTableRepository.save(diningTable3);
        DiningTable diningTable4 = new DiningTable(false);
        diningTableRepository.save(diningTable4);
        DiningTable diningTable5 = new DiningTable(false);
        diningTableRepository.save(diningTable5);
        DiningTable diningTable6 = new DiningTable(false);
        diningTableRepository.save(diningTable6);
        DiningTable diningTable7 = new DiningTable(false);
        diningTableRepository.save(diningTable7);
        DiningTable diningTable8 = new DiningTable(false);
        diningTableRepository.save(diningTable8);
        DiningTable diningTable9 = new DiningTable(false);
        diningTableRepository.save(diningTable9);
        DiningTable diningTable10 = new DiningTable(false);
        diningTableRepository.save(diningTable10);
        DiningTable diningTable11 = new DiningTable(false);
        diningTableRepository.save(diningTable11);
        DiningTable diningTable12 = new DiningTable(false);
        diningTableRepository.save(diningTable12);
        DiningTable diningTable13 = new DiningTable(false);
        diningTableRepository.save(diningTable13);
        DiningTable diningTable14 = new DiningTable(false);
        diningTableRepository.save(diningTable14);

        HockeyTable hockeyTable1 = new HockeyTable(false, false);
        hockeyTableRepository.save(hockeyTable1);
        HockeyTable hockeyTable2 = new HockeyTable(false, false);
        hockeyTableRepository.save(hockeyTable2);
        HockeyTable hockeyTable3 = new HockeyTable(false, false);
        hockeyTableRepository.save(hockeyTable3);
        HockeyTable hockeyTable4 = new HockeyTable(false, false);
        hockeyTableRepository.save(hockeyTable4);
        HockeyTable hockeyTable5 = new HockeyTable(false, false);
        hockeyTableRepository.save(hockeyTable5);
        HockeyTable hockeyTable6 = new HockeyTable(false, false);
        hockeyTableRepository.save(hockeyTable6);

        LocalDateTime startDateTime1 = LocalDateTime.of(2022,
                Month.OCTOBER, 29, 19, 30, 40);

        LocalDateTime startDateTime2 = LocalDateTime.of(2022,
                Month.OCTOBER, 30, 18, 00, 00);

        LocalDateTime endDateTime1 = LocalDateTime.of(2022,
                Month.OCTOBER, 29, 20, 30, 40);

        LocalDateTime endDateTime2 = LocalDateTime.of(2022,
                Month.OCTOBER, 30, 19, 00, 00);

        HockeyBooking hockeyBooking1 = new HockeyBooking(startDateTime1, endDateTime1, customer1, hockeyTable1);
        hockeyBookingRepository.save(hockeyBooking1);

        HockeyBooking hockeyBooking2 = new HockeyBooking(startDateTime2, endDateTime2, customer2, hockeyTable2);
        hockeyBookingRepository.save(hockeyBooking2);

        DiningBooking diningBooking1 = new DiningBooking(startDateTime1, endDateTime1, customer1, diningTable1);
        diningBookingRepository.save(diningBooking1);

        DiningBooking diningBooking2 = new DiningBooking(startDateTime2, endDateTime2, customer2, diningTable2);
        diningBookingRepository.save(diningBooking2);

        BowlingBooking bowlingBooking1 = new BowlingBooking(startDateTime1, endDateTime1, customer1, bowlingLane3);
        bowlingBookingRepository.save(bowlingBooking1);

        BowlingBooking bowlingBooking2 = new BowlingBooking(startDateTime2, endDateTime2, customer2, bowlingLane4);
        bowlingBookingRepository.save(bowlingBooking2);
    }
}
