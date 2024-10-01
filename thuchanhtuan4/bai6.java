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
public class bai6 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số nguyên: ");
        int n = scanner.nextInt();
        
        if (ktra(n)) {
            System.out.println(n + " là số đối xứng.");
        } else {
            System.out.println(n + " không phải là số đối xứng.");
        }
    }
    public static boolean ktra(int n){
        int latNguoc=0;
        int so=n;
        while (n!=0){
            int tmp=n%10;
            latNguoc=latNguoc*10+tmp;
            n/=10;
        }
        return so==latNguoc;
    }
}
