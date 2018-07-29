package com.springboot.employeeapiboot.one_to_more.entities;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name="company")
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @CreatedDate()
    private ZonedDateTime createDate=ZonedDateTime.now();

   // private ArrayList<Employee> employees;
    public Company(String name){
       //this.id=id;
        this.name=name;
    }
    public Company(Long id,String name){
        this.id=id;
        this.name=name;
    }
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company",fetch=FetchType.LAZY)
    private List<Employee> employees=new ArrayList<>();
    public Company(){

    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
