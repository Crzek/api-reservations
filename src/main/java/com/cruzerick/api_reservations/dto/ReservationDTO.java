package com.cruzerick.api_reservations.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class ReservationDTO {
    private Long id;

    @Valid // para que valide que contenga los campos de PassengerDTO
    @NotEmpty(message = "Passengers are required")
    private List<PassengerDTO> passengers;

    @Valid // para que valide que contenga los campos de ItineraryDTO
    private ItineraryDTO itinerary;

    public List<PassengerDTO> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerDTO> passengers) {
        this.passengers = passengers;
    }

    public ItineraryDTO getItinerary() {
        return itinerary;
    }

    public void setItinerary(ItineraryDTO itinerary) {
        this.itinerary = itinerary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
