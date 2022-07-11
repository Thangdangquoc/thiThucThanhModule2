import java.io.*;
import java.util.*;

public class ManagerProduct {
    Scanner inputs = new Scanner(System.in);
    public ArrayList<Product> arrayListProduct = new ArrayList<>();

    public void addProduct() {
        try {
            System.out.println("Mã sản phẩm: ");
            int codeProduct = Integer.parseInt(inputs.nextLine());
            while (true) {
                if (!checkCodeProduct(codeProduct)) {
                    System.out.println("Mã sản phẩm: ");
                    codeProduct = Integer.parseInt(inputs.nextLine());
                } else {
                    break;
                }
            }
            System.out.println("Tên sản phầm:");
            String nameProduct = inputs.nextLine();
            System.out.println("Giá sản phẩm: ");
            int price = Integer.parseInt(inputs.nextLine());
            System.out.println("Số lượng sản phẩm: ");
            int quantity = Integer.parseInt(inputs.nextLine());
            System.out.println("Mô tả sản phẩm: ");
            String painted = inputs.nextLine();
            Product product = new Product(codeProduct, nameProduct, price, quantity, painted);
            arrayListProduct.add(product);

        } catch (InputMismatchException ei) {
            System.out.println("Bạn đã nhập , xin vui lòng nhập lại!");
        } catch (Exception e) {
            System.out.println("Bạn đã nhập , xin vui lòng nhập lại!");
        }
    }

    //    public void addProduct(){
//        Product product = createProduct();
//        arrayListProduct.add(product);
//    }
    public void displayProduct() {
        System.out.println("Danh sách sản phẩm: ");
        for (Product product : arrayListProduct) {
            System.out.println(product);
        }
    }

    public void editProduct() {
        System.out.println("Nhập mã sản phẩm muốn cập nhật: ");
        int codeProduct = Integer.parseInt(inputs.nextLine());
        for (int i = 0; i < arrayListProduct.size(); i++) {
            if (arrayListProduct.get(i).getCodeProduct() == codeProduct) {
                System.out.println("Mã sản phẩm: ");
                int newCodeProduct = Integer.parseInt(inputs.nextLine());
                System.out.println("Tên sản phầm:");
                String nameProduct = inputs.nextLine();
                System.out.println("Giá sản phẩm: ");
                int price = Integer.parseInt(inputs.nextLine());
                System.out.println("Số lượng sản phẩm: ");
                int quantity = Integer.parseInt(inputs.nextLine());
                System.out.println("Mô tả sản phẩm: ");
                String painted = inputs.nextLine();
                arrayListProduct.get(i).setCodeProduct(newCodeProduct);
                arrayListProduct.get(i).setNameProduct(nameProduct);
                arrayListProduct.get(i).setPrice(price);
                arrayListProduct.get(i).setQuantity(quantity);
                arrayListProduct.get(i).setPainted(painted);
            } else {
                System.out.println("Mã sản phẩm không tồn tại!");
            }
        }
    }

    public void deleteProduct() {
        System.out.println("Nhập mã sản phẩm muốn xóa: ");
        int codeProduct = Integer.parseInt(inputs.nextLine());
        for (int i = 0; i < arrayListProduct.size(); i++) {
            if (arrayListProduct.get(i).getCodeProduct() == codeProduct) {
                arrayListProduct.remove(i);
            }else {
                System.out.println("Mã sản phẩm không tồn tại!");
            }
        }
    }

    public boolean checkCodeProduct(int codeProduct) {
        for (int i = 0; i < arrayListProduct.size(); i++) {
            if (arrayListProduct.get(i).getCodeProduct() == codeProduct) {
                System.out.println("Trùng rồi xin nhập lại");
                return false;
            }
        }
        return true;
    }
    public void writeFileProduct(List<Product> productList) {
        try {
            File file = new File("products.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Product product : arrayListProduct) {
                bufferedWriter.write(product.getCodeProduct() + "," + product.getNameProduct() + "," + product.getPrice() + "," + product.getQuantity() + "," + product.getPainted()  +"\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("loi5");
        }
    }

    public  void readFileProductList() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            File file = new File("products.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                Product product = new Product(Integer.parseInt(strings[0]), strings[1], Integer.parseInt(strings[2]), Integer.parseInt(strings[3]), strings[4]);
                products.add(product);
            }
            bufferedReader.close();
            arrayListProduct = products;
        } catch (IOException e) {
            System.out.println("loi4");
        }
    }
    Comparator<Product> compareUp = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return (o1.getPrice() - o2.getPrice());
        }
    } ;

    Comparator<Product> compareDown = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return (o2.getPrice() - o1.getPrice());
        }
    } ;

    // Sắp xếp tăng dần
    public void displayUp(){
        System.out.println("Sản phẩm được sắp xếp tăng dần ...");
        arrayListProduct.sort(compareUp);
        displayProduct();
    }

    public void displayDown(){
        System.out.println("Sản phẩm được sắp xếp giảm dần ...");
        arrayListProduct.sort(compareDown);
        displayProduct();
    }


}
