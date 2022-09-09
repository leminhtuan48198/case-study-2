package model;

import java.io.Serializable;
import java.util.LinkedList;

public class Shop implements Comparable<Shop>,Serializable {
    private String id;
    private String name;
    private String address;

    public Shop() {
    }

    public Shop(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Shop{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(Shop shop) {
        return this.id.compareTo(shop.getId());
    }
}
