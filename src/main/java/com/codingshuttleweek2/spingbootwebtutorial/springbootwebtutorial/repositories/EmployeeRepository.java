package com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.repositories;

import com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long >{

}
