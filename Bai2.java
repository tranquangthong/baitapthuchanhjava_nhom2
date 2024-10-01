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
public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập điểm trung bình
        System.out.print("Nhap diem trung binh cua hoc sinh: ");
        double diemTrungBinh = scanner.nextDouble();

        if (diemTrungBinh >= 8.5) {
            System.out.println("Hoc sinh xep loai: Gioi");
        } else if (diemTrungBinh >= 7.0) {
            System.out.println("Hoc sinh xep loai: Kha");
        } else if (diemTrungBinh >= 5.0) {
            System.out.println("Hoc sinh xep loai: Trung binh");
        } else {
            System.out.println("Hoc sinh xep loai: Yeu");
        }
    }
}
