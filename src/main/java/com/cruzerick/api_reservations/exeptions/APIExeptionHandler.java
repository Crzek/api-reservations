package com.cruzerick.api_reservations.exeptions;

import com.cruzerick.api_reservations.dto.ErrorDTO;
import com.cruzerick.api_reservations.enums.APIError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class APIExeptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(APIErrorExeption.class) // capturar excepciones de tipo APIErrorExeption
    public ResponseEntity<ErrorDTO> duplicateResource(APIErrorExeption e, WebRequest request){
        ErrorDTO error = new ErrorDTO(e.getDescription(), e.getReasons());
        return ResponseEntity.status(e.getStatus()).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {

        // definir como se ven los errores de validacion
        List<String> reasons = new ArrayList<>();

        for(FieldError error : ex.getBindingResult().getFieldErrors()) {
            reasons.add(String.format("%s - %s", error.getField(), error.getDefaultMessage()));
        }

        return ResponseEntity.status(APIError.MSG_VALIDATION_ERROR.getHttpStatus())
                .body(new ErrorDTO(APIError.MSG_VALIDATION_ERROR.getMessage(), reasons));
    }
}
