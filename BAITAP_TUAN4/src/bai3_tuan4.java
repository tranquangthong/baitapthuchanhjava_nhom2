
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hi
 */
public class bai3_tuan4 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap n:");
        n = sc.nextInt();
        int s=1;
        for(int i = 1;i<=n;i++)
            s=s*i;
        System.out.println("giai thua cua " + n + " la :"+s);
    }
}
