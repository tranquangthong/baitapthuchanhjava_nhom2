/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanhtuan3;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập hai số từ người dùng
        System.out.print("Nhập số thứ nhất: ");
        double num1 = scanner.nextDouble();

        System.out.print("Nhập số thứ hai: ");
        double num2 = scanner.nextDouble();

        // Hiển thị menu lựa chọn
        System.out.println("Chọn phép tính:");
        System.out.println("1. Cộng");
        System.out.println("2. Trừ");
        System.out.println("3. Nhân");
        System.out.println("4. Chia");

        // Nhập lựa chọn của người dùng
        int choice = scanner.nextInt();

        // Thực hiện phép tính dựa trên lựa chọn
        switch (choice) {
            case 1:
                System.out.println("Kết quả: " + (num1 + num2));
                break;
            case 2:
                System.out.println("Kết quả: " + (num1 - num2));
                break;
            case 3:
                System.out.println("Kết quả: " + (num1 * num2));
                break;
            case 4:
                if (num2 != 0) {
                    System.out.println("Kết quả: " + (num1 / num2));
                } else {
                    System.out.println("Lỗi: Không thể chia cho 0.");
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }
}
