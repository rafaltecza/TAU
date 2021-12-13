import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CounterTest {

    private Counter counter;
    private int[] numbers;
    private String[] texts;
    private Color[] colorsRgb;
    private String[] colorsHex;
    private Model[] models;

    @BeforeEach
    public void setUp() {
        this.counter = new Counter();
        this.numbers = new int[]{3, 6, -15, -5};
        this.texts = new String[]{"Lorem ipsum", "Trofeum", "Java", "Wilk"};
        this.colorsRgb = new Color[]{new Color(128,128,128), new Color(244,244,244)};
        this.colorsHex = new String[]{"#fffff", "#00000"};
        this.models = new Model[]{new Model("Test1", 10, false)};
    }

    @Test
    public void diffNumbersTest() {
        assertNotEquals(this.numbers[0], this.numbers[1]);
    }

    @Test
    public void sameNumbersTest() {
        assertSame(this.numbers[0], this.numbers[0]);
    }

    @Test
    public void addPositiveTest() {
        int result = counter.add(this.numbers[0], this.numbers[1]);
        assertEquals(9, result);
    }

    @Test
    public void addNegativeTest() {
        System.out.println(this.numbers[2]);
        System.out.println(this.numbers[3]);
        int result = counter.sub(this.numbers[2], this.numbers[3]);
        assertEquals(-10, result);
    }

    @Test
    public void subPositiveTest() {
        int result = counter.sub(this.numbers[1], this.numbers[0]);
        assertEquals(3, result);
    }

    @Test
    public void subNegativeTest() {
        int result = counter.sub(this.numbers[2], this.numbers[3]);
        assertEquals(-10, result);
    }

    @Test
    public void multiplyTest() {
        int result = counter.multiply(this.numbers[0], this.numbers[1]);
        assertEquals(18, result);
    }

    @Test
    public void lengthTest() {
        int result = counter.getStringLength(this.texts[0]);
        assertEquals(11, result);
    }

    @Test
    public void lengthNegativeCompareTest() {
        int result1 = counter.getStringLength(this.texts[0]);
        int result2 = counter.getStringLength(this.texts[1]);
        assertSame(false, result1 == result2);
    }

    @Test
    public void lengthPositiveCompareTest() {
        int result1 = counter.getStringLength(this.texts[2]);
        int result2 = counter.getStringLength(this.texts[3]);
        assertSame(true, result1 == result2);
    }

    @Test
    public void colorConvertToHexTest() {
        String colorHex = counter.getColorHex(this.colorsRgb[0]);
        assertEquals("#808080", colorHex);
    }

    @Test
    public void colorConvertToHexCompareTest() {
        String colorHex1 = counter.getColorHex(this.colorsRgb[0]);
        String colorHex2 = counter.getColorHex(this.colorsRgb[1]);
        assertNotEquals(colorHex1, colorHex2);
    }

    @Test
    public void hexConvertToColorTest() {
        Color colorRgb = counter.getColor(this.colorsHex[0]);
        assertEquals(new Color(15, 255, 255), colorRgb);
    }

    @Test
    public void hexConvertToColorCompareTest() {
        Color colorRgb1 = counter.getColor(this.colorsHex[0]);
        Color colorRgb2 = counter.getColor(this.colorsHex[1]);
        assertNotEquals(colorRgb1, colorRgb2);
    }

    @Test
    public void convertModelToJsonWithGsonTest() {
        String json = counter.getGson(this.models[0]);
        assertEquals("{\"name\":\"Test1\",\"value\":10,\"type\":false}", json);
    }

    @Test
    public void convertModelToJsonWithFastJsonTest() {
        String json = counter.getFastJson(this.models[0]);
        assertEquals("{\"Name\":\"Test1\",\"Type\":false,\"Val\":10}", json);
    }

    @Test
    public void differentJsonConverterCompareTest() {
        String gson = counter.getGson(this.models[0]);
        String json = counter.getFastJson(this.models[0]);
        assertNotEquals(gson, json);
    }
}
