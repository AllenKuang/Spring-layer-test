package com.springboot.employeeapiboot.one_to_more.controllers;

import com.springboot.employeeapiboot.one_to_more.dto.CompanyDTO;
import com.springboot.employeeapiboot.one_to_more.entities.Company;
import com.springboot.employeeapiboot.one_to_more.respositories.CompanyRepository;
import com.springboot.employeeapiboot.one_to_more.respositories.EmployeeRepository;
import com.springboot.employeeapiboot.one_to_more.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanysController {
    private CompanyService companyService;
    @Autowired
    public CompanysController(CompanyService companyService){
        this.companyService=companyService;
    }
    @Transactional
    @GetMapping(path="",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Company>> getAllCompany(){
        return ResponseEntity.ok(companyService.getAllCompany());

    }
    @Transactional
    @GetMapping(path="/{id}")
    public CompanyDTO getCompanyById(@PathVariable long id){
        return companyService.getCompanyById(id);
    }
    @Transactional
    @PostMapping(path="")
    public ResponseEntity addOneCompany(@RequestBody Company company){
         if(companyService.addOneCompany(company)){
             return ResponseEntity.status(HttpStatus.CREATED).build();
         }
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @Transactional
    @PutMapping(path="/{id}")
    public ResponseEntity modifyCompanyById(@RequestBody Company company){
         if(companyService.modifyCompanyById(company)){
             return ResponseEntity.noContent().build();
         }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @Transactional
    @DeleteMapping(path="/{id}")
    public ResponseEntity deleteCompanyById(@PathVariable Long id){
        if(companyService.deleteCompanyById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
