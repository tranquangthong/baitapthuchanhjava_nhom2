package Tuan3;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            Float a, b, c;
            System.out.println("Nhap a: ");
            a = sc.nextFloat();
            System.out.println("Nhap b: ");
            b = sc.nextFloat();
            System.out.println("Nhap c: ");
            c = sc.nextFloat();
            Float min = a;
            if(min>b){
                min=b;
                if(min>c){
                    min=c;
                }
            }
            else{
                if(min>c){
                    min=c;
                }
            }
            System.out.print("So nho nhat la: " + min);
        }
    }

}
