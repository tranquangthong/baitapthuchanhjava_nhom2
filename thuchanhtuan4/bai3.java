/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanhtuan4;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số nguyên dương: ");
        int n = scanner.nextInt();
        long giaiThua = 1;
        
        for (int i = 1; i <= n; i++) {
            giaiThua *= i;
        }
        
        System.out.println("Giai thừa của " + n + " là: " + giaiThua);
    }
}
