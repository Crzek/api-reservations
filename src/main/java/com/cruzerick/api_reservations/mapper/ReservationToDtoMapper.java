package com.cruzerick.api_reservations.mapper;

import com.cruzerick.api_reservations.dto.ReservationDTO;
import com.cruzerick.api_reservations.models.Reservation;
import org.springframework.core.convert.converter.Converter;

public interface ReservationToDtoMapper extends Converter<Reservation, ReservationDTO> {
    // Esto pasa de modelo a dto
    @Override
    ReservationDTO convert(Reservation source);
}
