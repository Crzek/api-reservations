package com.cruzerick.api_reservations.controller;

import com.cruzerick.api_reservations.controller.resources.ReservationResource;
import com.cruzerick.api_reservations.dto.ReservationDTO;
import com.cruzerick.api_reservations.services.ReservationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
@RequestMapping("/reservations")
public class ReservationController implements ReservationResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

    private ReservationService service;

    @Autowired
    public ReservationController(ReservationService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getReservations(){
        LOGGER.info("ejeuctando getReservations");
        List<ReservationDTO> response = service.getReservations();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationsById(@Min(1) @PathVariable long id){
        ReservationDTO response = service.getReservationById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> createReservations(@Valid @RequestBody ReservationDTO reservation){
        ReservationDTO response = service.save(reservation);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> updateReservations(@Min(1) @PathVariable long id,@Valid @RequestBody ReservationDTO reservation){
        ReservationDTO response = service.update(id, reservation);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservations(@Min(1) @PathVariable long id){
        LOGGER.debug("Deleting reservation with id: {} ", id);
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
