package com.cruzerick.api_reservations.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IataFormatValidator.class) // Define the class that will validate the annotation
@Target({ElementType.METHOD, ElementType.FIELD}) // Define where the annotation can be used
@Retention(RetentionPolicy.RUNTIME) // Define when the annotation will be used
public @interface IataFormatConstrainst {
    // Mensaje custom
    String message() default "IATA code must have 3 characters";

    // Standart annotation for validation
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
