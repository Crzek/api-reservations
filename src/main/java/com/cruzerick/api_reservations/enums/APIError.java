package com.cruzerick.api_reservations.enums;

import org.springframework.http.HttpStatus;

public enum APIError {
    // Enum to manage the errors, modifica si quieres otros mensajes
    MSG_VALIDATION_ERROR(HttpStatus.BAD_REQUEST,"The are attributes with wrong values"),
    MSG_BAD_FORMAT(HttpStatus.BAD_REQUEST,"The message not have a correct form"),
    MSG_NOT_FOUND(HttpStatus.NOT_FOUND, "Reservation not found"),
    MSG_WITH_SAME_ID(HttpStatus.BAD_REQUEST, "There is a reservation with the same id");

    private final HttpStatus httpStatus;
    private final String message;

    APIError(HttpStatus httpStatus, String message){
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
