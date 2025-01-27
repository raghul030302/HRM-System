package com.project.hrmsystem.controller;



import com.project.hrmsystem.dto.EmployeeUpdateDto;
import com.project.hrmsystem.entity.Employee;
import com.project.hrmsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class controller {

    @Autowired
    private EmployeeService empService;

    @PostMapping(path = "/post")
    public String saveEmployee(@RequestBody Employee emp) {

        return empService.addEmployee(emp);

    }
    @GetMapping (path = "/view")
    public List<Employee> viewEmployees() {
        return empService.viewEmployee();
    }

    @PutMapping(path = "/put")
    public String updateEmployee(@RequestBody EmployeeUpdateDto empupdatedto) {
        return empService.updateEmployee(empupdatedto);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int id) {
        boolean deleteemp = empService.deleteEmployee(id);
        return "deleted";
    }
}
