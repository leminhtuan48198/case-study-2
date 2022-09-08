package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Meat extends Product implements ExpiredDate,Money, Serializable {
    private double weight;

    public Meat() {
    }

    public Meat(String id, String name,Shop shop, double price, LocalDate manufactureDate, double weight) {
        super(id, name, shop, price, manufactureDate);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public LocalDate getExpiredDate() {
        return getManufactureDate().plusDays(7);
    }

    @Override
    public double getMoney() {
        return weight*this.getPrice();
    }

    @Override
    public String toString() {
        return super.toString()+ "Meat{" +
                "weight=" + weight +
                '}';
    }
}
