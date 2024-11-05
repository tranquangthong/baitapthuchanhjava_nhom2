
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hi
 */
public class bai4_tuan4 {
    public static void main(String[] args) {
        int n;
        System.out.println("nhap n:");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if(KTSNT(n)==true)
            System.out.println("day la so nguyen to");
        else
            System.out.println("day k phai la so nguyen to");
        
    }
    public static boolean KTSNT(int n)
    {
        if(n<2)
            System.out.println(n + " khong phai la so nguyen to");
        else
            for(int i = 2;i<=n/2;i++)
                if(n%i==0)
                    return false;
        return true;
        
    }
}
