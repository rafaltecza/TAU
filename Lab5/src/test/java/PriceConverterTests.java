import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriceConverterTests {

    private ApartmentPriceConverter apartmentPriceConverter;
    private PriceModel priceModelPLN;
    private PriceModel priceModelGBP;

    @BeforeEach
    public void setUp() {
        this.apartmentPriceConverter = new ApartmentPriceConverter();
        priceModelPLN = new PriceModel(50, "PLN");
        priceModelGBP = new PriceModel(10, "GBP");
    }

    @Test
    public void testDiffMultipliers() {
        assertNotEquals(ApartmentPriceConverter.MULTIPLER_PLN_GBP, ApartmentPriceConverter.MULTIPLER_GBP_PLN);
    }

    @Test
    public void testSameMultipliers() {
        assertTrue(ApartmentPriceConverter.MULTIPLER_PLN_GBP == ApartmentPriceConverter.MULTIPLER_PLN_GBP);
    }

    @Test
    public void testConvertPLNGBP() {
        assertEquals(18f, apartmentPriceConverter.convert(100, ApartmentPriceConverter.MULTIPLER_PLN_GBP));
    }

    @Test
    public void testConvertNotNullPLNGBP() {
        assertNotNull(apartmentPriceConverter.convert(100, ApartmentPriceConverter.MULTIPLER_PLN_GBP));
    }

    @Test
    public void testConvertTruePLNGBP() {
        assertTrue(apartmentPriceConverter.convert(100, ApartmentPriceConverter.MULTIPLER_PLN_GBP) == 18f);
    }

    @Test
    public void testConvertFalsePLNGBP() {
        assertFalse(apartmentPriceConverter.convert(100, ApartmentPriceConverter.MULTIPLER_PLN_GBP) == 50f);
    }

    @Test
    public void testConvertGBPPLN() {
        assertEquals(543f, apartmentPriceConverter.convert(100, ApartmentPriceConverter.MULTIPLER_GBP_PLN));
    }

    @Test
    public void testConvertEURPLN() {
        assertEquals(464f, apartmentPriceConverter.convert(100, ApartmentPriceConverter.MULTIPLER_EUR_PLN));
    }

    @Test
    public void testConvertPLNEUR() {
        assertEquals(22f, apartmentPriceConverter.convert(100, ApartmentPriceConverter.MULTIPLER_PLN_EUR));
    }

    @Test
    public void testConvertNotSamePLNEUR() {
        assertNotEquals(200,  apartmentPriceConverter.convert(100, ApartmentPriceConverter.MULTIPLER_PLN_EUR));
    }

    @Test
    public void convertCurrencyModelToJsonAndGsonTest() {
        assertEquals("{\"price\":50,\"country\":\"PLN\"}", apartmentPriceConverter.getGson(priceModelPLN));
    }

    @Test
    public void convertCurrencyModelToOrgJsonTest() {
        assertEquals("{\"country\":\"GBP\",\"price\":10}", apartmentPriceConverter.getJsonObject(priceModelGBP));
    }

    // Są obrócone względem siebie
    @Test
    public void compareJsonConvertersTest() {
        String gson = apartmentPriceConverter.getGson(priceModelPLN);
        String json = apartmentPriceConverter.getJsonObject(priceModelPLN);
        assertNotEquals(gson, json);
    }

}
