
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hi
 */
public class bai5_tuan4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap a va b :");
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a == 0 || b == 0)
            System.out.println("UCLN la : " + (a+b));
        int r = 0;
        while (r==0)
        {
        if(a>b)
            {
                r = a%b;
                a=b;
                b=r;
            }   
        else
            {
                r=b%a;
                b=a;
                a=r;
            }
        }
    }
}
