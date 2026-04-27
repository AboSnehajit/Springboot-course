package com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.dto;


import jakarta.persistence.PostUpdate;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.PrimeNumberValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentDto {

//    @Null(message = "Id must be null when creating a new department")
    private Long depId;

    @NotBlank(message = "Title is required")
    private String title;

    @AssertTrue(message = "Department must be Active")
    private Boolean isActive;

    @Range(min =1 , max=2000 , message = "Employee count must be between 1 and 2000")
    private  Integer employeeCount;

    @Positive(message = "Budget must be positive")
    @Digits(integer= 10 , fraction = 2)
    private Double budget;

    @DecimalMin(value = "1000.00")
    @DecimalMax(value = "1000000.00")
    private Double annualExpense;

    @Pattern(regexp ="^[A-Z]{2}-\\d{2}$", message = "Department code must be in the format HR-01")
    private String deptCode;

    @NotEmpty(message = "Tags cannot be empty")
    private String tags ;


    @Email(message = "Department email must be valid")
    private  String departmentEmail;

    @URL(message = "Website must be a valid URL")
    private String website;

    @Future(message = "Audit date must be in the future")
    private LocalDateTime nextAuditDate;


    @FutureOrPresent
    private LocalDateTime policyEffectiveDate;

}
