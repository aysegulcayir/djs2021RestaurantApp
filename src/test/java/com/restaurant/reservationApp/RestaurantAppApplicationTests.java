package com.restaurant.reservationApp;

import com.restaurant.reservationApp.reservation.Reservation;
//import com.restaurant.reservationApp.stubs.StubReservationService;
import com.restaurant.reservationApp.reservation.ReservationController;
import com.restaurant.reservationApp.reservation.ReservationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class RestaurantAppApplicationTests {

	@Mock
	ReservationService mockedService;

	@InjectMocks
	ReservationController reservationController;

	@Test
	public void getAmountOfGuest() {

		//Reservation reservation = new Reservation();
		when(mockedService.getAmountOfGuest()).thenReturn(Map.of("Mustafa",100L));
		ResponseEntity<Map<String, Long>> value = reservationController.getAmountOfGuestSoFar();
		Assertions.assertEquals(new ResponseEntity<>(Map.of("Mustafa",100L), HttpStatus.OK), value);
//		StubReservationService stubReservationService = new StubReservationService();
//		Map<String, Long> amountOfGuest = stubReservationService.getAmountOfGuest();
//		Assertions.assertEquals(Map.of("Mustafa",100L),amountOfGuest);


	}

}
