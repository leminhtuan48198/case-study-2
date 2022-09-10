package model;

import java.util.LinkedList;
import java.util.List;

public class CustomerOrder {
    private Client client;
    private LinkedList<Product> cart1;
    private LinkedList<Double> count1;
    private boolean isReceived;

    public CustomerOrder() {
    }

    public CustomerOrder(Client client, LinkedList<Product> cart1, LinkedList<Double> count1, boolean isReceived) {
        this.client = client;
        this.cart1 = cart1;
        this.count1 = count1;
        this.isReceived = isReceived;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getCart1() {
        return cart1;
    }

    public void setCart1(LinkedList<Product> cart1) {
        this.cart1 = cart1;
    }

    public List<Double> getCount1() {
        return count1;
    }

    public void setCount1(LinkedList<Double> count1) {
        this.count1 = count1;
    }

    public boolean isReceived() {
        return isReceived;
    }

    public void setReceived(boolean received) {
        isReceived = received;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "client=" + client +
                ", cart1=" + cart1 +
                ", count1=" + count1 +
                ", isReceived=" + isReceived +
                '}';
    }
}
