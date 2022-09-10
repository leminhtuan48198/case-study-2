package storage.customerOrder;

import model.Client;
import model.CustomerOrder;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadWriteCustomerOrder implements IReadWriteCustomerOrder{
    private ReadWriteCustomerOrder() {
    }
    private static ReadWriteCustomerOrder readWriteCustomerOrder;
    public static ReadWriteCustomerOrder getInstance(){
        if(readWriteCustomerOrder==null){
            readWriteCustomerOrder=new ReadWriteCustomerOrder();
        }return readWriteCustomerOrder;
    }

    @Override
    public List<CustomerOrder> readData() {
        List<CustomerOrder> customerOrderList =new LinkedList<>();
        try {
            FileInputStream fis =new FileInputStream("customerOrder.txt");
            ObjectInputStream ois =new ObjectInputStream(fis);
            customerOrderList= (List<CustomerOrder>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customerOrderList;
    }

    @Override
    public void writeData(List<CustomerOrder> customerOrders) {
        try{
            FileOutputStream fos=new FileOutputStream("customerOrder.txt");
            ObjectOutputStream oos =new ObjectOutputStream(fos);
            oos.writeObject(customerOrders);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
