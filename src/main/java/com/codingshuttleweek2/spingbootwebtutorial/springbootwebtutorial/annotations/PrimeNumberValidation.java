//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jakarta.validation.constraints;

import com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.annotations.PrimeNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)

@Constraint(
        validatedBy = {PrimeNumberValidator.class}
)
public @interface PrimeNumberValidation{
    String message() default "Element must be a Prime Number ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
