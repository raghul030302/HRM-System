package com.project.hrmsystem.service;


import com.project.hrmsystem.dto.EmployeeUpdateDto;
import com.project.hrmsystem.entity.Employee;
import com.project.hrmsystem.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class empolyeeServiveImp implements EmployeeService{

    @Autowired
    private EmployeeRepo empRepo;

    @Override
    public String addEmployee(Employee empsavedto) {

        Employee emp = new Employee(
                empsavedto.getFirstName(),
                empsavedto.getLastName(),
                empsavedto.getEmail(),
                empsavedto.getPhone(),
                empsavedto.getJobTitle(),
                empsavedto.getDepartmentId(),
                empsavedto.getDateOfBirth(),
                empsavedto.getHireDate(),
                empsavedto.getSalary(),
                empsavedto.getAddress(),
                empsavedto.getStatus()
        );
        empRepo.save(emp);
        return emp.getFirstName() + " " + emp.getLastName();
    }

    @Override
    public List<Employee> viewEmployee() {
        return empRepo.findAll();
    }



    @Override
    public String updateEmployee(EmployeeUpdateDto empupdatedto) {
        if (empRepo.existsById(empupdatedto.getId()))
        {
            Employee emp = empRepo.getById(empupdatedto.getId());
            emp.setFirstName(empupdatedto.getFirstName());
            emp.setLastName(empupdatedto.getLastName());
            emp.setEmail(empupdatedto.getEmail());
            emp.setPhone(empupdatedto.getPhone());
            emp.setJobTitle(empupdatedto.getJobTitle());
            emp.setDepartmentId(empupdatedto.getDepartmentId());
            emp.setDateOfBirth(empupdatedto.getDateOfBirth());
            emp.setHireDate(empupdatedto.getHireDate());
            emp.setSalary(empupdatedto.getSalary());
            emp.setAddress(empupdatedto.getAddress());
            emp.setStatus(empupdatedto.getStatus());
            empRepo.save(emp);

        }
        else System.out.println("Employee not found");

        return null;
    }

    @Override
    public boolean deleteEmployee(int id) {

        if (empRepo.existsById(id))
        {
            empRepo.deleteById(id);
        }
        else System.out.println("Employee ID is not found");

        return true;
    }


}
