package storage.shop;

import model.Shop;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadWriteShop implements IReadWriteShop{
    @Override
    public List<Shop> readData() {
        FileInputStream fis =new FileInputStream("shop.txt");
        ObjectInputStream ois= new ObjectInputStream(fis);
        List<Shop> shopList=()
    }

    @Override
    public void writeData(List<Shop> shops) {

    }
}
