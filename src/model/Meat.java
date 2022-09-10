package model;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Meat extends Product implements Serializable {
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

    @Override
    public boolean isExpired() {
        LocalDate now=LocalDate.now();
        long number= DAYS.between(now,this.getExpiredDate());
        return number<0;

    }

    @Override
    public double getWeightOrQuantity() {
        return this.weight;
    }

    @Override
    public void subtractByNumber(double number) {
        this.setWeight(this.getWeight()-number);
    }
}
