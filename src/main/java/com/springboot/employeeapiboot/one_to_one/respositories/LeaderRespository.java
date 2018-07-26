package com.springboot.employeeapiboot.one_to_one.respositories;

import com.springboot.employeeapiboot.one_to_one.entities.Leader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderRespository extends JpaRepository<Leader,Long> {
}
