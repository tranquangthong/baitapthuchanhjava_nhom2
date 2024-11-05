
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hi
 */
public class bai1_tuan4 {
    public static void main(String[] args) {
        int n;
        System.out.println("nhap n:");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int s=0;
        for (int i = 1;i<=n;i++)
            s=s+i;
        System.out.println("tong cac so tu 1 den n la :" + s);
    }
}
