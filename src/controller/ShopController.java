package controller;

import model.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopController {
    private String name;

    public ShopController() {
    }

    public ShopController(String name) {
        this.name = name;
    }
    static List<Shop> shopList=new ArrayList<>();
    public void addNewShop(Shop shop){
        shopList.add(shop);
    }
    public int findShopIndexById(String id){
        int index=-1;
        for (int i = 0; i < shopList.size(); i++) {
            if(shopList.get(i).getId().equals(id)){
                index=i;
            }
        }
        return index;
    }
    public void editShop(int index, String name,String address){
        if(index>-1){
            shopList.get(index).setName(name);
            shopList.get(index).setAddress(address);
        }else{
            System.out.println("Không tìm thấy Id phù hợp");
        }
    }
    public void deleteShop(int index){
        if(index>-1) {
           Shop deletedShop=shopList.get(index);
           shopList.remove(index);
            deletedShop=null;
        }else{
            System.out.println("Không tìm thấy Id phù hợp");
        }
    }
    public void displayShops(){
        for (int i = 0; i < shopList.size(); i++) {
            System.out.println(shopList.get(i));
        }
    }
    public Shop getShopById(String id){
        Shop shop =null;
        for (int i = 0; i < shopList.size(); i++) {
            if(shopList.get(i).getId().equals(id)){
                shop=shopList.get(i);
            }
        }
        return shop;
    }

}
