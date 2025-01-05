package cinema.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MoviePriceTest {


    @Test
    void test2DMoviePrice() {
        Movie movie = new Movie2D("Inception", "Sci-Fi", 148, 100.0);
        assertEquals(100.0, movie.calculatePrice());
    }

    @Test
    void test3DMoviePrice() {
        Movie movie = new Movie3D("Avatar", "Sci-Fi", 162, 100.0, 30.0);
        assertEquals(130.0, movie.calculatePrice());
    }
}
//test başarılı