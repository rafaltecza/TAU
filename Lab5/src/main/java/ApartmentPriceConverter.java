import com.google.gson.Gson;
import org.json.JSONObject;

public class ApartmentPriceConverter {

    public static void main(String[] args) {}

    public static float MULTIPLER_PLN_USD = 0.24f;
    public static float MULTIPLER_USD_PLN = 4.11f;

    public static float MULTIPLER_PLN_EUR = 0.22f;
    public static float MULTIPLER_EUR_PLN = 4.64f;

    public static float MULTIPLER_GBP_PLN = 5.43f;
    public static float MULTIPLER_PLN_GBP = 0.18f;

    public float convert(float price, float multiplier) {
        return price * multiplier;
    }

    public String getGson(PriceModel model) {
        return new Gson().toJson(model);
    }

    public String getJsonObject(PriceModel model) {
        return JSONObject.valueToString(new JSONObject(model));
    }
}
