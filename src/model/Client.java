package model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String id;
    private String password;
    private List<Product> cart;
    private List<Double> count;
    private double money;

    public Client() {
    }

    public Client(String id, String password) {
        this.id = id;
        this.password = password;
        this.cart = new ArrayList<>();
        this.count= new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<Double> getCount() {
        return count;
    }

    public void setCount(List<Double> count) {
        this.count = count;
    }
}
