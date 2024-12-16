package cinema.model;

/**
 * Seans bilgilerini tutan sinif.
 * Film, tarih ve saat bilgilerini icerir.
 */
public class ShowTime {

    private Movie movie;
    private String date;
    private String time;

    public ShowTime(Movie movie, String date, String time) {
        this.movie = movie;
        this.date = date;
        this.time = time;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
