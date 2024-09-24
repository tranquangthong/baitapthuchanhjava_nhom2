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
public class Bai5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap canh thu nhat:");
        int a=sc.nextInt();
        System.out.println("Nhap canh thu hai:");
        int b=sc.nextInt();
        System.out.println("Nhap canh thu baL");
        int c=sc.nextInt();
        if((a+b)>c && (a+c)>b && (b+c)>a) {
            System.out.println("Ba canh tao thanh tam giac!");
            if(a==b || a==c||b==c) {
                System.out.println("La tam giac can!");
            }
            else
            if(a==b && b==c){
                System.out.println("Tam giac da cho la tam giac deu!");
            }
            else
            if(((a*a+b*b)==c*c)||((a*a|c*c)==b*b)||((b*b+c*c==a*a))){
                System.out.println("Tam giac da cho la tam giac vuong!");
            }
            else {
                System.out.println("Tam giac da cho la tam giac thuong!");
            }
        }
        else {
            System.out.println("Ba canh khong tao thanh tam giac!");
        }
    }
}
