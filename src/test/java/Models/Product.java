package Models;

public class Product {

    public Product(boolean isEnabled, String name, String code, String imageLink, String quantity, String manufacturer) {
        this.isEnabled = isEnabled;
        this.name = name;
        this.code = code;
        this.imageLink = imageLink;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
    }

    public boolean isEnabled;
    public String name;
    public String code;
    public String imageLink;
    public String quantity;
    public String manufacturer;
}
