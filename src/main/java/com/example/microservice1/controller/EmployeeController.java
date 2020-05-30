package com.example.microservice1.controller;

import com.example.microservice1.component.FinacleAPI;
import com.example.microservice1.module.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EmployeeController {

    Logger log = LoggerFactory.getLogger(EmployeeController.class);


    @Autowired
    private FinacleAPI finacleAPI;

    private  ReactiveCircuitBreaker circuitBreaker;


    @GetMapping("/employee")
    public List<Employee> getDetails()
    {
        log.debug("Inside Logger Class");
        return finacleAPI.callAPI();

    }

    @GetMapping("/employee/{employeename}")
    public Employee getSingleDetail(@PathVariable("employeename") String employeename)
    {
        if(employeename.equalsIgnoreCase("test"))
        {
            throw new RuntimeException("Invalid Request");
        }
        return finacleAPI.getSingleAPI(employeename);
    }
}
