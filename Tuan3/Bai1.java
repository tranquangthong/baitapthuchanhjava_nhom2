package Tuan3;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Nhap so: ");
            Long a = sc.nextLong();
            if(a!=0){
                if(a<0){
                    System.out.println("la so am");
                }
                else{
                    System.out.println("la so duong");
                }
            }
            else{
                System.out.println("La so 0");
            }
        }
    }
}
