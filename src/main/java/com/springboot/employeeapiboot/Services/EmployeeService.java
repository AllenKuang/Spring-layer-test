package com.springboot.employeeapiboot.Services;

import com.springboot.employeeapiboot.Cores.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class EmployeeService {
    private ArrayList<Employee> employees;
    public EmployeeService(){
        this.employees=new ArrayList<>();
        this.add(new Employee(1,"小明",20,"男"));
        this.add(new Employee(2,"小红",20,"女"));
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void add(Employee employee){
        this.employees.add(employee);
    }

    public void patch(int id, Employee employee) {
        Employee tempemploy=null;
        for(Employee employ:this.employees){
            if(id==employ.getId()){
                employ.setId(id);
                employ.setName(employee.getName());
                employ.setAge(employee.getAge());
                employ.setGender(employee.getGender());
                tempemploy=employ;
            }
        }
//        return tempemploy;
    }

    public ArrayList<Employee> delete(int id) {
        for(int i=0;i<this.employees.size();i++){
            if(id==this.employees.get(i).getId()){
                this.employees.remove(i);
            }
        }
        return this.getEmployees();
    }

    public ArrayList<Employee> put(int id, Employee employee) {
        for(int i=0;i<this.getEmployees().size();i++){
            if (this.getEmployees().get(i).getId()==id){
                this.getEmployees().set(i,new Employee(id,employee.getName(),employee.getAge(),employee.getGender()));
            }
        }
        return this.getEmployees();
    }

    public Employee getEmployeebyId(int id) {
        for(Employee employee:this.getEmployees()){
            if(id==employee.getId()){
                return employee;
            }
        }
        return null;
    }

    public ArrayList<Employee> getEmployeebyGender() {
        ArrayList<Employee> tempEmployees=new ArrayList<>();
        for(Employee employee:this.getEmployees()){
            if(employee.getGender().equals("男")){
                tempEmployees.add(employee);
            }
        }
        return tempEmployees;
    }

    public ArrayList<Employee> getEmployeesbyPagesize(int page,int pageSize) {
        ArrayList<Employee> tempEmployees=new ArrayList<>();
        for(int i=page-1;i<pageSize;i++){
            tempEmployees.add(this.getEmployees().get(i));
        }
        return tempEmployees;
    }
}
