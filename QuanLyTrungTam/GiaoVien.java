/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlytrungtam;

/**
 *
 * @author LENOVO
 */


import java.util.*;

public class GiaoVien extends Nguoi {
    private String maGiaoVien; // Mã giáo viên
    private String chuyenMon; // Chuyên môn của giáo viên
    private List<String> danhSachKhoaHoc = new ArrayList<>(); // Danh sách các khóa học mà giáo viên dạy
    private List<String> lichDay = new ArrayList<>(); // Lịch dạy của giáo viên
    private Map<String, Double> danhSachDiemHocVien = new HashMap<>(); // Danh sách điểm số của học viên

    // Constructor
    public GiaoVien(String hoTen, String gioiTinh, String soDienThoai, String email, String chuyenMon) {
        super(hoTen, gioiTinh, soDienThoai, email);
        this.maGiaoVien = taoMaGiaoVien();
        this.chuyenMon = chuyenMon;
    }

    // Sinh mã giáo viên tự động
    private String taoMaGiaoVien() {
        return "GV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    // Getter và Setter
    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public List<String> getDanhSachKhoaHoc() {
        return danhSachKhoaHoc;
    }

    public List<String> getLichDay() {
        return lichDay;
    }

    public Map<String, Double> getDanhSachDiemHocVien() {
        return danhSachDiemHocVien;
    }

    // Phương thức đăng nhập
    public void dangNhap() {
        System.out.println("Giao vien " + getHoTen() + " da dang nhap.");
    }
    public static GiaoVien dangNhapGiaoVien(Scanner scanner, List<GiaoVien> danhSachGiaoVien) {
        System.out.println("\n=== DANG NHAP GIAO VIEN ===");
        System.out.print("Nhap ma giao vien: ");
        String maGiaoVien = scanner.nextLine();

        // Tìm kiếm giáo viên theo mã
        for (GiaoVien gv : danhSachGiaoVien) {
            if (gv.getMaGiaoVien().equalsIgnoreCase(maGiaoVien)) {
                // Yêu cầu nhập mật khẩu
                for (int i = 0; i < 3; i++) { // Cho phép nhập sai mật khẩu tối đa 3 lần
                    System.out.print("Nhap mat khau: ");
                    String matKhau = scanner.nextLine();
                    if (gv.getMatKhau().equals(matKhau)) {
                        System.out.println("Dang nhap thanh cong!");
                        return gv; // Trả về đối tượng giáo viên đã đăng nhập
                    } else {
                        System.out.println("Sai mat khau. Vui long thu lai.");
                    }
                }
                System.out.println("Ban da nhap sai mat khau qua 3 lan. Dang nhap that bai.");
                return null; // Trả về null nếu nhập sai mật khẩu quá 3 lần
            }
        }

        System.out.println("Ma giao vien khong ton tai!");
        return null; // Trả về null nếu không tìm thấy mã giáo viên
    }

    // Cập nhật thông tin cá nhân
    public void capNhatThongTinCaNhan(String soDienThoaiMoi, String emailMoi) {
        setSoDienThoai(soDienThoaiMoi);
        setEmail(emailMoi);
        System.out.println("Thong tin ca nhan cua giao vien " + getHoTen() + " da duoc cap nhat.");
    }

    // Phân công dạy khóa học
    public void themKhoaHoc(String khoaHoc) {
        danhSachKhoaHoc.add(khoaHoc);
        System.out.println("Giao vien " + getHoTen() + " da duoc phan cong day khoa hoc: " + khoaHoc);
    }

    // Thêm lịch dạy
    public void themLichDay(String lich) {
        lichDay.add(lich);
        System.out.println("Giao vien " + getHoTen() + " da them lich day: " + lich);
    }

    // Nhập điểm cho học viên
    public void nhapDiem(String tenHocVien, Double diem) {
        danhSachDiemHocVien.put(tenHocVien, diem);
        System.out.println("Giao vien " + getHoTen() + " da nhap diem " + diem + " cho hoc vien: " + tenHocVien);
    }

    // Xem danh sách điểm số học viên
    public void xemDanhSachDiem() {
        System.out.println("Danh sach diem so cua giao vien " + getHoTen() + ":");
        if (danhSachDiemHocVien.isEmpty()) {
            System.out.println("Chua co diem so nao duoc nhap.");
        } else {
            for (Map.Entry<String, Double> entry : danhSachDiemHocVien.entrySet()) {
                System.out.println("- Hoc vien: " + entry.getKey() + ", Diem: " + entry.getValue());
            }
        }
    }

    // Gửi thông báo
    public void guiThongBao(String thongBao) {
        System.out.println("Giao vien " + getHoTen() + " da gui thong bao: " + thongBao);
    }

    // Quản lý danh sách học viên trong khóa học
    public void quanLyHocVien(List<String> danhSachHocVien) {
        System.out.println("Giao vien " + getHoTen() + " quan ly danh sach hoc vien:");
        for (String hocVien : danhSachHocVien) {
            System.out.println("- " + hocVien);
        }
    }

    // Hiển thị thông tin giáo viên
    @Override
    public void hienThiThongTin() {
        System.out.println("Giao vien: " + getHoTen() 
                + ", Ma: " + maGiaoVien 
                + ", Email: " + getEmail() 
                + ", Chuyen mon: " + chuyenMon 
                + ", So khoa hoc dang day: " + danhSachKhoaHoc.size());
    }

    // Xem danh sách các khóa học được phân công
    public void xemDanhSachKhoaHoc() {
        System.out.println("Danh sach khoa hoc cua giao vien " + getHoTen() + ":");
        if (danhSachKhoaHoc.isEmpty()) {
            System.out.println("Hien tai chua co khoa hoc nao.");
        } else {
            for (String khoaHoc : danhSachKhoaHoc) {
                System.out.println("- " + khoaHoc);
            }
        }
    }

    // Xem lịch dạy
    public void xemLichDay() {
        System.out.println("Lich day cua giao vien " + getHoTen() + ":");
        if (lichDay.isEmpty()) {
            System.out.println("Hien tai chua co lich day nao.");
        } else {
            for (String lich : lichDay) {
                System.out.println("- " + lich);
            }
        }
    }

    // Cập nhật lịch dạy
    public void capNhatLichDay(int index, String lichMoi) {
        if (index >= 0 && index < lichDay.size()) {
            lichDay.set(index, lichMoi);
            System.out.println("Lich day da duoc cap nhat thanh cong.");
        } else {
            System.out.println("Chi so khong hop le.");
        }
    }
}




