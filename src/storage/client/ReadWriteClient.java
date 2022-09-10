package storage.client;

import model.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteClient implements IReadWriteClient {
    private ReadWriteClient() {
    }
    private static ReadWriteClient readWriteClient;
    public static ReadWriteClient getInstance(){
        if(readWriteClient==null){
            readWriteClient=new ReadWriteClient();
        }
        return readWriteClient;
    }

    @Override
    public List<Client> readData() {
        List<Client> clientList=new ArrayList<>();
       try {
        FileInputStream fis =new FileInputStream("client.txt");
        ObjectInputStream ois =new ObjectInputStream(fis);
        clientList= (List<Client>) ois.readObject();
        ois.close();
        fis.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
        return clientList;
    }

    @Override
    public void writeData(List<Client> clientList) {
        try{
            FileOutputStream fos=new FileOutputStream("client.txt");
        ObjectOutputStream oos =new ObjectOutputStream(fos);
        oos.writeObject(clientList);
        oos.close();
        fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
