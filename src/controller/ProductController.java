package controller;

import model.*;
import storage.product.ReadWriteProduct;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class ProductController {
    private String name;

    public ProductController() {
    }

    public ProductController(String name) {
        this.name = name;
    }
   static List<Product> productList= ReadWriteProduct.getInstance().readData();
    public void addNewMeat(Meat meat){
        productList.add(meat);
        ReadWriteProduct.getInstance().writeData(productList);
    }
    public int getIndexMeatById(String id){
        int index=-1;
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId().equals(id)){
                index=i;
            }
        }
        return index;
    }
    public int getIndexFruitById(String id){
        int index=-1;
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId().equals(id)){
                index=i;
            }
        }
        return index;
    }
    public void editMeat(int index,String name, Shop shop, double price, int year,int month,int day,double weight){
        productList.get(index).setName(name);
        productList.get(index).setShop(shop);
        productList.get(index).setPrice(price);
        productList.get(index).setManufactureDate(LocalDate.of(year,month,day));
        Meat meat =(Meat) productList.get(index);
        meat.setWeight(weight);
        ReadWriteProduct.getInstance().writeData(productList);
    }
    public void editFruit(int index,String name, Shop shop, double price, int year,int month,int day,int quantity){
        productList.get(index).setName(name);
        productList.get(index).setShop(shop);
        productList.get(index).setPrice(price);
        productList.get(index).setManufactureDate(LocalDate.of(year,month,day));
        Fruit fruit =(Fruit) productList.get(index);
        fruit.setQuantity(quantity);
        ReadWriteProduct.getInstance().writeData(productList);
    }
    public void removeMeat(int index){
        productList.remove(index);
        ReadWriteProduct.getInstance().writeData(productList);
    }
    public void removeFruit(int index){
        productList.remove(index);
        ReadWriteProduct.getInstance().writeData(productList);
    }
    public void addNewFruit(Fruit fruit){
        productList.add(fruit);
        ReadWriteProduct.getInstance().writeData(productList);
    }
    public void displayAllProduct(){
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i));
        }
    }

    public void deleteShop(String id) {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getShop().getId().equals(id)){
                productList.get(i).setShop(null);
            }
        }
        ReadWriteProduct.getInstance().writeData(productList);
    }

    public double getSumOfMoney(String idShop) {
        double sum=0;
        for (Product product:productList) {
            if(product.getShop().getId().equals(idShop)){
                 sum+= product.getMoney();
        }

        }
        return sum;
    }

    public void deleteOldProduct() {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).isExpired()){
                productList.remove(i);
                i--;
            }
        }
        ReadWriteProduct.getInstance().writeData(productList);
        System.out.println("Đã xóa bỏ các sản phẩm hết hạn");
    }

    public void sortProductsById() {
        Collections.sort(productList);
        ReadWriteProduct.getInstance().writeData(productList);
    }
    public void displayProductsInShop(String idShop){
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getShop().getId().equals(idShop)){
                System.out.println(productList.get(i));
            }
        }
    }

    public void displayMeatList() {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i) instanceof Meat){
                Meat meat=(Meat)productList.get(i);
                System.out.println(meat);
            }

        }
    }

    public void displayFruitList() {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i) instanceof Fruit){
                Fruit fruit=(Fruit)productList.get(i);
                System.out.println(fruit);
            }
        }
    }

    public Product getProductById(String id) {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId().equals(id)){
                return productList.get(i);
            }

        }return null;
    }

    public void subtractProduct(Client client) {
        for (int i = 0; i < client.getCart().size(); i++) {
            for (int j = 0; j < productList.size(); j++) {
                if(client.getCart().get(i)==productList.get(j)){
                    productList.get(j).subtractByNumber(client.getCount().get(i));
                    ReadWriteProduct.getInstance().writeData(productList);
                }

            }

        }
    }
}
