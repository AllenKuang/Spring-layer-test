package com.springboot.employeeapiboot.Cores;

import java.util.ArrayList;

public class Company {
    private String companyName;
    private long employeesNumber;
    private ArrayList<Employee> employees;
    private long id;
    public Company(){

    }
    public Company(long id,String companyName,ArrayList<Employee> employees){
        this.id=id;
        this.companyName=companyName;
        this.employeesNumber=employees.size();
        this.employees=employees;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(long employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
