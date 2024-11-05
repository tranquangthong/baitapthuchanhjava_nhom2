/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taikhoan;

/**
 *
 * @author LENOVO
 */
public class HoaDonDien implements IThanhToanHoaDon {
    @Override
    public boolean thanhToan(double soTien) {
        System.out.println("Thanh toan hoa don dien voi so tien: " + soTien);
        // Thực hiện logic thanh toán cho hóa đơn điện
        return true;
    }

    @Override
    public String getLoaiHoaDon() {
        return "Hoa don dien";
    }
}
