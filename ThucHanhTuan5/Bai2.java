/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanhtuan5;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so luong phan tu: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Nhap cac phan tu cua mang : ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Mang sau khi dao nguoc la: ");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
