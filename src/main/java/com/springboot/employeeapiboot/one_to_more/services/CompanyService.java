package com.springboot.employeeapiboot.one_to_more.services;

import com.springboot.employeeapiboot.one_to_more.dto.CompanyDTO;
import com.springboot.employeeapiboot.one_to_more.entities.Company;
import com.springboot.employeeapiboot.one_to_more.respositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;
    @Autowired
    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
    }


    public List<Company> getAllCompany() {
       return  companyRepository.findAll();
    }

    public Company addOneCompany(Company company) {
        company.getEmployees().stream().forEach(employee ->{
            employee.setCompany(company);
        });
        return companyRepository.save(company);
    }

    public Company modifyCompanyById(Company company) {
        company.getEmployees().stream().filter(employee -> employee.getCompany() == null).forEach(employee -> {
            employee.setCompany(company);});
        return companyRepository.save(company);
    }

    public boolean deleteCompanyById(long id) {
        //Company company=companyRepository.findById(id).get();
        int deleteCompanyById=companyRepository.deleteCompanyById(id);
        return deleteCompanyById!=0;
    }

    public CompanyDTO getCompanyById(long id) {
        Company  company  =companyRepository.findById(id).get();
        return new CompanyDTO(company);
    }
}
