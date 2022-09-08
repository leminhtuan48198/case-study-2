package controller;

import model.Fruit;
import model.Meat;
import model.Product;
import model.Shop;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ProductController {
    private String name;

    public ProductController() {
    }

    public ProductController(String name) {
        this.name = name;
    }
   static List<Product> productList=new LinkedList();
    public void addNewMeat(Meat meat){
        productList.add(meat);
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
    }
    public void editFruit(int index,String name, Shop shop, double price, int year,int month,int day,int quantity){
        productList.get(index).setName(name);
        productList.get(index).setShop(shop);
        productList.get(index).setPrice(price);
        productList.get(index).setManufactureDate(LocalDate.of(year,month,day));
        Fruit fruit =(Fruit) productList.get(index);
        fruit.setQuantity(quantity);
    }
    public void removeMeat(int index){
        productList.remove(index);
    }
    public void addNewFruit(Fruit fruit){
        productList.add(fruit);
    }

}
