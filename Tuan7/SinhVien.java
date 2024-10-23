/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thuchanhtuan7;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class TaiKhoan {
    public Scanner sc=new Scanner(System.in);
    private String soTK;
    private String chuTK;
    private double soDu;
    private String matKhau;
    public TaiKhoan(String soTK,String chuTK,double soDu,String matKhau){
        this.soTK=soTK;
        this.chuTK=chuTK;
        this.soDu=soDu;
        this.matKhau=matKhau;
    }
    public void guiTien(){
        double soTienGui;
        System.out.println("Nhap so tien gui:");
        soTienGui=sc.nextDouble();
        if(soTienGui>0){
            this.soDu+=soTienGui;
        } else {
            System.out.println("So tien gui phai lon hon 0!");
        }
    }
    public void rutTien(){
        double soTienRut;
        System.out.println("Nhap so tien rut:");
        soTienRut=sc.nextDouble();
        sc.nextLine();
        if(soTienRut>0 && soTienRut<=this.soDu){
            this.soDu-=soTienRut;
        } else if(soTienRut>this.soDu) {
            System.out.println("So tien trong tai khoan khong du!");
        } else {
            System.out.println("So tien rut phai lon hon 0!");
        }
    }
    public void ktraSoDu(){
        System.out.println("So du la:"+this.soDu);
    }
    int danhdau=0;
    public void doiMK() {
        do{
            System.out.println("Nhap mat khau hien tai:");
            String matKhauCu=sc.nextLine();
            if(this.matKhau.equals(matKhauCu)){
                System.out.println("Nhap mat khau moi:");
                String matKhauMoi=sc.nextLine();
                this.matKhau=matKhauMoi;
                if(this.matKhau.equals(matKhauCu)){//check trường hợp người dùng nhập mật khẩu mới trùng với mật khẩu cũ
                    int danhdau2=0;
                    do{
                        System.out.println("Mat khau moi trung voi mat khau cu! Nhap mat khau khac:");
                        matKhauMoi=sc.nextLine();
                        this.matKhau=matKhauMoi;
                        if(!this.matKhau.equals(matKhauCu)){
                            danhdau2=1;
                            System.out.println("Thay doi mat khau thanh cong!");
                            danhdau=1;
                        }
                    } while(danhdau2!=1);
                }
                else{
                    danhdau=1;
                    System.out.println("Thay doi mat khau thanh cong!");                   
                }

        } else  {
            System.out.println("Mat khau hien tai khong dung! Khong the thay doi mat khau!");
        }
    }  while(danhdau!=1);
        }
}
