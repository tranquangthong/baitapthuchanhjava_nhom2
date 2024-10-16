package Tuan3;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        float n;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao 1 so: ");
        n = sc.nextFloat();
        if(n > 0)
        System.out.println("n la so duong");
        else if (n < 0)
        System.out.println("n la so am");
        else 
        System.out.println("n bang 0");
    }
}
