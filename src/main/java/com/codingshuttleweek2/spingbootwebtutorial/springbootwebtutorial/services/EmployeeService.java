package com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.services;


import com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.dto.EmployeeDto;
import com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.util.ReflectionUtils.*;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public Optional<EmployeeDto> getEmployeeByID(Long id)
    {
//      return employeeRepository.findById(id).orElse(null);
//        EmployeeEntity emp= employeeRepository.findById(id).orElse(null);
//        return  mapper.map(emp, EmployeeDto.class);
//
//        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
//        return employeeEntity.map((employeeEntity1 -> mapper.map(employeeEntity1, EmployeeDto.class)));

        return employeeRepository.findById(id).map(employeeEntity -> mapper.map(employeeEntity, EmployeeDto.class));
    }


    public List<EmployeeDto> getAllEmployees()
    {
        List<EmployeeEntity> employeeEntities= employeeRepository.findAll();
         return employeeEntities
                .stream()
                .map(EmployeeEntity -> mapper.map(EmployeeEntity, EmployeeDto.class))
                .collect(Collectors.toList());
    }


    public EmployeeDto createEmployee(EmployeeDto inputEmployee) {
//        return employeeRepository.save(inputEmployee);


        EmployeeEntity toSaveEntity=mapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity= employeeRepository.save(toSaveEntity);
        return mapper.map(savedEmployeeEntity, EmployeeDto.class);
    }

    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto) {

        EmployeeEntity employeeEntity=mapper.map(employeeDto, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity=employeeRepository.save(employeeEntity);

        return mapper.map(savedEmployeeEntity, EmployeeDto.class);


    }


    boolean isExistByEmployeeId(Long employeeId) {
        return employeeRepository.existsById(employeeId);

    }
    public boolean deleteEmployeeById(Long employeeId) {

        boolean exists = employeeRepository.existsById(employeeId);
        if(isExistByEmployeeId(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return  true;
        }

        return false;
    }

    public EmployeeDto updatePartialEmployee(Long employeeId, Map<String, Object> updates) {

        if(isExistByEmployeeId(employeeId))
        {
            // get the employee
            EmployeeEntity employeeEntity= employeeRepository.findById(employeeId).get();
            updates.forEach((field, value) -> {
                Field fieldToBeUpdated =  ReflectionUtils.findField(EmployeeEntity.class, field);
                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
            });

                return  mapper.map(employeeRepository.save(employeeEntity), EmployeeDto.class);

        }
        else {
            return null;
        }
    }
}
