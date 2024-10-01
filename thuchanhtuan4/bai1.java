/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package thuchanhtuan4;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class bai1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap so n:");
        int n=sc.nextInt();
        int tong=0;
        for(int i=1;i<=n;i++){
            tong+=i;
        }
        System.out.println("Tong tu 1 den n la:"+tong);
    }
    
}
