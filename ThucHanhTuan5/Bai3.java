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
public class Bai3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.printf("Nhap so phan tu cua mang:");
        int n=sc.nextInt();
        int[] mang=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Nhap so thu "+(i+1)+" : ");
            mang[i]=sc.nextInt();
        }
        for(int i=0;i<n-1;i++){
            for(int j=i;j<n;j++){
                if(mang[i]>mang[j]){
                    int tmp=mang[i];
                    mang[i]=mang[j];
                    mang[j]=tmp;
                }
            }
        }
        System.out.printf("Mang tang dan la: ");
        for(int i=0;i<n;i++){
            System.out.printf(mang[i]+" ");
        }
    }
}
