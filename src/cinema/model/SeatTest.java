package cinema.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SeatTest {

    private Seat seat;

    @BeforeEach
    void setUp() {
        seat = new Seat(5, "A", true);
    }

    @Test
    void testSeatCreation() {
        assertEquals(5, seat.getSeatNumber());
        assertEquals("A", seat.getRow());
        assertTrue(seat.isAvailable());
    }

    @Test
    void testReserveSeat() {
        assertTrue(seat.isAvailable());
        seat.reserve();
        assertFalse(seat.isAvailable());
    }

    @Test
    void testSetAvailable() {
        seat.setAvailable(false);
        assertFalse(seat.isAvailable());

        seat.setAvailable(true);
        assertTrue(seat.isAvailable());
    }
}