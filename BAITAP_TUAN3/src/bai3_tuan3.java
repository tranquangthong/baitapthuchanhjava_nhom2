
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hi
 */
public class bai3_tuan3 {
    public static void main(String[] args) {
        double a,b,c,dt,x1,x2;
        System.out.println("nhap a b c :");
        Scanner sc = new Scanner(System.in);
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        if(a==0)
        {
            x1 = -c/b;
            System.out.println("pt co 1 nghiem la x = " + x1);
        }
        else
        {  
            dt = b*b-4*a*c;
            if(dt<0)
                System.out.println("pt vo nghiem");
            else
                if(dt==0)
                    System.out.println("pt co nghiem kep x1 = x2 = " + (-b/(2*a)));
            else
                {
                    System.out.println("pt co 2 nghiem phan biet");
                    x1 = (-b + Math.sqrt(dt))/(2*a);
                    x2 = (-b - Math.sqrt(dt))/(2*a);
                    System.out.println("x1 = " + x1 );
                    System.out.println("x2 = " + x2 );
                }
        }

    }
}
