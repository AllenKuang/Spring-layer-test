package com.springboot.employeeapiboot.one_to_more.controllers;

import com.springboot.employeeapiboot.one_to_more.entities.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@WebMvcTest
public class CompanysControllerTest {
    @Autowired
    CompanysController companysController;

    //@MockBean


    @Test
    public void should_get_all_companys_without_any_paramters() {

    }

    @Test
    public void getCompanyById() {
    }

    @Test
    public void addOneCompany() {
    }

    @Test
    public void modifyCompanyById() {
    }

    @Test
    public void deleteCompanyById() {
    }
}