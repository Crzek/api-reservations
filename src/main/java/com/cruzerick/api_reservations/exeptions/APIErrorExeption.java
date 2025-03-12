package com.cruzerick.api_reservations.exeptions;

import org.springframework.http.HttpStatus;
import com.cruzerick.api_reservations.enums.APIError;

import java.util.List;

public class APIErrorExeption extends RuntimeException{
    private HttpStatus status;
    private String description;
    private List<String> reasons;

    // Crear package enums y crear APIError.java
    public APIErrorExeption(APIError error) {
        this.status = error.getHttpStatus();
        this.description = error.getMessage();
    }

    public APIErrorExeption(HttpStatus status, String description, List<String> reasons) {
        this.status = status;
        this.description = description;
        this.reasons = reasons;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getReasons() {
        return reasons;
    }

    public void setReasons(List<String> reasons) {
        this.reasons = reasons;
    }
}
