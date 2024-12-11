package quanlytrungtam_hung;

import java.io.*;
import java.util.*;
import quanlytrungtam_hung.TaiLieu;

public class GiaoVien extends User implements Authentication, IQuanLyLich, IQuanLyKhoaHoc {
    private String maGiaoVien;
    private String chuyenMon;
    private List<String> danhSachKhoaHoc = new ArrayList<>();
    private List<String> lichDay = new ArrayList<>();
    private Map<String, Map<String, Double>> diemHocVienTheoKhoaHoc = new HashMap<>();
    private List<TaiLieu> danhSachTaiLieu = new ArrayList<>();
    public GiaoVien(String hoTen, String gioiTinh, String soDienThoai, String email, String chuyenMon) {
        super(hoTen, gioiTinh, soDienThoai, email);
        this.maGiaoVien = taoMaGiaoVien();
        this.chuyenMon = chuyenMon;
    }

    private String taoMaGiaoVien() {
        return "GV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    @Override
    public boolean dangNhap(String maGiaoVien, String matKhau) {
        return this.maGiaoVien.equals(maGiaoVien) && getMatKhau().equals(matKhau);
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
        System.out.println("Lịch dạy của giáo viên " + getHoTen() + ": " + lichDay);
    }

    @Override
    public void capNhatLich(String lichMoi) {
        lichDay.add(lichMoi);
        System.out.println("Lịch dạy được cập nhật: " + lichMoi);
    }

    @Override
    public void xemDanhSachKhoaHoc() {
        System.out.println("Danh sách khóa học của giáo viên " + getHoTen() + ":");
        for (String khoaHoc : danhSachKhoaHoc) {
            System.out.println("- " + khoaHoc);
        }
    }

    @Override
    public void thamGiaKhoaHoc(String tenKhoaHoc) {
        danhSachKhoaHoc.add(tenKhoaHoc);
        System.out.println("Giáo viên " + getHoTen() + " được phân công giảng dạy khóa học: " + tenKhoaHoc);
    }


public void hienThiDiemTheoMaKhoaHoc(String maKhoaHoc) {
    String tenFile = "diemHocVien.txt";
    try (BufferedReader reader = new BufferedReader(new FileReader(tenFile))) {
        String line;
        boolean found = false;
        System.out.println("=== Điểm học viên cho mã khóa học: " + maKhoaHoc + " ===");
        
        while ((line = reader.readLine()) != null) {
            // Kiểm tra nếu dòng chứa mã khóa học
            if (line.contains("Mã khóa học: " + maKhoaHoc)) {
                System.out.println(line);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Không tìm thấy dữ liệu cho mã khóa học: " + maKhoaHoc);
        }
    } catch (IOException e) {
        System.err.println("Lỗi khi đọc file: " + e.getMessage());
    }
}

public void hienThiDiemTheoMaHocVien(String maHocVien) {
    String tenFile = "diemHocVien.txt";
    try (BufferedReader reader = new BufferedReader(new FileReader(tenFile))) {
        String line;
        boolean found = false;
        System.out.println("=== Điểm học viên cho mã học viên: " + maHocVien + " ===");
        while ((line = reader.readLine()) != null) {
            if (line.contains("Mã học viên: " + maHocVien)) {
                System.out.println(line);
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
private void ghiDiemVaoFile(String maKhoaHoc, String maHocVien, Double diem) {
    String tenFile = "diemHocVien.txt"; // Tên file lưu điểm học viên
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tenFile, true))) {
        // Ghi thông tin điểm học viên vào file
        writer.write("Mã khóa học: " + maKhoaHoc + ", Mã học viên: " + maHocVien + ", Điểm: " + diem + "\n");
        System.out.println("Đã ghi điểm vào file: " + tenFile);
    } catch (IOException e) {
        System.err.println("Lỗi khi ghi file: " + e.getMessage());
    }
}
//
public void nhapDiemTheoMa(String maKhoaHoc, String maHocVien, Double diem) {
    // Kiểm tra và tạo mới bản ghi điểm cho khóa học nếu chưa tồn tại
    diemHocVienTheoKhoaHoc.putIfAbsent(maKhoaHoc, new HashMap<>());

    // Thêm hoặc cập nhật điểm cho học viên theo mã học viên
    diemHocVienTheoKhoaHoc.get(maKhoaHoc).put(maHocVien, diem);

    // In ra thông báo
    System.out.println("Đã nhập điểm " + diem + " cho học viên có mã " + maHocVien + " trong khóa học có mã " + maKhoaHoc);

    // Ghi dữ liệu vào file sau khi nhập điểm
    ghiDiemVaoFile(maKhoaHoc, maHocVien, diem);
}

    // Quản lý tài liệu
    public void themTaiLieu(TaiLieu taiLieu) {
        danhSachTaiLieu.add(taiLieu);
        System.out.println("Đã thêm tài liệu: " + taiLieu.getTenTaiLieu());
    }
    public void themTaiLieuTuFile(String duongDanFile) {
        List<TaiLieu> taiLieuTuFile = TaiLieu.docDanhSachTaiLieu(duongDanFile);

        if (taiLieuTuFile.isEmpty()) {
            System.out.println("Không có tài liệu nào được đọc từ file.");
        } else {
            danhSachTaiLieu.addAll(taiLieuTuFile);
            System.out.println("Tài liệu từ file đã được thêm vào danh sách.");
        }
    }


    public void xemDanhSachTaiLieu() {
        System.out.println("Danh sách tài liệu của giáo viên " + getHoTen() + ":");
        if (danhSachTaiLieu.isEmpty()) {
            System.out.println("Chưa có tài liệu nào.");
        } else {
            for (TaiLieu taiLieu : danhSachTaiLieu) {
                System.out.println("- Tên: " + taiLieu.getTenTaiLieu());
                System.out.println("  Mô tả: " + taiLieu.getMoTa());
                System.out.println("  Nội dung: " + taiLieu.getNoiDung());
            }
        }
    }





    public void hienThiThongTin() {
        System.out.println("Giáo viên: " + getHoTen() 
            + ", Mã: " + maGiaoVien 
            + ", Email: " + getEmail() 
            + ", Chuyên môn: " + chuyenMon);
    }

}

