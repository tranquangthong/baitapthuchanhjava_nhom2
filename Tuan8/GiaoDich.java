/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taikhoan;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class GiaoDich implements IGiaoDich {
    private String loaiGiaoDich;
    private double soTien;
    private Date thoiGianGiaoDich;

    public GiaoDich(String loaiGiaoDich, double soTien) {
        this.loaiGiaoDich = loaiGiaoDich;
        this.soTien = soTien;
        this.thoiGianGiaoDich = new Date(); // Ghi lại thời gian giao dịch
    }


    @Override
    public void thucHienGiaoDich() {
        // Logic thực hiện giao dịch, nếu cần
    }
    @Override
    public String getChiTietGiaoDich() {
        return "Loai: " + loaiGiaoDich + ", So tien: " + soTien + ", Thoi gian: " + thoiGianGiaoDich;
    }

    @Override
    public Date getThoiGianGiaoDich() {
        return thoiGianGiaoDich;
    }

}
