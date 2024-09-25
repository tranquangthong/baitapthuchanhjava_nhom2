package Tuan3;

import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập độ dài cạnh a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập độ dài cạnh b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập độ dài cạnh c: ");
        double c = scanner.nextDouble();

        if (isTamGiac(a, b, c)) {
            String loaiTamGiac = xacDinhLoaiTamGiac(a, b, c);
            System.out.println("Ba cạnh này tạo thành một tam giác " + loaiTamGiac + ".");
        } else {
            System.out.println("Ba cạnh này không tạo thành tam giác.");
        }
    }

    public static boolean isTamGiac(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static String xacDinhLoaiTamGiac(double a, double b, double c) {
        if (a == b && b == c) {
            return "đều";
        } else if (a == b || b == c || a == c) {
            return "cân";
        } else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
            return "vuông";
        } else {
            return "thường";
        }
    }
}
