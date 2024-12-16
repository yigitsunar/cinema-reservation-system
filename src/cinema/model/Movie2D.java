package cinema.model;

/**
 * 2D film bilgilerini tutan sinif.
 * Standart fiyatlandirma uygular.
 */
public class Movie2D extends Movie {

    private double basePrice;

    public Movie2D(String title, String genre, int duration, double basePrice) {
        super(title, genre, duration);
        this.basePrice = basePrice;
    }

    @Override
    public double calculatePrice() {
        return basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double calculateDiscountedPrice(double discountRate) {
        return basePrice - (basePrice * discountRate);
    }
}
