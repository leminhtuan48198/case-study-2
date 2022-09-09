package model;

import java.io.Serializable;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Fruit extends Product implements Serializable {
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

    @Override
    public boolean isExpired() {
        LocalDate now=LocalDate.now();
        long numberDay=DAYS.between(this.getExpiredDate(),now);
        return numberDay>0;
    }
}
