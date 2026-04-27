package com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.dto;

import com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.PrimeNumberValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
      private Long id;


      @NotBlank(message = "password is required ")
      @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>]).*$",
              message = "Password must contain at least one uppercase letter, one lowercase letter, one special character")
      @Size(min = 10 , message = "Password must be at least 10 characters long")
      private String password ;

     @PrimeNumberValidation(message = "Cust Prime must be a prime number")
     private Integer custPrime;

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


    //Additional fields
    @Negative(message = "Penalty must be negative")
    private Double penalty;

    @NegativeOrZero(message = "POint decrement must be negative or zero")
    private Double pointDecrement;


    @PositiveOrZero(message = "Bonus must be positive or zero")
    private Double bonus;

    @NotEmpty(message = "Department code cant be empty")
    private String departmentCode;


    @Length(min = 5,max=10 , message = "Username must be between 5 and 10 characters")
    private String username;

    @Pattern(regexp =  "^[A-Z]{3}-\\d{3}$", message = "Code must follow pattern ABC-123")
    private String employeeCode;


    @Past(message = "Date of birth must be in the past")
    private  LocalDate dateOfBirth;

    @Future(message = "Contract end date must be in the future")
    private LocalDate tenureEndDate;

    @FutureOrPresent(message = "Review date must be in the future or present")
    private  LocalDate nextReviewDate;

    @AssertFalse(message = "Employee ust not be terminated")
    private Boolean isTerminated;


    @URL(message = "Portfolio URL must be a valid URL")
    private  String portfolioURL;

    @CreditCardNumber(message = "Credit card number must be valid")
    private  String creditCardNumber;

}
