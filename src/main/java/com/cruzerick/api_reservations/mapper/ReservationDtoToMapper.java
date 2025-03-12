package com.cruzerick.api_reservations.mapper;

import com.cruzerick.api_reservations.dto.ReservationDTO;
import com.cruzerick.api_reservations.models.Reservation;
import org.springframework.core.convert.converter.Converter;

public interface ReservationDtoToMapper extends Converter<ReservationDTO, Reservation> {
   // esto pasa de dto a modelo
    @Override
    Reservation convert(ReservationDTO source);
}
