package model;

import java.time.LocalDate;

public class Fruit extends Product implements ExpiredDate,Money {
    private int quantity;

    public Fruit() {
    }

    public Fruit(String id, String name,Shop shop, double price, LocalDate manufactureDate, int quantity) {
        super(id, name,shop, price, manufactureDate);
        this.quantity = quantity;
    }

    @Override
    public LocalDate getExpiredDate() {
        return getManufactureDate().plusMonths(1);
    }

    @Override
    public double getMoney() {
        return quantity*super.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return super.toString()+"Fruit{" +
                "quantity=" + quantity +
                '}';
    }
}
