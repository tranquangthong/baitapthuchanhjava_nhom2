
package tuan6_tlthdt;

import java.util.Scanner;


public class main {
    public static void main(String[] args) {
//         Tạo một tài khoản mới
        Scanner sc = new Scanner(System.in);
//         Tạo tài khoản tiết kiệm
        TaiKhoanTietKiem tkTietKiem = new TaiKhoanTietKiem("7891011", "Nguyen Van B", 2000000, "B123456789", 0.05);
        System.out.println("\nThong tin tai khoan tiet kiem:");
        System.out.println("Chu tai khoan: " + tkTietKiem.getChuTaiKhoan());
        System.out.println("So tai khoan: " + tkTietKiem.getSoTaiKhoan());
        
        // Gửi tiền vào tài khoản tiết kiệm
        tkTietKiem.guiTien();
        // Tính lãi cho tài khoản tiết kiệm
        System.out.print("Nhap so thang de tinh lai : ");
        int soThang = sc.nextInt();
        tkTietKiem.tinhLai(soThang);

        // Tạo tài khoản thanh toán
        TaiKhoanThanhToan tkThanhToan = new TaiKhoanThanhToan("12131415", "Tran Thi C", 500000, "C987654321", 100000);
        System.out.println("\nThong tin tai khoan thanh toan:");
        System.out.println("Chu tai khoan: " + tkThanhToan.getChuTaiKhoan());
        System.out.println("So tai khoan: " + tkThanhToan.getSoTaiKhoan());

        // Gửi tiền vào tài khoản thanh toán
        tkThanhToan.guiTien();

        // Rút tiền có tính hạn mức thấu chi
        tkThanhToan.rutTien();

        // Kiểm tra số dư tài khoản thanh toán
        tkThanhToan.kiemTraSoDu();
        
        // Đổi mật khẩu tài khoản thanh toán
        tkThanhToan.doiMatKhau();
        
        sc.close();
    }
}
    

