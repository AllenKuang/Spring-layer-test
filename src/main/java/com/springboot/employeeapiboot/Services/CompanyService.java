package com.springboot.employeeapiboot.Services;

import com.springboot.employeeapiboot.Cores.Company;
import com.springboot.employeeapiboot.Cores.Employee;
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

    public Company updateCompany(long id, Company putcompany) {
        for(Company company:this.getCompanies()){
            if(company.getId()==id){
                company=putcompany;
                return putcompany;
            }
        }
        return null;
    }

    public ArrayList<Company> deleteCompany(int id, Company deleteCompany) {
        for(int i=0;i<this.companies.size();i++){
            if(id==this.companies.get(i).getId()){
                this.companies.get(i).getEmployees().clear();
                this.companies.remove(i);
            }
        }
        return this.companies;
    }

    public ArrayList<Employee> getCompanyEmployee(int id) {
        for(Company company:this.companies){
            if(id==company.getId()){
                return company.getEmployees();
            }
        }
        return null;
    }
}
