package com.restaurant.reservationApp.reservation;

import com.restaurant.reservationApp.Table.Table;
import com.restaurant.reservationApp.Table.TableService;
import com.restaurant.reservationApp.employee.Employee;
import com.restaurant.reservationApp.employee.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ReservationController {
    ReservationService reservationService;
    private Reservation reservation;

    public ReservationController(){
    }
    @Autowired
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping("/allreservations")
    public ResponseEntity<List<Reservation>> getAllReservation() {

        List<Reservation> allReservation = reservationService.getAllReservation();
        return new ResponseEntity<>(allReservation, HttpStatus.OK);
    }
    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable(name = "id", required = true) long id) {
        Reservation reservation = reservationService.getReservationById(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @PutMapping(value = "/reservation", produces = "application/json",consumes = "application/json")
    public ResponseEntity<Reservation> Reservation(@RequestParam( name="reservation", required =false )String wish) {
        if (wish == "create") {
            Reservation reservation1 = reservationService.createReservation(reservation);
            return new ResponseEntity<>(reservation1, HttpStatus.OK);
        }
        if (wish == "delete") {
            Reservation reservation1 = reservationService.deleteReservation(reservation);
            return new ResponseEntity<>(reservation1, HttpStatus.OK);
        }
        return null;
//    @PutMapping(value = "/reservation", produces = "application/json",consumes = "application/json")
//    public ResponseEntity<Reservation> Reservation(@RequestBody Reservation reservation){
//        Reservation reservation1 = reservationService.deleteReservation(reservation);
//        return new ResponseEntity<>(reservation1, HttpStatus.OK);
//    }
    }}
