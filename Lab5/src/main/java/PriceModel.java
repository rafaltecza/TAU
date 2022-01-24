public class PriceModel {

    private int price;
    private String country;

    public PriceModel(int price, String country) {
        this.price = price;
        this.country = country;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
