package cinema.service;

import cinema.model.Seat;
import cinema.model.Booking;
import cinema.model.Customer;
import cinema.model.Movie2D;
import cinema.model.ShowTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class CinemaServiceTest {

    private CinemaService service;
    private Seat seat;

    @BeforeEach
    void setUp() {
        service = new CinemaService();
        seat = new Seat(5, "A", true);
    }

    @Test
    void testBookSeat() {
        Seat newSeat = new Seat(3, "B", true);
        service.bookSeat(newSeat);

        assertFalse(service.isSeatAvailable("B3"));
        assertEquals(1, service.getReservedSeatCount());
    }

    @Test
    void testIsSeatAvailable() {
        assertTrue(service.isSeatAvailable("A5"));

        service.bookSeat(seat);

        assertFalse(service.isSeatAvailable("A5"));
    }
}