package Tuan3;

import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chọn phép tính:");
        System.out.println("1. Cộng");
        System.out.println("2. Trừ");
        System.out.println("3. Nhân");
        System.out.println("4. Chia");
        System.out.print("Nhập lựa chọn (1-4): ");
        int choice = scanner.nextInt();

        System.out.print("Nhập số thứ nhất: ");
        double num1 = scanner.nextDouble();
        System.out.print("Nhập số thứ hai: ");
        double num2 = scanner.nextDouble();

        double result = 0;
        boolean luachonhople = true;

        switch (choice) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:

                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Lỗi: Không thể chia cho 0.");
                    luachonhople = false;
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                luachonhople = false;
                break;
        }

        if (luachonhople) {
            System.out.println("Kết quả: " + result);
        }
    }
}
