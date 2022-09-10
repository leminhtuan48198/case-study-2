package view;

import controller.CustomerOrderController;
import controller.ProductController;
import controller.ShopController;
import model.Fruit;
import model.Meat;
import model.Shop;

import java.time.LocalDate;
import java.util.Scanner;

public class MainManager {
    public static void main(String[] args) {
        ShopController boss = new ShopController();
        ProductController tuan= new ProductController("tuan");
        CustomerOrderController tuanLeMinh=new CustomerOrderController();
        displayMainScreen(boss,tuan,tuanLeMinh);

    }

    private static void displayMainScreen(ShopController boss, ProductController tuan,CustomerOrderController tuanLeMinh) {
        int choice=0;
        do{
            System.out.println("--Danh mục--");
            System.out.println("1. Quản lí cửa hàng");
            System.out.println("2. Quản lí sản phẩm thịt");
            System.out.println("3. Quản lí sản phẩm quả");
            System.out.println("4. Các chức năng khác");
            System.out.println("0. Kết thúc");
            Scanner scanner=new Scanner(System.in);
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    displayShopMenu(boss,tuan,tuanLeMinh);
                    break;
                case 2:
                    displayMeatMenu(boss,tuan,tuanLeMinh);
                    break;
                case 3:
                    displayFruitMenu(boss,tuan,tuanLeMinh);
                    break;
                case 4:
                    displayOthers(boss,tuan,tuanLeMinh);
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice!=0);
    }

    private static void displayOthers(ShopController boss, ProductController tuan, CustomerOrderController tuanLeMinh) {
        int choice=0;
        do{
            System.out.println("--Danh mục các chức năng khác--");
            System.out.println("1. Hiển thị tất cả sản phẩm");
            System.out.println("2. Sắp xếp các sản phẩm theo Id");
            System.out.println("3. Hủy bỏ các sản phẩm hết hạn");
            System.out.println("4. Theo dõi các đơn hàng chưa đóng đơn");
            System.out.println("0. Trở lại");
            Scanner scanner=new Scanner(System.in);
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    tuan.displayAllProduct();
                    break;
                case 2:
                    tuan.sortProductsById();
                    break;
                case 3:
                    tuan.deleteOldProduct();
                    break;
                case 4:
                    tuanLeMinh.showNotReceivedOrder();
                case 0:
                    displayMainScreen(boss,tuan,tuanLeMinh);
            }
        } while (choice!=0);
    }

    private static void displayShopMenu(ShopController boss, ProductController tuan,CustomerOrderController tuanLeMinh) {
        int choice=0;
        do{
            System.out.println("--Danh mục quản lí cửa hàng--");
            System.out.println("1. Thêm cửa hàng");
            System.out.println("2. Sửa thông tin cửa hàng theo Id");
            System.out.println("3. Xóa cửa hàng theo Id");
            System.out.println("4. Hiển thị thông tin các cửa hàng");
            System.out.println("5. Tính tổng tiền của tất cả sản phẩm trong một cửa hàng");
            System.out.println("6. Hiển thị các sản phẩm trong một cửa hàng");
            System.out.println("0. Quay lại");
            Scanner scanner=new Scanner(System.in);
            choice =scanner.nextInt();
            switch (choice){
                case 1:
                    Shop shop=getNewShop(boss);
                    boss.addNewShop(shop);
                    break;
                case 2:
                    editShop(boss);
                    break;
                case 3:
                    deleteShop(boss, tuan);
                    break;
                case 4:
                    boss.displayShops();
                    break;
                case 5:
                    getMoneyOfShop(tuan);
                    break;
                case 6:
                    displayProductsInShop(tuan);
                    break;
                case 0:
                    displayMainScreen(boss,tuan,tuanLeMinh);

            }

        }while(choice!=0);
    }

    private static void displayProductsInShop(ProductController tuan) {
        System.out.println("Mời bạn nhập id cửa hàng");
        Scanner scanner= new Scanner(System.in);
        String idShop=scanner.nextLine();
        tuan.displayProductsInShop(idShop);
    }

    private static void displayMeatMenu(ShopController boss, ProductController tuan, CustomerOrderController tuanLeMinh) {
        int choice=0;
        do{
            System.out.println("--Danh mục quản lí thịt--");
            System.out.println("1. Thêm thịt");
            System.out.println("2. Sửa thông tin thịt");
            System.out.println("3. Xóa thịt");
            System.out.println("4. Hiển thị danh sách thịt");
            System.out.println("0. Quay lại");
            Scanner scanner=new Scanner(System.in);
            choice =scanner.nextInt();
            switch (choice){
                case 1:
                    addMeat(boss, tuan);
                    break;
                case 2:
                    editMeat(boss, tuan);
                    break;
                case 3:
                    removeMeat(tuan);
                    break;
                case 4:
                    tuan.displayMeatList();
                    break;
                case 0:
                    displayMainScreen(boss,tuan,tuanLeMinh);

            }

        }while(choice!=0);
    }



    private static void displayFruitMenu(ShopController boss, ProductController tuan, CustomerOrderController tuanLeMinh) {
        int choice=0;
        do{
            System.out.println("--Danh mục quản lí hoa quả--");
            System.out.println("1. Thêm quả");
            System.out.println("2. Sửa thông tin quả");
            System.out.println("3. Xóa quả");
            System.out.println("4. Hiển thị danh sách quả");
            System.out.println("0. Quay lại");
            Scanner scanner=new Scanner(System.in);
            choice =scanner.nextInt();
            switch (choice){
                case 1:
                    addNewFruit(boss, tuan);
                    break;

                case 2:
                    editFuit(boss, tuan);

                    break;
                case 3:
                    deleteFruit(tuan);
                    break;
                case 4:
                    tuan.displayFruitList();
                    break;
                case 0:
                    displayMainScreen(boss,tuan,tuanLeMinh);

            }

        }while(choice!=0);
    }

    private static void getMoneyOfShop(ProductController tuan) {
        System.out.println("Mời bạn nhập id cửa hàng");
        Scanner scanner1=new Scanner(System.in);
        String idShop=scanner1.nextLine();

        System.out.println("Tổng giá trị sản phẩm của cửa hàng là"+ tuan.getSumOfMoney(idShop));
    }

    private static void deleteFruit(ProductController tuan) {
        int index;
        String id;
        System.out.println("Mời bạn nhập id quả cần xóa");
        Scanner scanner9=new Scanner(System.in);
        id =scanner9.nextLine();
        index = tuan.getIndexFruitById(id);
        tuan.removeFruit(index);
    }

    private static void addNewFruit(ShopController boss, ProductController tuan) {
        Shop shop;
        String id;
        System.out.println("Mời bạn nhập id cửa hàng");
        Scanner scanner7=new Scanner(System.in);
        id=scanner7.nextLine();
        shop= boss.getShopById(id);
        if(shop==null){
            System.out.println("Bạn nhập sai id cửa hàng");
        }else{
            Fruit fruit = getNewFruit(shop,tuan);
            tuan.addNewFruit(fruit);
            System.out.println("Thêm quả thành công");
        }
    }

    private static void removeMeat(ProductController tuan) {
        String id;
        int index;
        System.out.println("Mời bạn nhập id thịt cần xóa");
        Scanner scanner6=new Scanner(System.in);
        id =scanner6.nextLine();
        index = tuan.getIndexMeatById(id);
        tuan.removeMeat(index);
    }

    private static void editMeat(ShopController boss, ProductController tuan) {
        Shop shop;
        String name;
        String id;
        int index;
        System.out.println("Mời bạn nhập id thịt cần sửa");
        Scanner scanner5 = new Scanner(System.in);
        id =scanner5.nextLine();
        index= tuan.getIndexMeatById(id);
        if(index==-1){
            System.out.println("Bạn đã nhập sai id thịt");
        }else{
            System.out.println("Mời bạn nhập tên thịt");
            Scanner scanner6 = new Scanner(System.in);
             name = scanner6.nextLine();
            System.out.println("Mời bạn nhập giá");
            Scanner scanner7 = new Scanner(System.in);
            double price = scanner7.nextDouble();
            System.out.println("Mời bạn nhập ngày sản xuất");
            Scanner scanner8 = new Scanner(System.in);
            int day = scanner8.nextInt();
            System.out.println("Mời bạn nhập tháng sản xuất");
            Scanner scanner9 = new Scanner(System.in);
            int month = scanner9.nextInt();
            System.out.println("Mời bạn nhập năm sản xuất");
            Scanner scanner10 = new Scanner(System.in);
            int year = scanner10.nextInt();
            System.out.println("Mời bạn nhập khối lượng thịt");
            Scanner scanner11 = new Scanner(System.in);
            double weight = scanner11.nextDouble();
            System.out.println("Mời bạn nhập Id cửa hàng ");
            Scanner scanner12 = new Scanner(System.in);
            String idShop = scanner12.nextLine();
             shop = boss.getShopById(idShop);
            if(shop!=null){
                tuan.editMeat(index,name,shop,price,year,month,day,weight);
            }else{
                System.out.println("Cửa hàng bạn nhập không đúng");
            }
        }
    }

    private static void addMeat(ShopController boss, ProductController tuan) {
        Meat meat=getNewMeat(boss,tuan);
        if(meat!=null){
            tuan.addNewMeat(meat);
        }else{
            System.out.println("Cửa hàng bạn nhập không đúng");
        }
    }

    private static void deleteShop(ShopController boss,ProductController tuan) {
        String id;
        int index;
        System.out.println("Mời bạn nhập id cửa hàng cần xóa");
        Scanner scanner4=new Scanner(System.in);
        id =scanner4.nextLine();
        index= boss.findShopIndexById(id);
        boss.deleteShop(index);
        tuan.deleteShop(id);
    }

    private static void editShop(ShopController boss) {
        System.out.println("Mời bạn nhập id cửa hàng cần sửa");
        Scanner scanner1=new Scanner(System.in);
        String id =scanner1.nextLine();
        int index= boss.findShopIndexById(id);
        System.out.println("Mời bạn nhập tên cửa hàng");
        Scanner scanner2=new Scanner(System.in);
        String name =scanner2.nextLine();
        System.out.println("Mời bạn nhập địa chỉ cửa hàng");
        Scanner scanner3=new Scanner(System.in);
        String address=scanner3.nextLine();
        boss.editShop(index,name,address);
    }

    private static void editFuit(ShopController boss, ProductController tuan) {
        int index;
        String name;
        String id;
        Shop shop;
        System.out.println("Mời bạn nhập id quả cần sửa");
        Scanner scanner8 = new Scanner(System.in);
        id =scanner8.nextLine();
        index= tuan.getIndexFruitById(id);
        if(index==-1){
            System.out.println("Bạn đã nhập sai id quả");
        }else{
            System.out.println("Mời bạn nhập id cửa hàng");
            Scanner scanner9=new Scanner(System.in);
            id=scanner9.nextLine();
            shop= boss.getShopById(id);
            if(shop==null){
                System.out.println("Id cửa hàng không hợp lệ");
            }else{
                System.out.println("Mời bạn nhâp tên quả");
                Scanner scanner10 = new Scanner(System.in);
                name = scanner10.nextLine();
                System.out.println("Mời bạn nhập giá");
                Scanner scanner11 = new Scanner(System.in);
                double price = scanner11.nextDouble();
                System.out.println("Mời bạn nhập ngày sản xuất");
                Scanner scanner12 = new Scanner(System.in);
                int day = scanner12.nextInt();
                System.out.println("Mời bạn nhập tháng sản xuất");
                Scanner scanner13= new Scanner(System.in);
                int month = scanner13.nextInt();
                System.out.println("Mời bạn nhập năm sản xuất");
                Scanner scanner14 = new Scanner(System.in);
                int year = scanner14.nextInt();
                System.out.println("Mời bạn nhập số lượng quả");
                Scanner scanner15 = new Scanner(System.in);
                int quantity = scanner15.nextInt();
                tuan.editFruit(index,name,shop,price,year,month,day,quantity);
            }
        }
    }

    private static Fruit getNewFruit(Shop shop,ProductController tuan) {
        Fruit fruit =null;
        Scanner scanner = new Scanner(System.in);
        int index;
        String id;
        do{
        System.out.println("Mời bạn nhập id quả mới");
         id= scanner.nextLine();
        index=tuan.getIndexFruitById(id);
        }while (index>-1);

        System.out.println("Mời bạn nhập tên quả");
        Scanner scanner1 = new Scanner(System.in);
        String name = scanner1.nextLine();
        System.out.println("Mời bạn nhập giá");
        Scanner scanner2 = new Scanner(System.in);
        double price = scanner2.nextDouble();
        System.out.println("Mời bạn nhập ngày sản xuất");
        Scanner scanner3 = new Scanner(System.in);
        int day = scanner3.nextInt();
        System.out.println("Mời bạn nhập tháng sản xuất");
        Scanner scanner4 = new Scanner(System.in);
        int month = scanner4.nextInt();
        System.out.println("Mời bạn nhập năm sản xuất");
        Scanner scanner5 = new Scanner(System.in);
        int year = scanner5.nextInt();
        System.out.println("Mời bạn nhập số lượng quả");
        Scanner scanner6 = new Scanner(System.in);
        int quantity = scanner6.nextInt();
        fruit= new Fruit(id,name,shop,price,LocalDate.of(year,month,day),quantity);
        return fruit;
    }

    private static Meat getNewMeat(ShopController boss,ProductController tuan) {
        Meat meat =null;
        int index;
        Scanner scanner = new Scanner(System.in);
        String id;
        do {
            System.out.println("Mời bạn nhập id thịt mới");
            id = scanner.nextLine();
            index = tuan.getIndexMeatById(id);
        }while (index>-1);
        System.out.println("Mời bạn nhâp tên thịt");
        Scanner scanner1 = new Scanner(System.in);
        String name = scanner1.nextLine();
        System.out.println("Mời bạn nhập giá");
        Scanner scanner2 = new Scanner(System.in);
        double price = scanner2.nextDouble();
        System.out.println("Mời bạn nhập ngày sản xuất");
        Scanner scanner3 = new Scanner(System.in);
        int day = scanner3.nextInt();
        System.out.println("Mời bạn nhập tháng sản xuất");
        Scanner scanner4 = new Scanner(System.in);
        int month = scanner4.nextInt();
        System.out.println("Mời bạn nhập năm sản xuất");
        Scanner scanner5 = new Scanner(System.in);
        int year = scanner5.nextInt();
        System.out.println("Mời bạn nhập khối lượng thịt");
        Scanner scanner6 = new Scanner(System.in);
        double weight = scanner6.nextDouble();
        System.out.println("Mời bạn nhập Id cửa hàng ");
        Scanner scanner7 = new Scanner(System.in);
        String idShop = scanner7.nextLine();
        Shop shop = boss.getShopById(idShop);
        if(shop!=null){
            meat =new Meat(id,name,shop,price, LocalDate.of(year,month,day),weight);
        }
        return meat;
    }


    private static Shop getNewShop(ShopController boss) {
        Scanner scanner1=new Scanner(System.in);
        String id;
        int index;
        do{
            System.out.println("Mời bạn nhập Id cửa hàng");
         id =scanner1.nextLine();
         index=boss.findShopIndexById(id);
    }while (index>-1);
        System.out.println("Mời bạn nhập tên cửa hàng");
        Scanner scanner2=new Scanner(System.in);
        String name =scanner2.nextLine();
        System.out.println("Mời bạn nhập địa chỉ cửa hàng");
        Scanner scanner3=new Scanner(System.in);
        String address =scanner3.nextLine();
        Shop shop =new Shop(id,name,address);
        return shop;
    }
}
