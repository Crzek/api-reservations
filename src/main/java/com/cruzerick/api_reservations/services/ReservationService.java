package com.cruzerick.api_reservations.services;

import com.cruzerick.api_reservations.dto.ReservationDTO;
import com.cruzerick.api_reservations.enums.APIError;
import com.cruzerick.api_reservations.exeptions.APIErrorExeption;
import com.cruzerick.api_reservations.exeptions.MsgExeption;
import com.cruzerick.api_reservations.models.Reservation;
import com.cruzerick.api_reservations.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReservationService {
    private ReservationRepository repository;

    // propio de SpringBoot
    // para los mappers de mapstruct
    private ConversionService conversionService;

    // El autoinjeccion se hace en el constructor
    @Autowired
    public ReservationService(ReservationRepository repository,
                              ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    // Metodos de Services
    // siempre Retorna DTO ConversionService (class de SpringBoot)
    public List<ReservationDTO> getReservations() {
        // esto siempre es igual o le pasamos la clase con el metodo y dependiendo de lo que retorne
        // si retorna:
        //      - List: List.class
        //      - Obj: <classDTO>.class
        // ConversionService gracias a mapstruct
        return  conversionService.convert(repository.getReservations(), List.class);
    }

    public ReservationDTO getReservationById(Long id) {
        Optional<Reservation> result = repository.getReservationById(id);
        if(result.isEmpty()) {
//            throw new MsgExeption("Not exist");
            throw new APIErrorExeption(APIError.MSG_NOT_FOUND);
        }
        return conversionService.convert(result.get(), ReservationDTO.class);
    }

    public ReservationDTO save(ReservationDTO reservation) {
        if(Objects.nonNull(reservation.getId())) {
//            throw new MsgExeption("Duplicate it");
            throw new APIErrorExeption(APIError.MSG_WITH_SAME_ID);
        }

        Reservation transformed = conversionService.convert(reservation, Reservation.class);
        Reservation result = repository.save(Objects.requireNonNull(transformed));
        return conversionService.convert(result, ReservationDTO.class);
    }

    public ReservationDTO update(Long id, ReservationDTO reservation) {
        if(getReservationById(id) == null) {
//            throw new MsgExeption("Not exist");
            throw  new  APIErrorExeption(APIError.MSG_NOT_FOUND);
        }

        Reservation transformed = conversionService.convert(reservation, Reservation.class);
        Reservation result = repository.update(id, Objects.requireNonNull(transformed));
        return conversionService.convert(result, ReservationDTO.class);
    }

    public void delete(Long id) {
        if(getReservationById(id) == null) {
//            throw new MsgExeption("Not exist");
            throw  new  APIErrorExeption(APIError.MSG_NOT_FOUND);
        }

        repository.delete(id);
    }
}
