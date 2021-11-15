package JobSearcher;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RatingsTest {
	
	@BeforeEach
	public static void setup() {
		//runs before each test
	}
	
	@AfterEach
	public static void tearDown() {
		//runs after each test
	}


    @Test
	public void testGetAverageRatings() {
		double results = Ratings.getAverageRating(sumRatings, numRatings);
		assertEquals(rating, results);
    }

    @Test
    public void divide_whenDenominatorIsZero_shouldThrow() {
        assertThrows(ArithmeticException.class, () -> Ratings.getAverageRating(0.0, 0));
    }
}
