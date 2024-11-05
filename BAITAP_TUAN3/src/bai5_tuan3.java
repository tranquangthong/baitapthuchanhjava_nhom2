
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hi
 */
public class bai5_tuan3 {
    public static void main(String[] args) {
        int a,b,c;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap 3 canh :");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        if(a+b>c && a+c>b && b+c>a)
        {  
            System.out.println("3 canh nhap vao tao thanh 1 tam giac");
        if(a==b && b==c)
            System.out.println("day la tam giac deu");
        else
        if(b*b==a*a+c*c || a*a==b*b+c*c || c*c==a*a+b*b)
                System.out.println("day la tam giac vuong");
        else
        if(a==b || a==c || b==c)
            {
                if(a==b && b!=c)
                    System.out.println("day la tam giac can");
                if(a!=b && b==c)
                    System.out.println("day la tam giac can");
                if(a==c && c!=b)
                    System.out.println("day la tam giac can");
            }
        else
            System.out.println("day la tam giac thuong");
        }
        else
            System.out.println("3 canh nhap vao khong tao thanh 1 tam giac");
    }
}
