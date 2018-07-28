package com.springboot.employeeapiboot;

import com.springboot.employeeapiboot.one_to_more.entities.Company;
import com.springboot.employeeapiboot.one_to_more.respositories.CompanyRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyRepositoryTest {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void getCompanyById(){
        //given
        Company savedCompany=entityManager.persistFlushFind(new Company("oocl"));

        //when
        Company company=companyRepository.findById(1L).get();

        //then
        Assertions.assertThat(company.getName()).isEqualTo(savedCompany.getName());
    }
    @Test
    public void getAllCompany(){
        //given
        //Company savedCompany=entityManager.persistFlushFind(new Company("oocl"));
        entityManager.persist(new Company("tw"));
        entityManager.persist(new Company("oocl"));
        //when
        List<Company> companys=companyRepository.findAll();

        //then
        assertThat(companys.size(),is(2));
        assertThat(companys.get(0).getName(),is("tw"));
        assertThat(companys.get(1).getName(),is("oocl"));
        //Assertions.assertThat(companys.get(0).getName()).isEqualTo(savedCompany.getName());
        }

    @Test
    public void addOneCompany(){
        //given
        entityManager.persist(new Company("tw"));

        //when
        Company company=companyRepository.save(new Company("oocl"));

        assertThat(company.getName(),is("oocl"));

        }

    @Test
    public void delteCompanyById(){
        //given
        entityManager.clear();
        entityManager.persist(new Company("tw"));

        //when
        System.out.println(companyRepository.findAll().size());
        //Long deleteId=
        companyRepository.deleteById(1L);

        //then
        assertThat(companyRepository.findAll().size(),is(0));
        }
        @Test
        public void modifyCompanyById(){
            //given
            entityManager.persist(new Company("tw"));

            //when
            //companyRepository.save(new Company(1L,"tw"));

            }
}
