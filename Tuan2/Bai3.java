
import java.util.Scanner;

public class Bai3{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a, b;
            System.out.println("Nhap a: ");
            a = sc.nextInt();
            System.out.println("Nhap b: ");
            b = sc.nextInt();
            long Tong, Hieu, Tich;
            Tong = a + b;
            Hieu = a - b;
            Tich = a*b;
            float Thuong, Du;
            Thuong = (float)a/b;
            Du = (float)a%b;
            System.out.println("Tong la: " + Tong);
            System.out.println("Hieu la: " + Hieu);
            System.out.println("Tich la: " + Tich);
            System.out.println("Thuong la: " + Thuong);
            System.out.println("So du la: " + Du);
        }
    }
}