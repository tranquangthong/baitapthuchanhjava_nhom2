/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.thuchanhtuan7;

/**
 *
 * @author LENOVO
 */
public class ThucHanhTuan7 {

    public static void main(String[] args) {
        HinhTron ht = new HinhTron();
        ht.nhapBanKinh(5);
        System.out.println("Chu vi hình tròn: " + ht.tinhChuVi());
        System.out.println("Diện tích hình tròn: " + ht.tinhDienTich());
        
        SinhVien sv = new SinhVien("SV001", "Nguyen Van A", "01/01/2000", 8.5);
        System.out.println("Xếp loại sinh viên: " + sv.xepLoai());
        
        TaiKhoan tk=new TaiKhoan("12378123","Tran quang thong",1000,"tranquangthong");
        tk.guiTien();
        tk.rutTien();
        tk.ktraSoDu();
        tk.doiMK();
        
    }
}
