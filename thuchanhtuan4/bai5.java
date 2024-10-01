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
public class bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên thứ nhất: ");
        int a = scanner.nextInt();
        System.out.print("Nhập số nguyên thứ hai: ");
        int b = scanner.nextInt();
        
        int ucln = timUCLN(a, b);
        int bcnn = timBCNN(a, b, ucln);
        
        System.out.println("UCLN của " + a + " và " + b + " là: " + ucln);
        System.out.println("BCNN của " + a + " và " + b + " là: " + bcnn);
    }
public static int timUCLN(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static int timBCNN(int a, int b, int ucln) {
        return (a * b) / ucln;
    }
}
