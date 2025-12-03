package com.codingshuttle.springbootwebtutorial.controllers;

import com.codingshuttle.springbootwebtutorial.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    // GET /employees/{employeeId}
    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        // demo: returning a fixed DTO for the given id
        return new EmployeeDTO(
                id,
                "Anuj",
                "anuj@gmail.com",
                27,
                LocalDate.of(2024, 1, 1),
                true
        );
    }

    // GET /employees?inputAge=23&sortBy=name
    @GetMapping
    public String getAllEmployees(
            @RequestParam(required = false, name = "inputAge") Integer age,
            @RequestParam(required = false) String sortBy) {

        return "Hi age " + age + " sortBy " + sortBy;
    }

    // POST /employees
    // Body JSON -> EmployeeDTO
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        // demo: set a server-side id and return the object
        employeeDTO.setId(100L);
        return employeeDTO;
    }
}