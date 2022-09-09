package controller;

import model.Shop;
import storage.product.ReadWriteProduct;
import storage.shop.ReadWriteShop;

import java.util.Collections;
import java.util.List;

import static controller.ProductController.productList;

public class ShopController {
    private String name;

    public ShopController() {
    }

    public ShopController(String name) {
        this.name = name;
    }
    static List<Shop> shopList= ReadWriteShop.getInstance().readData();
    public void addNewShop(Shop shop){
        shopList.add(shop);
        ReadWriteShop.getInstance().writeData(shopList);
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
            ReadWriteShop.getInstance().writeData(shopList);
            ReadWriteProduct.getInstance().writeData(productList);
        }else{
            System.out.println("Không tìm thấy Id phù hợp");
        }
    }
    public void deleteShop(int index){
        if(index>-1) {
           shopList.remove(index);
            ReadWriteShop.getInstance().writeData(shopList);
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


    public void sortShopsById() {
        Collections.sort(shopList);
        ReadWriteShop.getInstance().writeData(shopList);
    }
}
