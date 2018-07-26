package com.springboot.employeeapiboot.one_to_more.controllers;

import com.springboot.employeeapiboot.one_to_more.dto.CompanyDTO;
import com.springboot.employeeapiboot.one_to_more.entities.Company;
import com.springboot.employeeapiboot.one_to_more.respositories.CompanyRepository;
import com.springboot.employeeapiboot.one_to_more.respositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanysController {
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    public CompanysController(CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
    }
    @Transactional
    @GetMapping(path="",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Company>> getAllCompany(){
        return ResponseEntity.ok(companyRepository.findAll());
        //return companyRepository.findAll();
    }
    @Transactional
    @GetMapping(path="/{id}")
    public CompanyDTO getCompanyById(@PathVariable long id){
            //employeeRepository.findAllById(id);
          Company  company  =companyRepository.findById(id).get();
        //return companyRepository.findById(id).get();
        return new CompanyDTO(company);
    }
    @Transactional
    @PostMapping(path="")
    public Company addOneCompany(@RequestBody Company company){
        company.getEmployees().stream().forEach(employee ->{
            employee.setCompany(company);
        });
        return companyRepository.save(company);
        //return company;
    }
    @Transactional
    @PutMapping("/{id}")
    public Company modifyCompanyById(@RequestBody Company company){
        company.getEmployees().stream().filter(employee -> employee.getCompany() == null).forEach(employee -> {
            employee.setCompany(company);});
        //ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return companyRepository.save(company);
    }
    @DeleteMapping("/{id}")
    public Company deleteCompanyById(@PathVariable long id){
        Company company=companyRepository.findById(id).get();
        companyRepository.deleteById(id);
        return company;
    }
}
