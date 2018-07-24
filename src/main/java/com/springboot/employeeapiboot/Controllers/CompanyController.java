package com.springboot.employeeapiboot.Controllers;

import com.springboot.employeeapiboot.Cores.Company;
import com.springboot.employeeapiboot.Cores.Employee;
import com.springboot.employeeapiboot.Services.CompanyService;
import com.springboot.employeeapiboot.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @Autowired
    EmployeeService employeeService;
    @GetMapping("")
    public ArrayList<Company> getAllCompanies(){
//        employeeService.getEmployees();
//        Company company=new Company("alibaba",employeeService.getEmployees());
//        ArrayList<Company> companies=new ArrayList<>();
//        companies.add(company);
//       companyService.setCompanies(companies);
       return companyService.getCompanies();
    }
    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable int id){
        return companyService.getCompanyById(id);
    }
    @PostMapping("")
    public ArrayList<Company> postCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }
//    @PutMapping("{/id}")
//    public ArrayList<Company> putCompany(@PathVariable long id,@RequestBody Company company){
//        return companyService.updateCompany(id,company);
//    }

}
