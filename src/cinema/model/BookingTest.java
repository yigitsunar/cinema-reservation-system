package cinema.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {

    private Customer customer;
    private Movie movie;
    private ShowTime showTime;
    private Seat seat;

    @BeforeEach
    void setUp() {
        customer = new Customer(1, "Ahmet Yılmaz", "ahmet@gmail.com", "05551234567");
        movie = new Movie2D("Inception", "Sci-Fi", 148, 100.0);
        showTime = new ShowTime(movie, "2025-01-10", "18:00");
        seat = new Seat(5, "A", true);
    }

    @Test
    void testBookingCreation() {
        Booking booking = new Booking(1, customer, showTime, seat);

        assertEquals(1, booking.getBookingId());
        assertEquals(customer, booking.getCustomer());
        assertEquals(showTime, booking.getShowTime());
        assertEquals(seat, booking.getSeat());
        assertEquals(100.0, booking.getPrice());
    }

    @Test
    void testBookingReservesSeat() {
        assertTrue(seat.isAvailable());

        Booking booking = new Booking(1, customer, showTime, seat);

        assertFalse(seat.isAvailable());
    }

    @Test
    void testBookingWith3DMovie() {
        Movie3D movie3D = new Movie3D("Avatar", "Fantasy", 162, 120.0, 30.0);
        ShowTime showTime3D = new ShowTime(movie3D, "2025-01-10", "21:00");

        Booking booking = new Booking(2, customer, showTime3D, seat);

        assertEquals(150.0, booking.getPrice());
    }
}