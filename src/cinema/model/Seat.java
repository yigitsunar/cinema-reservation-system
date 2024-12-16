package cinema.model;

/**
 * Koltuk bilgilerini tutan sinif.
 * Koltuk numarasi, sira ve musaitlik durumunu icerir.
 */
public class Seat {

    private int seatNumber;
    private String row;
    private boolean available;

    public Seat(int seatNumber, String row, boolean available) {
        this.seatNumber = seatNumber;
        this.row = row;
        this.available = available;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // EKLENEN METOT
    public void reserve() {
        this.available = false;
    }
}
