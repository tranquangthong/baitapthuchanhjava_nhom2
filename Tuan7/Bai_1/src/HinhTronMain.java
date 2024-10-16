import java.util.Scanner;
public class HinhTronMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập bán kính của hình tròn: ");
        double banKinh = scanner.nextDouble();

        HinhTron ht = new HinhTron(banKinh);
        System.out.println("Chu vi: " + ht.tinhChuVi());
        System.out.println("Diện tích: " + ht.tinhDienTich());

        scanner.close();
    }
}