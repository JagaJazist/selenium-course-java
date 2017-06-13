package Models;

public class Product {

    public Product(boolean isEnabled, String name, String code, String imageLink, boolean isUnisex, String quantity, String manufacturer, String description,
                   String keywords, String shortDescription, String headTitle, String metaDescription,
                   String purchasePrice, String currency, String priceEur, String priceUsd) {
        this.isEnabled = isEnabled;
        this.name = name;
        this.code = code;
        this.imageLink = imageLink;
        this.isUnisex = isUnisex;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
        this.description = description;
        this.keywords = keywords;
        this.shortDescription = shortDescription;
        this.headTitle = headTitle;
        this.metaDescription = metaDescription;
        this.purchasePrice = purchasePrice;
        this.currency = currency;
        this.priceEur = priceEur;
        this.priceUsd = priceUsd;

    }

    public boolean isEnabled;
    public String name;
    public String code;
    public String imageLink;
    public boolean isUnisex;
    public String quantity;
    public String manufacturer;
    public String description;
    public String keywords;
    public String shortDescription;
    public String headTitle;
    public String metaDescription;
    public String purchasePrice;
    public String currency;
    public String priceEur;
    public String priceUsd;

}
