package com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.dto;

import com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
      private Long id;

      @NotEmpty(message="Name is required")
      @Size(max = 20, min = 3, message = "Name must be between 3 and 20 characters")
     private String name;

      @NotBlank(message = "Email is required")
      @Email(message = "Invalid email address")
     private String email;

      @NotNull(message="Age is required")
      @Max(value = 100, message = "Age must be less than 100")
      @Min(value = 18, message = "Age must be greater than 18")
      private Integer age ;

      @NotBlank(message = "Role of employee cannot be blank")
//      @Pattern(regexp = "^(ADMIN|USER)$", message = "Role must be ADMIN or USER")
      @EmployeeRoleValidation
      private  String role; //ADMIN,USER

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be positive")
    @Digits(integer = 6, fraction = 2, message = "Salary must be a positive number with up to 2 decimal places")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;


    @PastOrPresent(message = "Date of joining must be in the past or present")
     private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee must be active ")
     @JsonProperty("isActive")
     private Boolean isActive;


}
