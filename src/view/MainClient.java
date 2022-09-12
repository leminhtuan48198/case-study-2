package view;

import controller.ClientController;
import controller.CustomerOrderController;
import controller.ProductController;
import model.Client;
import model.Product;

import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        ClientController tuanLe =new ClientController();
        ProductController tuan=new ProductController();
        CustomerOrderController tuanLeMinh=new CustomerOrderController();
        showMenuClient(tuanLe,tuan,tuanLeMinh);
    }

    private static void showMenuClient(ClientController tuanLe, ProductController tuan, CustomerOrderController tuanLeMinh) {
        int choice=0;
        Scanner scanner=new Scanner(System.in);
        do{
            showMenu();
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    logIn(tuanLe, tuan, tuanLeMinh);
                    break;
                case 2:
                    registryAccount(tuanLe);
                    break;
                case 0:
                    System.exit(0);
            }
        }while(choice!=0);
    }

    private static void registryAccount(ClientController tuanLe) {
        String id;
        Client client;
        do{
            System.out.println("Mời nhập ID có độ tài từ 6 đến 12 ký tự, không có khoảng trắng và không dấu:");
            Scanner scanner1 =new Scanner(System.in);
            id=scanner1.nextLine();
        }while(!id.matches("[a-z0-9_-]{6,12}$"));

        client= tuanLe.findClientByID(id);
        if (client!=null){
            System.out.println("Tài khoản đã tồn tại");
        }else {
            String pass;
        do{System.out.println("Mời nhập password,  Phải chứa ít nhất 1 ký tự số từ 0 – 9\n" +
                "         Phải chứa ít nhất 1 ký tự chữ thường\n" +
                "         Phải chứa ít nhất 1 ký tự chữ hoa\n" +
                "         Phải chứa ít nhất 1 ký tự trong tập các ký tự đặc biệt");
        Scanner scanner2 =new Scanner(System.in);
        pass=scanner2.nextLine();
        }while (!pass.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})"));

        System.out.println("Mời nhập tên");
        Scanner scanner5 =new Scanner(System.in);
        String name=scanner5.nextLine();
        System.out.println("Mời nhập địa chỉ");
        Scanner scanner4 =new Scanner(System.in);
        String address=scanner4.nextLine();
        System.out.println("Mời nhập số điện thoại");
        Scanner scanner6 =new Scanner(System.in);
        String phoneNumber=scanner6.nextLine();

        tuanLe.creatNewAccount(id,name,address,phoneNumber,pass);
            System.out.println("Đăng kí thành công tài khoản");
        }
    }

    private static void logIn(ClientController tuanLe, ProductController tuan, CustomerOrderController tuanLeMinh) {
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
                goToShop(client, tuanLe, tuan, tuanLeMinh);
            }
        }
    }

    private static void goToShop(Client client, ClientController tuanLe,ProductController tuan,CustomerOrderController tuanLeMinh) {
        int choice=0;
        Scanner scanner=new Scanner(System.in);
        do{
            showMenuClient();
            choice=scanner.nextInt();
             switch (choice){
                 case 1:
                     depositMoney(client, tuanLe);
                     break;
                 case 2:
                     System.out.println("Tài khoản của bạn có "+client.getMoney() +" VNĐ");
                     break;
                 case 3:
                     tuan.displayAllProduct();
                     break;
                 case 4:
                     addProductToCart(client, tuanLe, tuan);
                     break;
                 case 5:
                     for (int i = 0; i < client.getCart().size(); i++) {
                         System.out.println(client.getCart().get(i)+" số lượng muốn mua "+ client.getCount().get(i));
                     }
                     break;
                 case 6:
                     editCart(client, tuanLe);
                     int index;
                     break;


                 case 7:
                     tuanLe.deleteCart(client);
                     System.out.println("Đã xóa thành công giỏ hàng");
                     break;
                 case 8:

                     System.out.println("Tổng giá trị giỏ hàng là "+tuanLe.getSumOfCart(client));
                     break;
                 case 9:

                     pay(client, tuanLe, tuan, tuanLeMinh);
                     break;
                 case 10:
                     tuanLeMinh.showWaitCart(client);
                     break;
                 case 11:
                     confirmReceived(client, tuanLeMinh);
                     break;
                 case 0:
                     showMenuClient(tuanLe, tuan, tuanLeMinh);


             }
            
        }while(choice!=0);
    }

    private static void confirmReceived(Client client, CustomerOrderController tuanLeMinh) {
        int index;
        System.out.println("Mời nhập mã đơn hàng đã nhận");
        Scanner scanner4=new Scanner(System.in);
        index=scanner4.nextInt();
        tuanLeMinh.conformReceived(client,index);
    }

    private static void pay(Client client, ClientController tuanLe, ProductController tuan, CustomerOrderController tuanLeMinh) {
        if(tuanLe.checkAvailable(client) && tuanLe.getSumOfCart(client)< client.getMoney()&&tuan.countProductInCart(client)){
            tuan.subtractProduct(client);
            tuanLe.subtractMoney(client);
            tuanLeMinh.createNewOrder(client);
            tuanLe.deleteCart(client);
            System.out.println("Thanh toán thành công");
        }else{
            System.out.println("Bạn không còn đủ tiền hoặc cửa hàng đã hết sản phẩm bạn muốn mua");
        }
    }

    private static void editCart(Client client, ClientController tuanLe) {
        String id;
        System.out.println("Nhập id sản phẩm");
        Scanner scanner3=new Scanner(System.in);
        id =scanner3.nextLine();
        int index= tuanLe.getIndexById(client,id);
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
    }

    private static void addProductToCart(Client client, ClientController tuanLe, ProductController tuan) {
        System.out.println("Nhập id sản phẩm");
        Scanner scanner2=new Scanner(System.in);
        String id=scanner2.nextLine();
        Product product= tuan.getProductById(id);
        if(product==null){
            System.out.println("Bạn đã nhập sai id");
        }else {
            System.out.println("Nhập số lượng sản phẩm");
            Scanner scanner3=new Scanner(System.in);
            double numberWantToBuy=scanner3.nextDouble();
            if(numberWantToBuy>0) {
                int position = tuanLe.checkProductInCart(client, product);
                tuanLe.addProductToCart(position, client,numberWantToBuy,product);
                System.out.println("Thêm hàng thành công");
            }else {
                System.out.println("Số lượng sản phẩm không hợp lệ");
            }
        }
    }

    private static void depositMoney(Client client, ClientController tuanLe) {
        System.out.println("Nhập số tiền muốn nạp");
        Scanner scanner1=new Scanner(System.in);
        double money=scanner1.nextDouble();
        if(money>0){
        tuanLe.increaseMoney(client,money);
        System.out.println("Nạp tiền thành công");
        } else {
            System.out.println("Số tiền bạn nhập không hợp lệ");
        }
    }

    private static void showMenuClient() {
        System.out.println("1. Nạp tiền");
        System.out.println("2. Kiểm tra tiền ");
        System.out.println("3. Xem thông tin sản phẩm");
        System.out.println("4. Thêm vào giỏ hàng");
        System.out.println("5. Xem giỏ hàng");
        System.out.println("6. Sửa giỏ hàng");
        System.out.println("7. Xóa giỏ hàng");
        System.out.println("8. Tính tiền giỏ hàng");
        System.out.println("9. Thanh toán");
        System.out.println("10. Xem giỏ hàng đang vận chuyển");
        System.out.println("11. Xác nhận nhận hàng");
        System.out.println("0. Đăng xuất");
    }

    private static void showMenu() {
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng kí");
        System.out.println("0. Thoát");
    }
}
