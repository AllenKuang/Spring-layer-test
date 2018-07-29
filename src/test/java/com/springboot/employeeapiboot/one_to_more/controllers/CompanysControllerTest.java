package com.springboot.employeeapiboot.one_to_more.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.employeeapiboot.one_to_more.dto.CompanyDTO;
import com.springboot.employeeapiboot.one_to_more.entities.Company;
import com.springboot.employeeapiboot.one_to_more.services.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CompanysController.class)
public class CompanysControllerTest {
    @Autowired
    CompanysController companysController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService companyService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void should_get_all_companys_without_any_paramters() throws Exception {
        //given
        Company company1=new Company(1L,"oocl");
        Company company2=new Company(2L,"tw");
        List<Company> companies= Arrays.asList(company1,company2);
        when(companyService.getAllCompany()).thenReturn(companies);

        //when
        ResultActions result=mockMvc.perform(get("/api/v1/companies"));

        //then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].id",is(1)))
                .andExpect(jsonPath("$[0].name",is(company1.getName())));
    }

    @Test
    public void should_get_company_by_id() throws Exception {
        //given
        long id=1;
        CompanyDTO companyDTO=new CompanyDTO(new Company(1L,"oocl"));
        when(companyService.getCompanyById(anyLong())).thenReturn(companyDTO);
        //when
         mockMvc.perform(get("/api/v1/companies/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(id))
                .andExpect(jsonPath("name").value(companyDTO.getName()));
    }

    @Test
    public void should_return_company_when_post_one_company() throws Exception {
        //given
        Company company=new Company("oocl");
        when(companyService.addOneCompany(any(Company.class))).thenReturn(true);
        //when
        ResultActions result=mockMvc.perform(post("/api/v1/companies")
                                                    .contentType(MediaType.APPLICATION_JSON)
                                                    .content(mapper.writeValueAsString(company)));

        //then
        result.andExpect(status().isCreated())
              //.andExpect(jsonPath("name",is(company.getName())))
              .andDo(print());
    }

    @Test
    public void should_update_the_id_1L_company_when_put_the_company_api() throws Exception {
        //given
        Company company=new Company(1L,"ooclModify");
        when(companyService.modifyCompanyById(any(Company.class))).thenReturn(true);

        //when
        ResultActions resultActions=mockMvc.perform(put("/api/v1/companies/1")
                                                        .contentType(MediaType.APPLICATION_JSON)
                                                        .content(mapper.writeValueAsString(company)));

        //then
        resultActions.andExpect(status().isNoContent());
    }

    @Test
    public void should_delete_company_when_call_http_delete_by_id() throws Exception {
        //given
        Long id=1L;
        when(companyService.deleteCompanyById(anyLong())).thenReturn(true);

        //when
        ResultActions resultActions=mockMvc.perform(delete("/api/v1/companies/1"));

        //then
        resultActions.andExpect(status().isOk());

    }
}