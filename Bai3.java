package Tuan3;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            Float a, b, c, delta, x, x1, x2;
            System.out.println("Nhap a: ");
            a = sc.nextFloat();
            System.out.println("Nhap b: ");
            b = sc.nextFloat();
            System.out.println("Nhap c: ");
            c = sc.nextFloat();
            if(a==0){
                if(b==0){
                    if(c==0){
                        System.out.println("Phuong trinh co vo so nghiem");
                    }
                    else{
                        System.out.println("Phuong trinh vo nghiem");
                    }
                }
                else{
                    x = -c/b;
                    System.out.printf("Phuong trinh co nghiem x= " + x);
                }
            }
            else{
                delta=b*b-4*a*c;
                if(delta<0){
                    System.out.println("Phuong trinh vo nghiem");
                }
                if(delta==0){
                    x=(-b)/(2*a);
                    System.out.printf("Phuong trinh có nghiem kep la x= " + x);
                }
                if(delta>0){
                    x1=(float) ((-b+Math.sqrt(delta))/(2*a));
                    x2=(float) ((-b-Math.sqrt(delta))/(2*a));
                    System.out.println("Phuong trinh co 2 nghiem la"+ x1 + " va " + x2);
                }
            }
        }
    }
}
