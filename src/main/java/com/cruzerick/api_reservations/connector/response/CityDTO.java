package com.cruzerick.api_reservations.connector.response;

public class CityDTO {
    // Defino lo que quiero que me devuelva el servicio
    private String name;
    private String code;
    private String timeZone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
