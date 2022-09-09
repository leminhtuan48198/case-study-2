package storage.shop;

import model.Shop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteShop implements IReadWriteShop{
    private ReadWriteShop(){}
    private static ReadWriteShop readWriteShop;
    public static ReadWriteShop getInstance(){
        if(readWriteShop==null){
            readWriteShop=new ReadWriteShop();
        }
        return readWriteShop;
    }

    @Override
    public List<Shop> readData() {
        List<Shop> shopList=new ArrayList<>();
        try{
            FileInputStream fis =new FileInputStream("shop.txt");
            ObjectInputStream ois= new ObjectInputStream(fis);
            shopList=(List<Shop>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return shopList;
    }

    @Override
    public void writeData(List<Shop> shopList) {
        try{
            FileOutputStream fos=new FileOutputStream("shop.txt");
            ObjectOutputStream ois=new ObjectOutputStream(fos);
            ois.writeObject(shopList);
            ois.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
