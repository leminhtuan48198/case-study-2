package view;

import controller.ClientController;
import controller.ProductController;
import model.Client;
import model.Product;

import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        ClientController tuanLe =new ClientController();
        ProductController tuan=new ProductController();
        showMenuClient(tuanLe,tuan);
    }

    private static void showMenuClient(ClientController tuanLe,ProductController tuan) {
        int choice=0;
        Scanner scanner=new Scanner(System.in);
        do{
            showMenu();
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Mời nhập ID");
                    Scanner scanner3 =new Scanner(System.in);
                    String id=scanner3.nextLine();
                    Client client= tuanLe.findClientByID(id);
                    if (client==null){
                        System.out.println("Sai tên đăng nhập");
                    }else {
                        System.out.println("Mời nhập password");
                        Scanner scanner2 =new Scanner(System.in);
                        String pass=scanner2.nextLine();
                        if(tuanLe.checkPass(client,pass)){
                            System.out.println(" Đăng nhập thành công");
                            goToShop(client,tuanLe,tuan);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Mời nhập ID");
                    Scanner scanner1 =new Scanner(System.in);
                     id=scanner1.nextLine();
                     client= tuanLe.findClientByID(id);
                    if (client!=null){
                        System.out.println("Tài khoản đã tồn tại");
                    }else {
                    System.out.println("Mời nhập password");
                    Scanner scanner2 =new Scanner(System.in);
                    String pass=scanner2.nextLine();
                    tuanLe.creatNewAccount(id,pass);
                        System.out.println("Đăng kí thành công tài khoản");
                    }
                    break;
                case 0:
                    System.exit(0);
            }
        }while(choice!=0);
    }

    private static void goToShop(Client client, ClientController tuanLe,ProductController tuan) {
        int choice=0;
        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("1. Nạp tiền");
            System.out.println("2. Kiểm tra tiền ");
            System.out.println("3. Xem thông tin sản phẩm");
            System.out.println("4. Thêm vào giỏ hàng");
            System.out.println("5. Xem giỏ hàng");
            System.out.println("6. Sửa giỏ hàng");
            System.out.println("7. Xóa giỏ hàng");
            System.out.println("8. Tính tiền giỏ hàng");
            System.out.println("9. Thanh toán");
            System.out.println("0. Đăng xuất");
            choice=scanner.nextInt();
             switch (choice){
                 case 1:
                     System.out.println("Nhập số tiền muốn nạp");
                     Scanner scanner1=new Scanner(System.in);
                     double money=scanner1.nextDouble();
                     if(money>0){
                     tuanLe.increaseMoney(client,money);
                     System.out.println("Nạp tiền thành công");
                     } else {
                         System.out.println("Số tiền bạn nhập không hợp lệ");
                     }
                     break;
                 case 2:
                     System.out.println("Tài khoản của bạn có "+client.getMoney() +" VNĐ");
                     break;
                 case 3:
                     tuan.displayAllProduct();
                     break;
                 case 4:
                     System.out.println("Nhập id sản phẩm");
                     Scanner scanner2=new Scanner(System.in);
                     String id=scanner2.nextLine();
                     Product product=tuan.getProductById(id);
                     if(product==null){
                         System.out.println("Bạn đã nhập sai id");
                     }else {
                         System.out.println("Nhập số lượng sản phẩm");
                         Scanner scanner3=new Scanner(System.in);
                         double numberWantToBuy=scanner3.nextDouble();
                         if(numberWantToBuy>0) {
                             int position = tuanLe.checkProductInCart(client, product);
                             tuanLe.addProductToCart(position,client,numberWantToBuy,product);
                             System.out.println("Thêm hàng thành công");
                         }else {
                             System.out.println("Số lượng sản phẩm không hợp lệ");
                         }
                     }
                     break;
                 case 5:
                     for (int i = 0; i < client.getCart().size(); i++) {
                         System.out.println(client.getCart().get(i)+" số lượng muốn mua "+ client.getCount().get(i));
                     }
                     break;
                 case 6:
                     System.out.println("Nhập id sản phẩm");
                     Scanner scanner3=new Scanner(System.in);
                     id =scanner3.nextLine();
                     int index=tuanLe.getIndexById(client,id);
                     if (index==-1){
                         System.out.println("Sản phẩm không có trong giỏ hàng");
                     }else{
                         System.out.println("Nhập số lượng muốn mua");
                         Scanner scanner4=new Scanner(System.in);
                         double weightOrQuantity=scanner4.nextDouble();
                         if(weightOrQuantity>0) {
                             tuanLe.editCart(client,index,weightOrQuantity);

                             System.out.println("Đã sửa thành công");
                         }else {
                             System.out.println("Số lượng bạn nhập không hợp lệ");
                         }
                     }


                 case 7:
                     tuanLe.deleteCart(client);
                     System.out.println("Đã xóa thành công giỏ hàng");
                 case 8:

                     System.out.println("Tổng giá trị giỏ hàng là "+tuanLe.getSumOfCart(client));
                     break;
                 case 9:

                     if(tuanLe.checkAvailable(client) && tuanLe.getSumOfCart(client)<client.getMoney()){
                         tuan.subtractProduct(client);
                         tuanLe.subtractMoney(client);
                         tuanLe.deleteCart(client);
                         System.out.println("Thanh toán thành công");
                     }
                     break;
                 case 0:
                     showMenuClient(tuanLe, tuan);


             }
            
        }while(choice!=0);
    }

    private static void showMenu() {
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng kí");
        System.out.println("0. Thoát");
    }
}
