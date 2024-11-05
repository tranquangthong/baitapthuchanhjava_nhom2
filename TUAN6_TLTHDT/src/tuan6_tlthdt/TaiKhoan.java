/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tuan6_tlthdt;

import java.util.Scanner;

public abstract class TaiKhoan{
    private String soTaiKhoan;
    private String chuTaiKhoan;
    protected double soDu;
    private String matKhau;
   Scanner sc= new Scanner(System.in);
    // Constructor để khởi tạo tài khoản
    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }
    
    // Phương thức gửi tiền
    public void guiTien() {
        double soTien ;
        do{
        System.out.println("nhap so tien can gui  : ");
        soTien = sc.nextDouble();
        if(soTien<0)
                System.out.println("so tien can gui phai lon hon 0 . moi ban nhap lai .");
        }while(soTien<0);
        if (soTien > 0) {
            this.soDu += soTien;
            System.out.println("gui tien thanh cong !! so du hien tai: " + this.soDu);
        } 
    }

    // Phương thức rút tiền
    public abstract void rutTien() ;

    // Phương thức kiểm tra số dư
    public void kiemTraSoDu() {
        System.out.println("So du hien tai: " + this.soDu);
    }

    // Phương thức đổi mật khẩu 
    public void doiMatKhau() {
        sc.nextLine();
        System.out.print("Nhap mat khau cu : ");
        String matKhauCu = sc.nextLine();
        if (this.matKhau.equals(matKhauCu)) {
            System.out.println("Nhap mat khau moi :");
            String matKhauMoi = sc.nextLine();
            this.matKhau = matKhauMoi;
            System.out.println("doi mat khau thanh cong !");
        } else {
            System.out.println("mat khau cu khong dung.");
        }
    }
    
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }
    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }
    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    
}


