package com.project.hrmsystem.service;


import com.project.hrmsystem.dto.EmployeeUpdateDto;
import com.project.hrmsystem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    String addEmployee(Employee empsavedto);

    List<Employee> viewEmployee();
    String updateEmployee(EmployeeUpdateDto empupdatedto);

    boolean deleteEmployee(int id);
}
