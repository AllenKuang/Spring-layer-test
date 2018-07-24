package com.springboot.employeeapiboot.Services;

import com.springboot.employeeapiboot.Cores.Company;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CompanyService {
    private ArrayList<Company> companies;

    public CompanyService(){
        this.companies=new ArrayList<>();
    }
    public ArrayList<Company> getAllCompanies(){
        return this.getCompanies();
    }

    public void setCompanies(ArrayList<Company> companies) {
        this.companies = companies;
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public ArrayList<Company> addCompany(Company company) {
        this.companies.add(company);
        return this.getCompanies();
    }

    public Company getCompanyById(int id ) {
        for(Company company:this.getCompanies()){
            if(company.getId()==id){
                return company;
            }
        }
        return null;
    }

//    public ArrayList<Company> updateCompany(long id, Company company) {
//
//    }
}
