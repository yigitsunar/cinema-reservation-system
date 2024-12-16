package cinema.service;

import cinema.interfacepkg.Bookable;
import cinema.model.Seat;
import cinema.model.Booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Sinema rezervasyon işlemlerini yöneten servis sınıfı.
 * Bookable interface'ini implement eder.
 */
public class CinemaService implements Bookable {

    private Map<String, Seat> reservedSeats;
    private List<Booking> bookings;

    /**
     * CinemaService constructor
     */
    public CinemaService() {
        this.reservedSeats = new HashMap<>();
        this.bookings = new ArrayList<>();
    }

    /**
     * Koltuk rezervasyonu yapar
     * @param seat Rezerve edilecek koltuk
     * @throws IllegalStateException Eğer koltuk zaten doluysa
     */
    @Override
    public void bookSeat(Seat seat) {
        String seatKey = seat.getRow() + seat.getSeatNumber();

        if (reservedSeats.containsKey(seatKey)) {
            throw new IllegalStateException("Bu koltuk zaten rezerve edilmiş: " + seatKey);
        }

        if (!seat.isAvailable()) {
            throw new IllegalStateException("Bu koltuk müsait değil: " + seatKey);
        }

        seat.reserve();
        reservedSeats.put(seatKey, seat);
        System.out.println("✅ Koltuk başarıyla rezerve edildi: " + seatKey);
    }

    /**
     * Rezervasyonu iptal eder
     * @param booking İptal edilecek rezervasyon
     * @throws IllegalArgumentException Eğer rezervasyon bulunamazsa
     */
    @Override
    public void cancelBooking(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("Rezervasyon bulunamadı");
        }

        Seat seat = booking.getSeat();
        String seatKey = seat.getRow() + seat.getSeatNumber();

        if (!reservedSeats.containsKey(seatKey)) {
            throw new IllegalStateException("Bu rezervasyon mevcut değil: " + seatKey);
        }

        seat.setAvailable(true);
        reservedSeats.remove(seatKey);
        bookings.remove(booking);

        System.out.println("❌ Rezervasyon iptal edildi: " + seatKey);
    }

    /**
     * Belirli bir koltuğun müsait olup olmadığını kontrol eder
     * @param seatKey Koltuk anahtarı (örn: "A5")
     * @return Müsait ise true, değilse false
     */
    public boolean isSeatAvailable(String seatKey) {
        return !reservedSeats.containsKey(seatKey);
    }

    /**
     * Rezerve edilmiş tüm koltukların listesini döndürür
     * @return Rezerve edilmiş koltuk anahtarlarının listesi
     */
    public List<String> getReservedSeats() {
        return new ArrayList<>(reservedSeats.keySet());
    }

    /**
     * Tüm rezervasyonların listesini döndürür
     * @return Booking listesi
     */
    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }

    /**
     * Yeni bir rezervasyon ekler
     * @param booking Eklenecek rezervasyon
     */
    public void addBooking(Booking booking) {
        bookings.add(booking);
        bookSeat(booking.getSeat());
    }

    /**
     * Rezerve edilmiş koltuk sayısını döndürür
     * @return Rezerve koltuk sayısı
     */
    public int getReservedSeatCount() {
        return reservedSeats.size();
    }
}