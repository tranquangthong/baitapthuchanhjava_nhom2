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

public class HocVien extends Nguoi {
    private String maHocVien;
    private Date ngayNhapHoc;
    private List<String> danhSachKhoaHoc = new ArrayList<>();
    private Map<String, Double> diemSo = new HashMap<>();

    // Constructor
    public HocVien(String hoTen, String gioiTinh, String soDienThoai, String email, Date ngayNhapHoc) {
        super(hoTen, gioiTinh, soDienThoai, email);
        this.maHocVien = taoMaHocVien();
        this.ngayNhapHoc = ngayNhapHoc;
    }

    // Sinh ma hoc vien tu dong
    private String taoMaHocVien() {
        return "HV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    // Getter và Setter
    public String getMaHocVien() {
        return maHocVien;
    }

    public Date getNgayNhapHoc() {
        return ngayNhapHoc;
    }

    public void setNgayNhapHoc(Date ngayNhapHoc) {
        this.ngayNhapHoc = ngayNhapHoc;
    }

    public List<String> getDanhSachKhoaHoc() {
        return danhSachKhoaHoc;
    }

    public Map<String, Double> getDiemSo() {
        return diemSo;
    }

    // Các phương thức liên quan đến học viên
    public void capNhatThongTinCaNhan(String soDienThoaiMoi, String emailMoi) {
        setSoDienThoai(soDienThoaiMoi);
        setEmail(emailMoi);
        System.out.println("Thong tin ca nhan cua hoc vien " + getHoTen() + " da duoc cap nhat.");
    }
    // Phương thức đăng nhập cho học viên
public static HocVien dangNhapHocVien(Scanner scanner, List<HocVien> danhSachHocVien) {
    System.out.println("\n=== DANG NHAP HOC VIEN ===");
    System.out.print("Nhap ma hoc vien: ");
    String maHocVien = scanner.nextLine();

    for (HocVien hv : danhSachHocVien) {
        if (hv.getMaHocVien().equalsIgnoreCase(maHocVien)) {
            // Yêu cầu nhập mật khẩu
            for (int i = 0; i < 3; i++) { // Cho phép nhập sai mật khẩu tối đa 3 lần
                System.out.print("Nhap mat khau: ");
                String matKhau = scanner.nextLine();
                if (hv.getMatKhau().equals(matKhau)) {
                    System.out.println("Dang nhap thanh cong!");
                    return hv; // Trả về đối tượng học viên đã đăng nhập
                } else {
                    System.out.println("Sai mat khau. Vui long thu lai.");
                }
            }
            System.out.println("Ban da nhap sai mat khau qua 3 lan. Dang nhap that bai.");
            return null; // Trả về null nếu nhập sai quá 3 lần
        }
    }

    System.out.println("Ma hoc vien khong ton tai!");
    return null; // Trả về null nếu không tìm thấy học viên
}

    public void xemLichHoc() {
        System.out.println("Lich hoc cua hoc vien " + getHoTen() + ": " + danhSachKhoaHoc);
    }

    public void xemDiemThi() {
        System.out.println("Diem thi cua hoc vien " + getHoTen() + ": " + diemSo);
    }

    public void themKhoaHoc(String khoaHoc) {
        danhSachKhoaHoc.add(khoaHoc);
        System.out.println("Hoc vien " + getHoTen() + " da dang ky khoa hoc: " + khoaHoc);
    }

    public void guiPhanHoi(String phanHoi) {
        System.out.println("Hoc vien " + getHoTen() + " da gui phan hoi: " + phanHoi);
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Hoc vien: " + getHoTen() 
                + ", Ma: " + maHocVien 
                + ", Email: " + getEmail() 
                + ", Ngay nhap hoc: " + ngayNhapHoc);
    }
}



