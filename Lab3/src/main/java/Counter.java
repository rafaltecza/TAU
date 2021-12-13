import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import java.awt.*;

public class Counter {

    public int add(int x, int y) {
        return x + y;
    }

    public int sub(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int getStringLength(String value) {
        return value.length();
    }

    public String getColorHex(Color color) {
        return "#"+Integer.toHexString(color.getRGB()).substring(2);
    }

    public Color getColor(String hex) {
        return Color.decode(hex);
    }

    public String getGson(Model model) {
        Gson gson = new Gson();
        return gson.toJson(model);
    }

    public String getFastJson(Model model) {
        return JSON.toJSONString(model);
    }

    public static void main(String[] args) {}

}
