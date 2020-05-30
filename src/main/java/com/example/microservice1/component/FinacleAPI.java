package com.example.microservice1.component;

import com.example.microservice1.module.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;

@Component
public class FinacleAPI {

    @Autowired
    private FeignClient feignClient;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    Logger log = LoggerFactory.getLogger(FinacleAPI.class);


    public List<Employee> callAPI()
    {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");

        return circuitBreaker.run(()->feignClient.getEmployees(),
                throwable -> getDefaultCallAPI());

    }

    private List<Employee> getDefaultCallAPI() {

        try {
            return Arrays.asList(new Employee("Amar", 23));
        }
        catch (Exception e)
        {
            log.error("error occured while sending response",e);
        }
        return null;

    }

    public Employee getSingleAPI(String Employeename)
    {
        Employee employee = feignClient.getEmployee(Employeename);
        log.debug("Inside Single API Class {}",employee);
        return employee;
    }
}
