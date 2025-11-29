package com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.controllers;

import com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.dto.EmployeeDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage()
//    {
//        return "This is Raja's secret";
//    }

    @GetMapping(path="/{employeeId}")
    public EmployeeDto getEmployeeByID(@PathVariable(name = "employeeId") Long Id)
    {
        return new EmployeeDto(Id,"Snehajit", "King@gmail.com",23, LocalDate.ofYearDay(2024,135),true);
    }

@GetMapping
    public String getAllEmployees(@RequestParam(required = false) Integer age , @RequestParam(required = false) Integer worth)
    {
        return "Hello this is Snehajit with"+age+" and worth of"+worth;
    }

    @PostMapping()
    public  EmployeeDto createEmployee(@RequestBody EmployeeDto inputEmployee)
    {
        inputEmployee.setId(100L);
        return inputEmployee;
    }

    @PutMapping String updateEmployeeById()
    {
        return "Hello from Put Mapping";
    }





}
