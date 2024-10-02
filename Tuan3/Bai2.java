package Tuan3;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Nhap diem TB: ");
            float tb=sc.nextFloat();
            if(tb>=8){
                System.out.println("La hoc sinh gioi");
            }
            else{
                if(tb>=6.5){
                    System.out.println("La hoc sinh kha");
                }
                else{
                    if(tb>=5){
                        System.out.println("La hoc sinh trung binh");
                    }
                    else{
                        System.out.println("La hoc sinh yeu");
                    }
                }
            }
        }
    }
}
