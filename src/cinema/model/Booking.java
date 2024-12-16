package cinema.model;

/**
 * Rezervasyon bilgilerini tutan sinif.
 * Musteri, seans, koltuk ve fiyat bilgilerini icerir.
 */

public class Booking {

    private int bookingId;
    private Customer customer;
    private ShowTime showTime;
    private Seat seat;
    private double price;

    public Booking(int bookingId, Customer customer, ShowTime showTime, Seat seat) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.showTime = showTime;
        this.seat = seat;

        // Polymorphism: Movie2D / Movie3D fark etmez
        this.price = showTime.getMovie().calculatePrice();

        // Koltuk rezerve edilir
        this.seat.reserve();
    }

    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public Seat getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }
}
