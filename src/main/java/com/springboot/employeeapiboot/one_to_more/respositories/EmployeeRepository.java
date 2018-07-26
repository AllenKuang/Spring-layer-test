package com.springboot.employeeapiboot.one_to_more.respositories;

import com.springboot.employeeapiboot.one_to_more.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
