package Tuan3;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Chọn phép tính: ");
            System.out.println("1. Cộng (+)");
            System.out.println("2. Trừ (-)");
            System.out.println("3. Nhân (*)");
            System.out.println("4. Chia (/)");

            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();

            System.out.print("Nhập số thứ nhất: ");
            double num1 = scanner.nextDouble();
            System.out.print("Nhập số thứ hai: ");
            double num2 = scanner.nextDouble();

            double result;

            switch (choice) {
                case 1 -> {
                    result = num1 + num2;
                    System.out.println("Kết quả: " + num1 + " + " + num2 + " = " + result);
                }
                case 2 -> {
                    result = num1 - num2;
                    System.out.println("Kết quả: " + num1 + " - " + num2 + " = " + result);
                }
                case 3 -> {
                    result = num1 * num2;
                    System.out.println("Kết quả: " + num1 + " * " + num2 + " = " + result);
                }
                case 4 -> {
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("Kết quả: " + num1 + " / " + num2 + " = " + result);
                    } else {
                        System.out.println("Lỗi: Không thể chia cho 0.");
                    }
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
