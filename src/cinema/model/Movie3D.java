package cinema.model;

/**
 * 3D film bilgilerini tutan sinif.
 * Ek ucret ile fiyatlandirma yapar.
 */
public class Movie3D extends Movie {

    private double basePrice;
    private double extraCharge;

    public Movie3D(String title, String genre, int duration,
                   double basePrice, double extraCharge) {
        super(title, genre, duration);
        this.basePrice = basePrice;
        this.extraCharge = extraCharge;
    }

    @Override
    public double calculatePrice() {
        return basePrice + extraCharge;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getExtraCharge() {
        return extraCharge;
    }

    public void setExtraCharge(double extraCharge) {
        this.extraCharge = extraCharge;
    }

    public double calculatePremiumPrice(double percentage) {
        return calculatePrice() * (1 + percentage);
    }
}
