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
public class Bai1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap so phan tu cua mang: ");
        int n=sc.nextInt();
        int[] mang=new int[n];
        int tong=0;
        for(int i=0;i<n;i++){
            System.out.println("Nhap phan tu thu "+(i+1)+" : ");
            mang[i]=sc.nextInt();
            tong+=mang[i];
        }
        System.out.println("Tong cac phan tu trong mang la: "+tong);
    }
}
