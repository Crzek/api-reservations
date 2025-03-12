package com.cruzerick.api_reservations.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// Se implementa la interfaz ConstraintValidator
// Se define el tipo de anotacion que se va a validar y el tipo de dato que se va a validar
public class IataFormatValidator implements ConstraintValidator<IataFormatConstrainst, String> {

    @Override
    public void initialize(IataFormatConstrainst constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        // Aqui se define la logica de validacion
        return field != null &&
                field.length() == 3 &&
                // Validar que sean solo letras mayusculas
                field.matches("[A-Z]{3}");
    }
}
