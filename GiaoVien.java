package quanlytrungtam;

import java.io.*;
import java.util.*;

public class GiaoVien extends user implements Authentication, IQuanLyLich, IQuanLyKhoaHoc {
    private String maGiaoVien;
    private String chuyenMon;
    private List<String> danhSachKhoaHoc = new ArrayList<>();
    private List<String> lichDay = new ArrayList<>();
    private Map<String, Map<String, Double>> diemHocVienTheoKhoaHoc = new HashMap<>();
    private List<TaiLieu> danhSachTaiLieu = new ArrayList<>();

    // Constructor
    public GiaoVien(String hoTen, String gioiTinh, String soDienThoai, String email, String chuyenMon) {
        super(hoTen, gioiTinh, soDienThoai, email);
        this.maGiaoVien = taoMaGiaoVien();
        this.chuyenMon = chuyenMon;
    }

    // Tạo mã giáo viên
    private String taoMaGiaoVien() {
        return "GV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    // Getter & Setter
    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public Map<String, Map<String, Double>> getDiemHocVienTheoKhoaHoc() {
        return diemHocVienTheoKhoaHoc;
    }

    // Xử lý đăng nhập và đổi mật khẩu
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

    // Quản lý lịch dạy
    @Override
    public void xemLich() {
        System.out.println("Lịch dạy của giáo viên " + getHoTen() + ": " + lichDay);
    }

    @Override
    public void capNhatLich(String lichMoi) {
        lichDay.add(lichMoi);
        System.out.println("Lịch dạy được cập nhật: " + lichMoi);
    }

    // Quản lý khóa học
    @Override
    public void xemDanhSachKhoaHoc() {
        System.out.println("Danh sách khóa học của giáo viên " + getHoTen() + ":");
        for (String khoaHoc : danhSachKhoaHoc) {
            System.out.println("- " + khoaHoc);
        }
    }

    @Override
    public void thamGiaKhoaHoc(String KhoaHoc) {
        if (!danhSachKhoaHoc.contains(KhoaHoc)) {
            danhSachKhoaHoc.add(KhoaHoc);
            System.out.println("Giáo viên " + getHoTen() + " đã tham gia khóa học: " + KhoaHoc);
        } else {
            System.out.println("Khóa học đã tồn tại.");
        }
    }

    public void nhapDiemTheoKhoaHoc(QuanLyDiem quanLyDiem, String tenKhoaHoc, String maHocVien, Double diem) {
        if (!danhSachKhoaHoc.contains(tenKhoaHoc)) {
            System.out.println("Khóa học không tồn tại. Hãy thêm khóa học trước khi nhập điểm.");
            return;
        }
        quanLyDiem.themDiem(tenKhoaHoc, maHocVien, diem);

            // Đảm bảo khóa học có trong Map, nếu chưa thì khởi tạo mới
            diemHocVienTheoKhoaHoc.putIfAbsent(tenKhoaHoc, new HashMap<>());

            // Thêm điểm học viên vào khóa học
            diemHocVienTheoKhoaHoc.get(tenKhoaHoc).put(maHocVien, diem);
            System.out.println("Đã nhập điểm " + diem + " cho học viên có mã " + maHocVien + " trong khóa học " + tenKhoaHoc);

            // Kiểm tra xem điểm đã được thêm đúng chưa
            System.out.println("Danh sách điểm sau khi nhập:");


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


    // Hiển thị thông tin
    public void hienThiThongTin() {
        System.out.println("Giáo viên: " + getHoTen() +
                ", Mã: " + maGiaoVien +
                ", Email: " + getEmail() +
                ", Chuyên môn: " + chuyenMon);
    }
}
