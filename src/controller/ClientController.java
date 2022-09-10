package controller;

import model.Client;
import model.Product;
import storage.client.ReadWriteClient;

import java.io.Serializable;
import java.util.List;

public class ClientController implements Serializable {
    public ClientController() {
    }
    public static List<Client> clientList= ReadWriteClient.getInstance().readData();

    public void creatNewAccount(String id, String pass) {
        clientList.add(new Client(id,pass));
        ReadWriteClient.getInstance().writeData(clientList);
    }

    public Client findClientByID(String id) {
        for (int i = 0; i < clientList.size(); i++) {
            if(clientList.get(i).getId().equals(id)){
                return clientList.get(i);
            }
        }return null;
    }

    public boolean checkPass(Client client, String pass) {
        return client.getPassword().equals(pass);
    }

    public void increaseMoney(Client client, double money) {
        if(money>0){
            client.setMoney(client.getMoney()+money);
            ReadWriteClient.getInstance().writeData(clientList);

        }else System.out.println("Số tiền phải là số dương");
    }

    public int checkProductInCart(Client client, Product product) {
        for (int i = 0; i <client.getCart().size() ; i++) {
            if(client.getCart().get(i)==product){
                return i;
            }
        }return -1;
    }

    public double getSumOfCart(Client client) {
        double sum=0;
        for (int i = 0; i < client.getCart().size(); i++) {
            sum+= client.getCart().get(i).getPrice()*client.getCount().get(i);
        }return sum;
    }

    public void subtractMoney(Client client) {
        client.setMoney(client.getMoney()-new ClientController().getSumOfCart(client));
        ReadWriteClient.getInstance().writeData(clientList);
    }

    public void deleteCart(Client client) {
        client.getCart().clear();
        client.getCount().clear();
        ReadWriteClient.getInstance().writeData(clientList);
    }

    public boolean checkAvailable(Client client) {
        boolean available=true;
        for (int i = 0; i < client.getCart().size(); i++) {
            if(client.getCount().get(i)>client.getCart().get(i).getWeightOrQuantity()){
                available=false;
            }
        }
        return available;
    }

    public int getIndexById(Client client, String id) {
        for (int i = 0; i <client.getCart().size() ; i++) {
            if(client.getCart().get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public void addProductToCart(int position, Client client, double numberWantToBuy, Product product) {
        if (position == -1) {
            client.getCart().add(product);
            client.getCount().add(numberWantToBuy);
        } else {
            client.getCount().set(position, numberWantToBuy + client.getCount().get(position));
        }
        ReadWriteClient.getInstance().writeData(clientList);
    }

    public void editCart(Client client,int index,double weightOrQuantity) {
        client.getCount().set(index, weightOrQuantity);
        ReadWriteClient.getInstance().writeData(clientList);
    }
}
