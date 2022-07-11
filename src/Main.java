import java.io.File;
import java.util.Scanner;

public class Main {
    static ManagerProduct managerProduct = new ManagerProduct();
    public static void main(String[] args) {
        int choice;
        int choice1;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM----");
            System.out.println("CHọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("9. Thoát");
            System.out.println("Chọn chức năng: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    managerProduct.displayProduct();
                    break;
                case 2:
                    managerProduct.addProduct();
                    break;
                case 3:
                    managerProduct.editProduct();
                    break;
                case 4:
                    managerProduct.deleteProduct();
                    break;
                case 5:
                    do {
                        System.out.println("-----Menu-----");
                        System.out.println("1. Giá tăng dần");
                        System.out.println("2. Giá giảm dần");
                        System.out.println("3. Quay lại menu");
                        System.out.println("====>Lựa chọn của bạn");
                        choice1 = scanner.nextInt();
                        switch (choice1){
                            case 1:
                                managerProduct.displayUp();
                                break;
                            case 2:
                                managerProduct.displayDown();
                                break;
                        }
                    }while (choice1!=3);
                    break;
                case 6:

                    break;
                case 7:
                    managerProduct.readFileProductList();
                    break;
                case 8:
                    managerProduct.writeFileProduct(managerProduct.arrayListProduct);
                    break;

            }
        }while (choice!=9);
    }
}