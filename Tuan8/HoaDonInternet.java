/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taikhoan;

/**
 *
 * @author LENOVO
 */
public class HoaDonInternet implements IThanhToanHoaDon {
     @Override
    public boolean thanhToan(double soTien) {
        System.out.println("Thanh toan hoa don internet voi so tien: " + soTien);
        // Thực hiện logic thanh toán cho hóa đơn internet
        return true;
    }
    @Override
    public String getLoaiHoaDon() {
        return "Hoa don internet";
    }
}
