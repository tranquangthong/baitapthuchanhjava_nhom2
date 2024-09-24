/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package thuchanhtuan3;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Bai1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n>0){
            System.out.println(n+" la so duong");
        }
        else if(n<0){
            System.out.println(n+" la so am");
        } else {
            System.out.println("n la so 0");
        }
    }
    
}
