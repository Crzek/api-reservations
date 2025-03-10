package com.cruzerick.api_reservations.controller;

import com.cruzerick.api_reservations.dto.ReservationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getReservations(){
        List<ReservationDTO> response = new ArrayList<>();
        response.add(new ReservationDTO());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationsById(@PathVariable long id){
        ReservationDTO response = new ReservationDTO();
        response.add(new ReservationDTO());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ReservationDTO> createReservations(@RequestBody ReservationDTO reservation){
        ReservationDTO response = new ReservationDTO();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> updateReservations(@PathVariable long id,@RequestBody ReservationDTO reservation){
        ReservationDTO response = new ReservationDTO();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> getReservations(@PathVariable long id){
        ReservationDTO response = new ReservationDTO();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
