package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Client implements Serializable {
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private String password;
    private LinkedList<Product> cart;
    private LinkedList<Double> count;
    private double money;

    public Client() {
    }

    public Client(String id, String name, String address, String phoneNumber, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.cart= new LinkedList<>();
        this.count=new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public LinkedList<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = (LinkedList<Product>) cart;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public LinkedList<Double> getCount() {
        return count;
    }

    public void setCount(List<Double> count) {
        this.count = (LinkedList<Double>) count;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
