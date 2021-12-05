import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CounterTest {

    private Counter counter;
    private int[] numbers;

    @BeforeEach
    public void setUp() {
        this.counter = new Counter();
        this.numbers = new int[]{3, 6, -15, -5};
    }

    @Test
    public void diffNumbersTest() {
        assertNotEquals(this.numbers[0], this.numbers[1]);
    }

    @Test
    public void sameNumbersTest() {
        assertNotEquals(this.numbers[0], this.numbers[0]);
    }

    @Test
    public void addPositiveTest() {
        int result = counter.add(this.numbers[0], this.numbers[1]);
        assertEquals(9, result);
    }

    @Test
    public void addNegativeTest() {
        int result = counter.sub(this.numbers[2], this.numbers[3]);
        assertEquals(3, result);
    }

    @Test
    public void subPositiveTest() {
        int result = counter.sub(this.numbers[1], this.numbers[0]);
        assertEquals(3, result);
    }

    @Test
    public void subNegativeTest() {
        int result = counter.sub(this.numbers[2], this.numbers[3]);
        assertEquals(-20, result);
    }

    @Test
    public void multiplyTest() {
        int result = counter.sub(this.numbers[0], this.numbers[1]);
        assertEquals(18, result);
    }

}
