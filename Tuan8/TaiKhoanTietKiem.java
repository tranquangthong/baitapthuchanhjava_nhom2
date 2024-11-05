/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taikhoan;

public class TaiKhoanTietKiem extends TaiKhoanNganHang {
    private double laiSuat;
    private int soLanRutToiDa;
    private int soLanRutHienTai = 0;

    public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, String matKhau, String soDienThoai, double laiSuat, int soLanRutToiDa) {
        super(soTaiKhoan, chuTaiKhoan, matKhau, soDienThoai);
        this.laiSuat = laiSuat;
        this.soLanRutToiDa = soLanRutToiDa;
    }

    @Override
    public boolean rutTien(double soTien) {
        // Kiểm tra xem đã rút quá số lần cho phép chưa
        if (soLanRutHienTai >= soLanRutToiDa) {
            System.out.println("Bạn đã rút quá số lần cho phép.");
            return false;
        }
        // Kiểm tra xem số tiền rút có lớn hơn số dư hiện có không
        else if (soTien > getSoDu()) {
            System.out.println("Số tiền rút vượt quá số dư hiện có.");
            return false;
        }
        // Thực hiện rút tiền
        else {
            soLanRutHienTai++;    // Tăng số lần rút hiện tại
            setSoDu(getSoDu() - soTien); // Sử dụng setter để cập nhật số dư
            System.out.println("Rut tien thanh cong. So lan rut hien tai la: " + soLanRutHienTai);
            System.out.println("So du con lai la:"+getSoDu());
            return true;
        }
    }

    public void tinhLai() {
        double tienLai = getSoDu() * laiSuat / 100;
        guiTien(tienLai);
        System.out.println("Lai suat vua tinh: " + laiSuat + "%");
        System.out.println("So tien lai vua duoc cong: " + tienLai);
        System.out.println("So du moi sau khi cong lai: " + getSoDu());
    }

    @Override
    public void hienThiMenu() {
        System.out.println("----- MENU TAI KHOAN TIET KIEM -----");
        System.out.println("1. Rut tien");
        System.out.println("2. Gui tien");
        System.out.println("3. Kiem tra so du");
        System.out.println("4. Tinh lai suat");
        System.out.println("5. Doi mat khau");
        System.out.println("6. Dang xuat");
    }

}
