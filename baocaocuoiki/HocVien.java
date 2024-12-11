/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlytrungtam_hung;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HocVien extends User implements Authentication, IQuanLyLich, IQuanLyKhoaHoc {
    private String maHocVien;
    private Date ngayNhapHoc;
    private List<String> danhSachKhoaHoc = new ArrayList<>();
    private Map<String, Double> diemSo = new HashMap<>();
    private Map<String, Boolean> trangThaiThanhToan = new HashMap<>();

    public HocVien(String hoTen, String gioiTinh, String soDienThoai, String email, Date ngayNhapHoc) {
        super(hoTen, gioiTinh, soDienThoai, email);
        this.maHocVien = taoMaHocVien();
        this.ngayNhapHoc = ngayNhapHoc;
    }

    private String taoMaHocVien() {
        return "HV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String getMaHocVien() {
        return maHocVien;
    }

    @Override
    public boolean dangNhap(String maHocVien, String matKhau) {
        return this.maHocVien.equals(maHocVien) && getMatKhau().equals(matKhau);
    }

    @Override
    public void doiMatKhau(String matKhauCu, String matKhauMoi) {
        if (getMatKhau().equals(matKhauCu)) {
            setMatKhau(matKhauMoi);
            System.out.println("Đổi mật khẩu thành công!");
        } else {
            System.out.println("Mật khẩu cũ không chính xác!");
        }
    }

    @Override
    public void xemLich() {
        System.out.println("Lịch học của học viên " + getHoTen() + ": " + danhSachKhoaHoc);
    }

    @Override
    public void capNhatLich(String lichMoi) {
        System.out.println("Lịch học được cập nhật: " + lichMoi);
    }

    @Override
    public void xemDanhSachKhoaHoc() {
        System.out.println("Danh sách khóa học của học viên " + getHoTen() + ":");
        for (String khoaHoc : danhSachKhoaHoc) {
            System.out.println("- " + khoaHoc);
        }
    }

    @Override
    public void thamGiaKhoaHoc(String tenKhoaHoc) {
        danhSachKhoaHoc.add(tenKhoaHoc);
        trangThaiThanhToan.put(tenKhoaHoc, false); // Gắn trạng thái chưa thanh toán
        System.out.println("Học viên " + getHoTen() + " đã tham gia khóa học: " + tenKhoaHoc);
    }

    public void thanhToanHocPhi(String tenKhoaHoc) {
        if (trangThaiThanhToan.containsKey(tenKhoaHoc)) {
            trangThaiThanhToan.put(tenKhoaHoc, true);
            System.out.println("Đã thanh toán học phí cho khóa học: " + tenKhoaHoc);
        } else {
            System.out.println("Khóa học không tồn tại!");
        }
    }
    

public void hienThiDiemTheoMaHocVien() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhập mã học viên: ");
    String maHocVien = scanner.nextLine(); // Nhập mã học viên từ người dùng

    String tenFile = "diemHocVien.txt";
    try (BufferedReader reader = new BufferedReader(new FileReader(tenFile))) {
        String line;
        boolean found = false;
        System.out.println("=== Điểm học viên cho mã học viên: " + maHocVien + " ===");
        while ((line = reader.readLine()) != null) {
            if (line.contains("Mã học viên: " + maHocVien)) {
                System.out.println(line); // Xuất thông tin dòng có mã học viên
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy dữ liệu cho mã học viên: " + maHocVien);
        }
    } catch (IOException e) {
        System.err.println("Lỗi khi đọc file: " + e.getMessage());
    }
}

    public void hienThiThongTin() {
        System.out.println("Học viên: " + getHoTen() 
            + ", Mã: " + maHocVien 
            + ", Email: " + getEmail() 
            + ", Ngày nhập học: " + ngayNhapHoc);
    }
    
}




