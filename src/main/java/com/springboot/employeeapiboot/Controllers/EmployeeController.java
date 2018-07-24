package com.springboot.employeeapiboot.Controllers;
import com.springboot.employeeapiboot.Cores.Employee;
import com.springboot.employeeapiboot.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmployeeController{
//    List<Employee> employees=new ArrayList<>();
//    Employee employee1=new Employee(0,"小明",20,"男");
//    employees.add(employee1);
    @RequestMapping("/hello")
    public String showHello(){
        return "hello";
    }
    @GetMapping("/employee")
    public Employee showEmployee(){
        Employee employee1=new Employee(0,"小明",20,"男",6000);
        return employee1;
    }
    @Autowired
    EmployeeService employeeService;//引入之前在IOC中已经注入的类，自动new 了
    @GetMapping("/employees")
    public ArrayList<Employee> showEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeebyId(@PathVariable int id){
        return employeeService.getEmployeebyId(id);
    }

    @GetMapping("/employees/male")
    public ArrayList<Employee> getEmployeebyGender(){
        return employeeService.getEmployeebyGender();
    }

    @GetMapping("/employees/page/{page}/pageSize/{pageSize}")
    public ArrayList<Employee> getEmployeesbyPagesize(@PathVariable int page,@PathVariable int pageSize){
        return employeeService.getEmployeesbyPagesize(page,pageSize);
    }

    @PostMapping("/employees")
    public ArrayList<Employee> postEmployee(@RequestBody Employee employee){
        employeeService.add(employee);
        return employeeService.getEmployees();
    }

    @PutMapping ("/employees/{id}")
    public ArrayList<Employee> patchEmployee(@PathVariable int id,@RequestBody Employee employee){
        return employeeService.put(id,employee);
    }

    @DeleteMapping ("/employees/{id}")
    public ArrayList<Employee> deleteEmployee(@PathVariable int id){
        return employeeService.delete(id);

    }
//    @DeleteMapping ("/employees")
//    public void deleteEmployee(@RequestParam int id){
//         employeeService.delete(id);
//
//    }

//    @PatchMapping ("/employees/{id}")
//    public Employee patchEmployee(@PathVariable int id,@RequestBody Employee employee){
//        return employeeService.patch(id,employee);
//    }

}
