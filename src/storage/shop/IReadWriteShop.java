package storage.shop;

import model.Shop;
import storage.InterfaceGenericReadWriteData;

import java.util.List;

public interface IReadWriteShop extends InterfaceGenericReadWriteData<Shop> {
    @Override
    List<Shop> readData();

    @Override
    void writeData(List<Shop> shops);
}
