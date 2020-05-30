package com.example.microservice1.component;

import com.example.microservice1.module.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.cloud.openfeign.FeignClient(value="jsonClient",url = "http://localhost:7071")
public interface FeignClient {

    @GetMapping("/rest/employees")
    List<Employee> getEmployees();

    @GetMapping("/rest/employee/{employeename}")
    Employee getEmployee(@PathVariable("employeename") String employeename);

}
