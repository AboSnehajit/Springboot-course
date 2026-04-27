package com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.PrimeNumberValidation;

public class PrimeNumberValidator  implements ConstraintValidator<PrimeNumberValidation,Integer > {


    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if (integer == null) {
            return false;
        }

        for (int i = 2; i <integer ; i++) {
            if(integer % i == 0){return false;}
        }
        return true;
    }
}
