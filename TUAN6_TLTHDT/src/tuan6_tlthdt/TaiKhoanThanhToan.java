/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan6_tlthdt;

import java.util.Scanner;

/**
 *
 * @author Hi
 */
public class TaiKhoanThanhToan extends TaiKhoan {

  
    private double hanMucThauChi;
    Scanner sc = new Scanner(System.in);
    public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double hanMucThauChi) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.hanMucThauChi = hanMucThauChi;
    }

    // Ghi đè phương thức rút tiền để áp dụng hạn mức thấu chi
    @Override
    public void rutTien() {
        boolean giaoDichThanhCong = false;
        double soTien;
        do{
        System.out.println("nhap so tien can rut :");
        soTien = sc.nextDouble();
        if (soTien > 0 && this.soDu - soTien >= -hanMucThauChi) {
            setSoDu(this.soDu - soTien);
            System.out.println("rut tien thanh cong !! so du hien tai : " + this.soDu);
            giaoDichThanhCong = true ;
        } else 
            System.out.println("so tien rut khong hop le hoac vuot qua thau chi.\n moi nhap lai : ");
        }while(!giaoDichThanhCong);
    }

    public double getHanMucThauChi() {
        return hanMucThauChi;
    }

    public void setHanMucThauChi(double hanMucThauChi) {
        this.hanMucThauChi = hanMucThauChi;
    } 
}
