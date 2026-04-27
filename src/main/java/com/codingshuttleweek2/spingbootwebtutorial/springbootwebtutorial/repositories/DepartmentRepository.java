package com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.repositories;

import com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long > {
}
