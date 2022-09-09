package storage.product;

import model.Product;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ReadWriteProduct implements IReadWriteProduct{
    private ReadWriteProduct() {
    }
    private static ReadWriteProduct readWriteProduct;
    public static ReadWriteProduct getInstance(){
        if(readWriteProduct==null){
            readWriteProduct =new ReadWriteProduct();
        }return readWriteProduct;
    }

    @Override
    public List<Product> readData() {
        List<Product> productList=new LinkedList<>();
        try{
            FileInputStream fis =new FileInputStream("product.txt");
            ObjectInputStream ois =new ObjectInputStream(fis);
            productList=(List<Product>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;

    }

    @Override
    public void writeData(List<Product> productList) {
        try{
            FileOutputStream fos=new FileOutputStream("product.txt");
            ObjectOutputStream ois=new ObjectOutputStream(fos);
            ois.writeObject(productList);
            ois.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
