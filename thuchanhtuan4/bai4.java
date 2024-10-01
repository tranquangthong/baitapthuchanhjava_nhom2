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
public class bai4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap so n:");
        int n=sc.nextInt();
        if(soNgTo(n)){
            System.out.println(n+" la so nguyen to!");
        } else {
            System.out.println(n+" khong phai la so nguyen to!");
        }
        
    }
    public  static boolean soNgTo(int n){
        if (n<=1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
