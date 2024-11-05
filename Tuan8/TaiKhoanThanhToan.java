/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taikhoan;

import java.util.Scanner;

public class TaiKhoanThanhToan extends TaiKhoanNganHang {
    private double hanMucThauChi;

    public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, String matKhau, String soDienThoai, double hanMucThauChi) {
        super(soTaiKhoan, chuTaiKhoan, matKhau, soDienThoai);
        this.hanMucThauChi = hanMucThauChi;
    }
    // Phương thức xác thực OTP sử dụng HeThongNganHang
    private boolean xacThucOTP(HeThongNganHang heThongNganHang) {
        Scanner sc = new Scanner(System.in);
        int otp = heThongNganHang.taoOTP();  // Tạo mã OTP từ hệ thống
        System.out.println("Ma OTP cua ban la: " + otp);
        System.out.print("Nhap ma OTP: ");
        
        int userOTP = sc.nextInt();
        sc.nextLine();  // Đọc bỏ dòng thừa

        if (userOTP == otp) {
            System.out.println("Xac thuc OTP thanh cong.");
            return true;
        } else {
            System.out.println("Xac thuc OTP that bai.");
            return false;
        }
    }
    @Override
    public boolean rutTien(double soTien) {
        if (getSoDu() + hanMucThauChi >= soTien) {
            setSoDu(getSoDu() - soTien); // Sử dụng setter để cập nhật số dư
            System.out.println("Rut tien thanh cong.");
            return true;
        } else {
            System.out.println("So tien rut vuot qua han muc thau chi.");
            return false;
        }
    }
    public void thanhToanHoaDon(IThanhToanHoaDon hoaDon, double soTien) {
        if (getSoDu()>=soTien) {  // Kiểm tra số dư trước khi thanh toán
            setSoDu(getSoDu()-soTien);
            hoaDon.thanhToan(soTien);
            System.out.println("Da thanh toan " + hoaDon.getLoaiHoaDon() + " voi so tien: " + soTien);
        } else {
            System.out.println("Khong du so du de thanh toan " + hoaDon.getLoaiHoaDon());
        }
    }
    @Override
    public void hienThiMenu() {
        System.out.println("----- MENU TAI KHOAN THANH TOAN -----");
        System.out.println("1. Rut tien");
        System.out.println("2. Gui tien");
        System.out.println("3. Kiem tra so du");
        System.out.println("4. Chuyen khoan");
        System.out.println("5. Thanh toan hoa don");
        System.out.println("6. Doi mat khau");
        System.out.println("7. Dang xuat");
    }

    public boolean chuyenKhoan(TaiKhoanNganHang taiKhoanNhan,double soTienChuyen,HeThongNganHang heThongNganHang){
        if(getSoDu()+hanMucThauChi>= soTienChuyen){
            if(!xacThucOTP(heThongNganHang)){
                System.out.println("Khong thuc hien duoc giao dich chuyen khoan do xac thuc OTP that bai!");
                return false;
            }
                        guiTien(-soTienChuyen);
            // Thực hiện cộng tiền vào tài khoản nhận
            taiKhoanNhan.guiTien(soTienChuyen);
            System.out.println("Chuyen khoan thanh cong so tien " + soTienChuyen + " den tai khoan " + taiKhoanNhan.getSoTaiKhoan());
            return true;
        } else {
            System.out.println("So du khong du de thuc hien chuyen khoan!");
            return false;
        }

            
    }
}
