/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanhtuan6;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class TaiKhoan {
    public Scanner sc=new Scanner(System.in);
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private int soDu;
    public TaiKhoan(String soTK,String chuTK,int soDu){
        this.soTaiKhoan=soTK;
        this.chuTaiKhoan=chuTK;
        this.soDu=soDu;
    }
    public void guiTien(){
        System.out.println("Nhap so tien can gui:");
        int tienGui=sc.nextInt();
        this.soDu+=tienGui;
    }
    public void rutTien(){
        System.out.println("Nhap so tien can rut:");
        int tienRut=sc.nextInt();
        this.soDu-=tienRut;
    }
    public int ktraSoDu(){
        return this.soDu;
    }
    public static void main(String[] args) {
        TaiKhoan tk=new TaiKhoan("1321231","tran quang thong",1000);
        tk.guiTien();
        tk.rutTien();
        System.out.println("So du con lai la:"+tk.soDu);
    }
}
