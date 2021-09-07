package com.restaurant.reservationApp.reservation;

import com.restaurant.reservationApp.employee.Employee;
import com.restaurant.reservationApp.table.Table;
import com.restaurant.reservationApp.table.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    TableService tableService;

    @Override
    public List<Reservation> getAllReservation() {
        List<Reservation> reservations = new ArrayList<>();
        Iterable<Reservation> reservationIterable = reservationRepository.findAll();
        reservationIterable.forEach(reservations::add);
        return reservations;
    }

    @Override
    public Optional<Reservation> getReservationById(long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(long id) {
        reservationRepository.deleteById(id);
    }

//    @Override
//    public Reservation updateReservation(Reservation reservation) {
//        return reservationRepository.save(reservation);
//    }


    @Override
    public Reservation updateReservation(Reservation reservation) {
        if (reservationRepository.existsById(reservation.getId())) {
            Optional<Reservation> reservation1 = reservationRepository.findById(reservation.getId());
            reservation1.get().setGuest(reservation.getGuest());
            reservation1.get().setReservationDate(reservation.getReservationDate());
            reservation1.get().setTable(reservation.getTable());
            reservation1.get().setId(reservation.getId());
//            reservation1.get().setEmployee(reservation.getEmployee());
            reservationRepository.save(reservation1.get());
            return reservation1.get();
        }
        return null; // //TO DO: We should handle to return null situation

    }

    @Override
    public List<Table> getAvailableTables(String dateAndTime) {
        return findAvailableTables(dateAndTime);
    }

    public List<Table> findAvailableTables(String dateAndTime) {
        List<Table> availableTableList = tableService.getAllTable();
        LocalDateTime dateTime = LocalDateTime.parse(dateAndTime);
        List<Reservation> reservationList = (List<Reservation>) reservationRepository.findAll();
        for (Reservation reservation : reservationList) {
            if (!(reservation.getReservationDate().isBefore(dateTime) || reservation.getReservationDate().isAfter(dateTime))) {
                availableTableList.remove(reservation.getTable());
            }
        }
        return availableTableList;
    }


    @Override
    public Map<String, Long> getAmountOfGuest() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.of(8,0);
        LocalDateTime startingTime = LocalDateTime.of(nowDate,nowTime);
        long amountOfAllGuest = getAllReservation().stream().count();
        long amountOfGuestSoFar = getAllReservation().stream().filter(reservation -> now.isAfter(reservation.getReservationDate())).count();
        long amountOfGuestWhoVisitPlanned = getAllReservation().stream().filter(reservation -> reservation.getReservationDate().isAfter(now)).count();
        long amountOfGuestWhoVisitContinue = 2;
        Map<String, Long> amountOfGuestMap = new HashMap<>();
        amountOfGuestMap.put("amountOfGuestSoFar", amountOfGuestSoFar);
        amountOfGuestMap.put("amountOfGuestWhoVisitPlanned", amountOfGuestWhoVisitPlanned);
        amountOfGuestMap.put("amountOfGuestWhoVisitContinue", amountOfGuestWhoVisitContinue);
        return amountOfGuestMap;
    }
}
