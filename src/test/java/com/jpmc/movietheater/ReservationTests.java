package com.jpmc.movietheater;

import com.jpmc.movietheater.domain.Customer;
import com.jpmc.movietheater.domain.Movie;
import com.jpmc.movietheater.domain.Reservation;
import com.jpmc.movietheater.domain.Showing;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationTests {

    @Test
    void totalFee() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                1,
                LocalDateTime.now()
        );
        assertTrue(new Reservation(customer, showing, 3).totalFee() == 37.5);
    }
}
