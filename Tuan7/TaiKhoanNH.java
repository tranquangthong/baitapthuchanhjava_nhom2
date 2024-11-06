package Tuan7;

import java.util.Scanner;

public abstract class TaiKhoanNH {
    protected String soTaiKhoan;
    protected String chuTaiKhoan;
    protected double soDu;
    protected String matKhau;

     // Trừu tượng
     public abstract double guiTien(String matKhau, double soDu) ;
     public abstract double rutTien(String matKhau, double soDu);
     public abstract void kiemTraSoDu(String matKhau);
 
    public TaiKhoanNH(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }

    public TaiKhoanNH ()
    {}

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }

    public double getSoDu() { return soDu; }

    public String getmatKhau() { return matKhau; }

    public void setmatKhau(String matKhau) {  this.matKhau = matKhau; }

    public void setSoDu(double soDu) {  this.soDu = soDu; }

    public void setSoTaiKhoan(String soTaiKhoan) {  this.soTaiKhoan = soTaiKhoan; }

    public void setChuTaiKhoan(String chuTaiKhoan) {  this.chuTaiKhoan = chuTaiKhoan; }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tai khoan: ");
        this.soTaiKhoan = sc.nextLine();
        System.out.print("Nhap ten tai khoan: ");
        this.chuTaiKhoan = sc.nextLine();
        System.out.print("Nhap so du ban dau: ");
        this.soDu = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhap mat khau: ");
        this.matKhau = sc.nextLine();
    }

    public void xuat() {
        System.out.println("\n--Thong tin tai khoan--");
        System.out.println("So tai khoan: " + this.soTaiKhoan);
        System.out.println("Chu tai khoan: " + this.chuTaiKhoan);
        System.out.println("So du: " + this.soDu + " VND");
    }

    public void chuyenTien() { }

// Đổi mật khẩu
    public void doiMatKhau() {
        Scanner sc = new Scanner(System.in);
        String matKhauCu;
        String matKhauMoi1;
        String matKhauMoi2;
        
        while (true) {
            System.out.print("Nhap mat khau cu de thay doi: ");
            matKhauCu = sc.nextLine();
            
            if (!this.matKhau.equals(matKhauCu)) {
                System.out.println("Doi mat khau that bai. Mat khau cu khong dung");
                return;
            }
            while(true) {
                System.out.print("Nhap mat khau moi: ");
                matKhauMoi1 = sc.nextLine();

                if (this.matKhau.equals(matKhauMoi1))
                    System.out.println("Mat khau moi giong mat khau cu. Vui long nhap lai.");

                else {
                    System.out.print("Nhap lai mat khau moi: ");
                    matKhauMoi2 = sc.nextLine();

                    if(!matKhauMoi2.equals(matKhauMoi1))
                        System.out.println("Mat khau moi khac nhau. Vui long nhap lai.");

                    else {
                        this.matKhau = matKhauMoi2;
                        System.out.println(" Da doi mat khau thanh cong");
                        return;
                    } 
                }
            }   
        }  
    }
// End đổi mật khẩu

}