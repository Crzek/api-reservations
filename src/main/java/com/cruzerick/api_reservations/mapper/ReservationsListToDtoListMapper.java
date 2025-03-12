package com.cruzerick.api_reservations.mapper;

import com.cruzerick.api_reservations.dto.ReservationDTO;
import com.cruzerick.api_reservations.models.Reservation;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

public interface ReservationsListToDtoListMapper
        extends Converter<List<Reservation>, List<ReservationDTO>> {

    // Esto pasa de lista de modelos a lista de dtos
    @Override
    List<ReservationDTO> convert(List<Reservation> source);
}
