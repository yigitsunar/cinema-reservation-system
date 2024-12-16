package cinema.interfacepkg;

import cinema.model.Seat;
import cinema.model.Booking;

/**
 * Rezervasyon islemleri icin interface.
 * Koltuk rezervasyonu ve iptal islemlerini tanimlar.
 */
public interface Bookable {

    void bookSeat(Seat seat);

    void cancelBooking(Booking booking);
}
