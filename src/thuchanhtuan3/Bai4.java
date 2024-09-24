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
public class Bai4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.printf("Nhap so a:");
        int a=sc.nextInt();
        System.out.printf("\nNhap so b:");
        int b=sc.nextInt();
        System.out.printf("\nNhap so c:");
        int c=sc.nextInt();
        int min=a;
        if(min>b){
            min=b;
        }
        if(min>c){
            min=c;
        }
        System.out.println("So be nhat trong 3 so la:"+min);
    }
}
