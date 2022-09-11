package controller;

import model.Client;
import model.CustomerOrder;
import model.Product;
import storage.customerOrder.ReadWriteCustomerOrder;

import java.util.LinkedList;
import java.util.List;

public class CustomerOrderController {
    public CustomerOrderController() {
    }
    public static List<CustomerOrder> customerOrderList= ReadWriteCustomerOrder.getInstance().readData();

    public void createNewOrder(Client client) {
        CustomerOrder customerOrder=new CustomerOrder(client, (LinkedList<Product>) client.getCart().clone(), (LinkedList<Double>) client.getCount().clone(),false);
        customerOrderList.add(customerOrder);
        ReadWriteCustomerOrder.getInstance().writeData(customerOrderList);
    }

    public void showWaitCart(Client client) {
        for (int i = 0; i < customerOrderList.size(); i++) {
            if(client.getId().equals(customerOrderList.get(i).getClient().getId())){
                System.out.println("Mã đơn hàng của quý khách là "+i);
                for (int j = 0; j < customerOrderList.get(i).getCart1().size(); j++) {
                    System.out.println(customerOrderList.get(i).getCart1().get(j)+" số lượng là: "+customerOrderList.get(i).getCount1().get(j));
                }
                if(customerOrderList.get(i).isReceived()){
                    System.out.println("Đơn hàng trên đã được chuyển đến thành công");
                }else System.out.println("Đơn hàng trên đang được chuyển đến");
            }


        }
    }

    public void conformReceived(Client client, int index) {
        if(index<customerOrderList.size()&&index>-1){
            if(customerOrderList.get(index).getClient().getId().equals(client.getId())){
            customerOrderList.get(index).setReceived(true);
            ReadWriteCustomerOrder.getInstance().writeData(customerOrderList);
            System.out.println(" Cảm ơn bạn đã mua hàng");
        }else{
            System.out.println("Mã bạn nhập không đúng");
        }
        }else{
            System.out.println("Mã bạn nhập không hợp lệ");
        }

    }

    public void showNotReceivedOrder() {
        for (int i = 0; i < customerOrderList.size(); i++) {
            if(!customerOrderList.get(i).isReceived()){
                System.out.println("Mã đơn hàng "+i);
                System.out.println(customerOrderList.get(i).getClient().toString());
                for (int j = 0; j < customerOrderList.get(i).getCart1().size(); j++) {
                    System.out.println(customerOrderList.get(i).getCart1().get(j)+" số lượng là: "+customerOrderList.get(i).getCount1().get(j));}
            }
            
        }
    }

}
