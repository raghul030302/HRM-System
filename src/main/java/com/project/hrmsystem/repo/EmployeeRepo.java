package com.project.hrmsystem.repo;

import com.project.hrmsystem.dto.EmployeeUpdateDto;
import com.project.hrmsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    boolean existsById(EmployeeUpdateDto empupdate);

}
