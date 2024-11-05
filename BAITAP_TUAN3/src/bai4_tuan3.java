
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hi
 */
public class bai4_tuan3 {
    public static void main(String[] args) {
        double a,b,c,min;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap 3 so lan luoc la :");
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        min = a;
        if(b < min)
            min = b;
        if(c < min)
            min = c;
        System.out.println("so nho nhat la " + min);
        
    }
    
}
