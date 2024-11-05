
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hi
 */
public class bai6_tuan3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap a:");
        double a = sc.nextDouble();
        System.out.println("nhap b:");
        double b = sc.nextDouble();
        double kq;
        System.out.println("chon phep tinh :");
        System.out.println("1. +");
        System.out.println("2. -");
        System.out.println("3. *");
        System.out.println("4. /");

        int c = sc.nextInt();
        switch (c)
        {
            case 1:
                kq = a+b;
                System.out.println("ket qua :" + a +" + " + b +" = " + kq);
                break;
            case 2:
                kq = a-b;
                System.out.println("ket qua :" + a +" - " + b +" = " + kq);
                break;
            case 3:
                kq = a*b;
                System.out.println("ket qua :" + a +" * " + b +" = " + kq);
                break;
            case 4:
                kq = a/b;
                System.out.println("ket qua :" + a +" / " + b +" = " + kq);
                break;
        }
        

    }
}
