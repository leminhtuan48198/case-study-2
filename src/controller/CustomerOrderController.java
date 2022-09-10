package controller;

import model.Client;
import model.CustomerOrder;
import model.Product;

import java.util.LinkedList;
import java.util.List;

public class CustomerOrderController {
    public CustomerOrderController() {
    }
    public static List<CustomerOrder> customerOrderList= new LinkedList<>();

    public void createNewOrder(Client client) {
        CustomerOrder customerOrder=new CustomerOrder(client, (LinkedList<Product>) client.getCart().clone(), (LinkedList<Double>) client.getCount().clone(),false);
        customerOrderList.add(customerOrder);
    }

    public void showWaitCart(Client client) {
        for (int i = 0; i < customerOrderList.size(); i++) {
            if(client==customerOrderList.get(i).getClient()){
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
        if(customerOrderList.get(index).getClient()==client){
            customerOrderList.get(index).setReceived(true);
            System.out.println(" Cảm ơn bạn đã mua hàng");
        }else{
            System.out.println("Mã bạn nhập không đúng");
        }
    }

    public void showNotReceivedOrder() {
        for (int i = 0; i < customerOrderList.size(); i++) {
            if(!customerOrderList.get(i).isReceived()){
                System.out.println(customerOrderList.get(i));
            }
            
        }
    }
}
