package com.springboot.employeeapiboot.one_to_more.respositories;

import com.springboot.employeeapiboot.one_to_more.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    @Transactional
    int deleteCompanyById(@Param("id") Long id);
}
