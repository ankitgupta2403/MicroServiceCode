package com.example.microservice1.module;

import org.springframework.context.annotation.Configuration;

public class Employee {

    private String employeeName;
    private int employeeAge;

    public Employee() {
    }

    public Employee(String employeeName, int employeeAge) {
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeAge=" + employeeAge +
                '}';
    }
}
