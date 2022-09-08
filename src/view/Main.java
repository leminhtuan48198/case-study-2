package view;

import controller.ProductController;
import controller.ShopController;
import model.Meat;
import model.Shop;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShopController boss=new ShopController();
        ProductController tuan=new ProductController("tuan");
        int choice=0;
        do {
            showMenu();
            Scanner scanner=new Scanner(System.in);
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    Shop shop=getNewShop();
                    boss.addNewShop(shop);
                break;
                case 2:
                    System.out.println("Mời bạn nhập id cửa hàng cần sửa");
                    Scanner scanner1=new Scanner(System.in);
                    String id =scanner1.nextLine();
                    int index=boss.findShopIndexById(id);
                    System.out.println("Mời bạn nhập tên cửa hàng");
                    Scanner scanner2=new Scanner(System.in);
                    String name =scanner2.nextLine();
                    System.out.println("Mời bạn nhập địa chỉ cửa hàng");
                    Scanner scanner3=new Scanner(System.in);
                    String address=scanner3.nextLine();
                    boss.editShop(index,name,address);
                    break;
                case 3:
                    System.out.println("Mời bạn nhập id cửa hàng cần xóa");
                    Scanner scanner4=new Scanner(System.in);
                     id =scanner4.nextLine();
                     index= boss.findShopIndexById(id);
                     boss.deleteShop(index);
                    break;
                case 4:
                    boss.displayShops();
                    break;
                case 5:
                    Meat meat=getNewMeat(boss);
                    if(meat!=null){
                        tuan.addNewMeat(meat);
                    }else{
                        System.out.println("Cửa hàng bạn nhập không đúng");
                    }
                    break;
                case 6:
                    System.out.println("Mời bạn nhập id thịt cần sửa");
                    Scanner scanner5 = new Scanner(System.in);
                     id =scanner5.nextLine();
                    index= tuan.getMeatById(id);
                    if(index==-1){
                        System.out.println("Bạn đã nhập sai id thịt");
                    }else{
                        System.out.println("Mời bạn nhập tên thịt");
                        Scanner scanner6 = new Scanner(System.in);
                         name = scanner6.nextLine();
                        System.out.println("Mời bạn nhập giá");
                        Scanner scanner7 = new Scanner(System.in);
                        Double price = scanner7.nextDouble();
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
                case 7:

                case 8:
                case 9:
                case 10:
                case 11:
                case 0:
                    System.exit(0);
            }
        } while (choice!=0);

    }

    private static Meat getNewMeat(ShopController boss) {
        Meat meat =null;
        System.out.println("Mời bạn nhập id thịt");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        System.out.println("Mời bạn nhâp tên thịt");
        Scanner scanner1 = new Scanner(System.in);
        String name = scanner1.nextLine();
        System.out.println("Mời bạn nhập giá");
        Scanner scanner2 = new Scanner(System.in);
        Double price = scanner2.nextDouble();
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

    private static void showMenu() {
        System.out.println("--Danh mục--");
        System.out.println("1. Thêm cửa hàng");
        System.out.println("2. Sửa thông tin cửa hàng theo Id");
        System.out.println("3. Xóa cửa hàng theo Id");
        System.out.println("4. Hiển thị thông tin các cửa hàng");
        System.out.println("5. Thêm thịt");
        System.out.println("6. Sửa thông tin thịt");
        System.out.println("7. Xóa thịt");
        System.out.println("8. Thêm quả");
        System.out.println("9. Sửa thông tin quả");
        System.out.println("10. Xóa quả");
        System.out.println("11. Hiển thị tất cả sản phẩm");
    }

    private static Shop getNewShop() {
        System.out.println("Mời bạn nhập Id cửa hàng");
        Scanner scanner1=new Scanner(System.in);
        String id =scanner1.nextLine();
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
