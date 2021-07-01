package com.restaurant.reservationApp.Guest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class GuestRepositoryImpl implements GuestRepository{
    private List<Guest> list =new ArrayList<>(Arrays.asList(
            new Guest(1, "Aysegul", "Aydar", 1234578, 4),
            new Guest(2, "Ayse", "Kocak", 12345678, 5),
            new Guest(3, "Saif", "Alamrani", 1234567, 1),
            new Guest(4, "Zeynel", "Goksu", 12345678)

    ));

    public GuestRepositoryImpl() {

    }

        @Override
        public List<Guest> getAllGuests() {
            return list;
        }
        @Override
        public Guest getGuestById(long id) {
            Optional<Guest> guest1 = list.stream().filter(guest -> guest.getId() == id).findFirst();
            return guest1.get();
        }

    @Override
    public Guest createGuest(Guest guest) {
        guest.setId(list.size()+1);
        list.add(guest);
        return guest;
    }
}
