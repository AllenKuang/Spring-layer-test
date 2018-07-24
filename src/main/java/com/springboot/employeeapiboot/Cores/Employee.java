package com.springboot.employeeapiboot.Cores;

import java.util.ArrayList;

public class Employee{
    private  int id;
    private String name;
    private int age;
    private String gender;

    public Employee(){      //缺少无参构造函数会导致一个错误在put的时候：Cannot construct instance of `...Employee`

    }

    public Employee(int id,String name,int age,String gender){
        this.id=id;
        this.name=name;
        this.age=age;
        this.gender=gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}