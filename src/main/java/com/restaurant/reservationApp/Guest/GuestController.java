package com.restaurant.reservationApp.Guest;

import com.restaurant.reservationApp.employee.Employee;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class GuestController {
    GuestService guestService;

    public GuestController() {
    }
    @Autowired
    public GuestController(GuestService guestService){
        this.guestService = guestService;
    }

    @GetMapping("/guests")
    public ResponseEntity<List<Guest>> getAllGuests() {

        List<Guest> allGuests = guestService.getAllGuests();
        return new ResponseEntity<>(allGuests, HttpStatus.OK);
    }
    @GetMapping("/guest/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable(name = "id", required = true) long id){
        Guest guest = guestService.getGuestById(id);
        return new ResponseEntity<>(guest, HttpStatus.OK);
    }
    @PutMapping(value = "/guest", produces = "application/json",consumes = "application/json")
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest){
        Guest guest1 = guestService.createGuest(guest);
        return new ResponseEntity<>(guest1, HttpStatus.OK);
    }
}
