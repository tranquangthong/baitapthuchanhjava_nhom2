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
public interface IGiaoDich {
    void thucHienGiaoDich(); // Thực hiện giao dịch
    String getChiTietGiaoDich(); // Lấy thông tin chi tiết giao dịch
    Date getThoiGianGiaoDich(); // Lấy thời gian giao dịch
}
