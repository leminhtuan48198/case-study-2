package model;

import java.time.LocalDate;

public abstract class Product {
    private String id;
    private String name;
    private Shop shop;
    private double price;
    private LocalDate manufactureDate;

    public Product() {
    }

    public Product(String id, String name,Shop shop, double price, LocalDate manufactureDate) {
        this.id = id;
        this.name = name;
        this.shop=shop;
        this.price = price;
        this.manufactureDate = manufactureDate;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", shop=" + shop +
                ", price=" + price +
                ", manufactureDate=" + manufactureDate +
                '}';
    }
}
