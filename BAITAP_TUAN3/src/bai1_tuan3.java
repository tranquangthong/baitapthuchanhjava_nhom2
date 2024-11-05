/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai1_tuan3;

import java.util.Scanner;

/**
 *
 * @author Hi
 */
//public class Vidu1 {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        
//    }
//    
//}
public class bai1_tuan3 {
    public static void main(String[] args) {
        int a;
        System.out.println("nhap so :");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        if (a < 0)
            System.out.println("so vua nhap la so am");
        else 
            if(a == 0)
                System.out.println("so vua nhap bang 0");
        else
                System.out.println("so vua nhap la so duong");
    }
}