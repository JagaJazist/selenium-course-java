package Models;

public class ProductBuilder {
    private boolean isEnabled;
    private String name;
    private String code;
    private String imageLink;
    private boolean isUnisex;
    private String quantity;
    private String manufacturer;
    private String description;
    private String keywords;
    private String shortDescription;
    private String headTitle;
    private String metaDescription;
    private String dateValidFrom;
    private String dateValidTo;
    private String purchasePrice;
    private String currency;
    private String priceEur;
    private String priceUsd;

    public ProductBuilder setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
        return this;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setCode(String code) {
        this.code = code;
        return this;
    }

    public ProductBuilder setImageLink(String imageLink) {
        this.imageLink = imageLink;
        return this;
    }

    public ProductBuilder setIsUnisex(boolean isUnisex) {
        this.isUnisex = isUnisex;
        return this;
    }

    public ProductBuilder setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductBuilder setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public ProductBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder setKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    public ProductBuilder setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public ProductBuilder setHeadTitle(String headTitle) {
        this.headTitle = headTitle;
        return this;
    }

    public ProductBuilder setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
        return this;
    }

    public ProductBuilder setDateValidFrom(String dateValidFrom) {
        this.dateValidFrom = dateValidFrom;
        return this;
    }

    public ProductBuilder setDateValidTo(String dateValidTo) {
        this.dateValidTo = dateValidTo;
        return this;
    }

    public ProductBuilder setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public ProductBuilder setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public ProductBuilder setPriceEur(String priceEur) {
        this.priceEur = priceEur;
        return this;
    }

    public ProductBuilder setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
        return this;
    }

    public Product createProduct() {
        return new Product(isEnabled, name, code, imageLink, isUnisex, quantity, manufacturer, description, keywords, shortDescription, headTitle, metaDescription, dateValidFrom, dateValidTo, purchasePrice, currency, priceEur, priceUsd);
    }
}