package com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.controllers;

import com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.dto.EmployeeDto;
import com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {


//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage()
//    {
//        return "This is Raja's secret";
//    }

//     final EmployeeRepository employeeRepository;


    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

        @GetMapping(path="/{employeeId}")
    public EmployeeDto getEmployeeByID(@PathVariable(name = "employeeId") Long Id)
    {
//        return new EmployeeDto(Id,"Snehajit", "King@gmail.com",23, LocalDate.ofYearDay(2024,135),true);

//        return employeeRepository.findById(Id).orElse(null);

          return employeeService.getEmployeeByID(Id);
    }

@GetMapping
    public List<EmployeeDto> getAllEmployees(@RequestParam(required = false) Integer age , @RequestParam(required = false) Integer worth)
    {
//        return "Hello this is Snehajit with"+age+" and worth of"+worth;

//        return employeeRepository.findAll();

        return employeeService.getAllEmployees();
    }

    @PostMapping()
    public  EmployeeDto createEmployee(@RequestBody EmployeeDto inputEmployee)
    {
//        inputEmployee.setId(100L);
//        return inputEmployee;

//        return employeeRepository.save(inputEmployee);

        return employeeService.createEmployee(inputEmployee);
    }

    @PutMapping String updateEmployeeById()
    {
        return "Hello from Put Mapping";
    }





}
