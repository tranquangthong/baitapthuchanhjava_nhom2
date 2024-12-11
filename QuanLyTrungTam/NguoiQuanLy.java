package quanlytrungtam_hung;

import java.io.*;
import java.util.*;

public class NguoiQuanLy {
    private String tenQuanLy;

    // Constructor
    public NguoiQuanLy(String tenQuanLy) {
        this.tenQuanLy = tenQuanLy;
    }

    // Getter và Setter
    public String getTenQuanLy() {
        return tenQuanLy;
    }

    public void setTenQuanLy(String tenQuanLy) {
        this.tenQuanLy = tenQuanLy;
    }

    // === Quản lý Học viên ===
    public void hienThiDanhSachHocVien(List<HocVien> danhSachHocVien) {
        System.out.println("\n=== DANH SÁCH HỌC VIÊN ===");
        if (danhSachHocVien.isEmpty()) {
            System.out.println("Không có học viên nào trong hệ thống.");
        } else {
            for (HocVien hv : danhSachHocVien) {
                System.out.println("- Họ tên: " + hv.getHoTen() + ", Mã học viên: " + hv.getMaHocVien());
            }
        }
    }

    public void themHocVien(Scanner scanner, List<HocVien> danhSachHocVien) {
        System.out.println("\n=== THÊM HỌC VIÊN MỚI ===");
        System.out.print("Nhập họ tên học viên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập giới tính học viên: ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Nhập số điện thoại học viên: ");
        String soDienThoai = scanner.nextLine();
        System.out.print("Nhập email học viên: ");
        String email = scanner.nextLine();

        HocVien hocVien = new HocVien(hoTen, gioiTinh, soDienThoai, email, new Date());
        danhSachHocVien.add(hocVien);
        System.out.println("Học viên " + hoTen + " đã được thêm thành công.");
    }

    public void suaThongTinHocVien(Scanner scanner, List<HocVien> danhSachHocVien) {
        System.out.println("\n=== SỬA THÔNG TIN HỌC VIÊN ===");
        System.out.print("Nhập mã học viên cần sửa: ");
        String maHocVien = scanner.nextLine();

        for (HocVien hv : danhSachHocVien) {
            if (hv.getMaHocVien().equalsIgnoreCase(maHocVien)) {
                System.out.print("Nhập họ tên mới: ");
                hv.setHoTen(scanner.nextLine());
                System.out.print("Nhập số điện thoại mới: ");
                hv.setSoDienThoai(scanner.nextLine());
                System.out.println("Thông tin học viên đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy học viên với mã: " + maHocVien);
    }

    public void xoaHocVien(Scanner scanner, List<HocVien> danhSachHocVien) {
        System.out.println("\n=== XÓA HỌC VIÊN ===");
        System.out.print("Nhập mã học viên cần xóa: ");
        String maHocVien = scanner.nextLine();

        Iterator<HocVien> iterator = danhSachHocVien.iterator();
        while (iterator.hasNext()) {
            HocVien hv = iterator.next();
            if (hv.getMaHocVien().equalsIgnoreCase(maHocVien)) {
                iterator.remove();
                System.out.println("Học viên " + maHocVien + " đã được xóa khỏi hệ thống.");
                return;
            }
        }
        System.out.println("Không tìm thấy học viên với mã: " + maHocVien);
    }

    // === Quản lý Giáo viên ===
    public void hienThiDanhSachGiaoVien(List<GiaoVien> danhSachGiaoVien) {
        System.out.println("\n=== DANH SÁCH GIÁO VIÊN ===");
        if (danhSachGiaoVien.isEmpty()) {
            System.out.println("Không có giáo viên nào trong hệ thống.");
        } else {
            for (GiaoVien gv : danhSachGiaoVien) {
                System.out.println("- Họ tên: " + gv.getHoTen() + ", Chuyên môn: " + gv.getChuyenMon());
            }
        }
    }

    public void themGiaoVien(Scanner scanner, List<GiaoVien> danhSachGiaoVien) {
        System.out.println("\n=== THÊM GIÁO VIÊN MỚI ===");
        System.out.print("Nhập họ tên giáo viên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập giới tính giáo viên: ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Nhập số điện thoại giáo viên: ");
        String soDienThoai = scanner.nextLine();
        System.out.print("Nhập email giáo viên: ");
        String email = scanner.nextLine();
        System.out.print("Nhập chuyên môn giáo viên: ");
        String chuyenMon = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String matKhau = scanner.nextLine();

        GiaoVien giaoVien = new GiaoVien(hoTen, gioiTinh, soDienThoai, email, chuyenMon);
        giaoVien.setMatKhau(matKhau);
        danhSachGiaoVien.add(giaoVien);
        System.out.println("Giáo viên " + hoTen + " đã được thêm thành công.");
        giaoVien.hienThiThongTin();
    }

    public void suaThongTinGiaoVien(Scanner scanner, List<GiaoVien> danhSachGiaoVien) {
        System.out.println("\n=== SỬA THÔNG TIN GIÁO VIÊN ===");
        System.out.print("Nhập họ tên giáo viên cần sửa: ");
        String tenGiaoVien = scanner.nextLine();

        for (GiaoVien gv : danhSachGiaoVien) {
            if (gv.getHoTen().equalsIgnoreCase(tenGiaoVien)) {
                System.out.print("Nhập chuyên môn mới: ");
                gv.setChuyenMon(scanner.nextLine());
                System.out.println("Thông tin giáo viên đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy giáo viên với tên: " + tenGiaoVien);
    }

    public void xoaGiaoVien(Scanner scanner, List<GiaoVien> danhSachGiaoVien) {
        System.out.println("\n=== XÓA GIÁO VIÊN ===");
        System.out.print("Nhập họ tên giáo viên cần xóa: ");
        String tenGiaoVien = scanner.nextLine();

        Iterator<GiaoVien> iterator = danhSachGiaoVien.iterator();
        while (iterator.hasNext()) {
            GiaoVien gv = iterator.next();
            if (gv.getHoTen().equalsIgnoreCase(tenGiaoVien)) {
                iterator.remove();
                System.out.println("Giáo viên " + tenGiaoVien + " đã được xóa khỏi hệ thống.");
                return;
            }
        }
        System.out.println("Không tìm thấy giáo viên với tên: " + tenGiaoVien);
    }

    // === Quản lý Khóa học ===
    public void hienThiDanhSachKhoaHoc(List<KhoaHoc> danhSachKhoaHoc) {
        System.out.println("\n=== DANH SÁCH KHÓA HỌC ===");
        if (danhSachKhoaHoc.isEmpty()) {
            System.out.println("Không có khóa học nào trong hệ thống.");
        } else {
            for (KhoaHoc kh : danhSachKhoaHoc) {
                System.out.println("- Mã khóa học: " + kh.getMaKhoaHoc()
                        + ", Tên khóa học: " + kh.getTenKhoaHoc()
                        + ", Thời lượng: " + kh.getThoiLuong() + " giờ"
                        + ", Giáo viên phụ trách: " + kh.getGiaoVien().getHoTen());
            }
        }
    }

    public void taoKhoaHoc(Scanner scanner, List<KhoaHoc> danhSachKhoaHoc, List<GiaoVien> danhSachGiaoVien) {
        System.out.println("\n=== TẠO KHÓA HỌC ===");
        System.out.print("Nhập mã khóa học: ");
        String maKhoaHoc = scanner.nextLine();
        System.out.print("Nhập tên khóa học: ");
        String tenKhoaHoc = scanner.nextLine();
        System.out.print("Nhập thời lượng (giờ): ");
        int thoiLuong = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Chọn giáo viên phụ trách:");
        for (int i = 0; i < danhSachGiaoVien.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachGiaoVien.get(i).getHoTen());
        }
        System.out.print("Nhập số thứ tự của giáo viên: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < danhSachGiaoVien.size()) {
            GiaoVien giaoVien = danhSachGiaoVien.get(index);
            KhoaHoc khoaHoc = new KhoaHoc(maKhoaHoc, tenKhoaHoc, thoiLuong, giaoVien);
            danhSachKhoaHoc.add(khoaHoc);
            System.out.println("Khóa học đã được tạo thành công.");
        } else {
            System.out.println("Giáo viên không hợp lệ.");
        }
    }

    public void xoaKhoaHoc(Scanner scanner, List<KhoaHoc> danhSachKhoaHoc) {
        System.out.println("\n=== XÓA KHÓA HỌC ===");
        System.out.print("Nhập mã khóa học cần xóa: ");
        String maKhoaHoc = scanner.nextLine();

        Iterator<KhoaHoc> iterator = danhSachKhoaHoc.iterator();
        while (iterator.hasNext()) {
            KhoaHoc kh = iterator.next();
            if (kh.getMaKhoaHoc().equalsIgnoreCase(maKhoaHoc)) {
                iterator.remove();
                System.out.println("Khóa học " + maKhoaHoc + " đã được xóa khỏi hệ thống.");
                return;
            }
        }
        System.out.println("Không tìm thấy khóa học với mã: " + maKhoaHoc);
    }
    public void capNhatKhoaHoc(Scanner scanner, List<KhoaHoc> danhSachKhoaHoc) {
        System.out.println("\n=== CẬP NHẬT KHÓA HỌC ===");
        System.out.print("Nhập mã khóa học cần cập nhật: ");
        String maKhoaHoc = scanner.nextLine();

        for (KhoaHoc kh : danhSachKhoaHoc) {
            if (kh.getMaKhoaHoc().equalsIgnoreCase(maKhoaHoc)) {
                System.out.print("Nhập tên khóa học mới: ");
                kh.setTenKhoaHoc(scanner.nextLine());
                System.out.print("Nhập thời lượng mới (giờ): ");
                kh.setThoiLuong(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Khóa học đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy khóa học với mã: " + maKhoaHoc);
    }
    // === Quản lý Phòng học ===
    public void hienThiDanhSachPhongHoc(List<PhongHoc> danhSachPhongHoc) {
        System.out.println("\n=== DANH SÁCH PHÒNG HỌC ===");
        if (danhSachPhongHoc.isEmpty()) {
            System.out.println("Không có phòng học nào trong hệ thống.");
        } else {
            for (PhongHoc ph : danhSachPhongHoc) {
                System.out.println("- Mã phòng: " + ph.getMaPhong()
                        + ", Sức chứa: " + ph.getSucChua()
                        + ", Trạng thái: " + (ph.isTinhTrang() ? "Sẵn sàng" : "Đang sử dụng"));
            }
        }
    }
    public void themPhongHoc(Scanner scanner, List<PhongHoc> danhSachPhongHoc) {
        System.out.println("\n=== THÊM PHÒNG HỌC ===");
        System.out.print("Nhập mã phòng: ");
        String maPhong = scanner.nextLine();
        System.out.print("Nhập sức chứa: ");
        int sucChua = scanner.nextInt();
        scanner.nextLine();

        PhongHoc phongHoc = new PhongHoc(maPhong, sucChua);
        danhSachPhongHoc.add(phongHoc);
        System.out.println("Phòng học " + maPhong + " đã được thêm thành công.");
    }
    public void suaPhongHoc(Scanner scanner, List<PhongHoc> danhSachPhongHoc) {
        System.out.println("\n=== SỬA PHÒNG HỌC ===");
        System.out.print("Nhập mã phòng cần sửa: ");
        String maPhong = scanner.nextLine();

        for (PhongHoc ph : danhSachPhongHoc) {
            if (ph.getMaPhong().equalsIgnoreCase(maPhong)) {
                System.out.print("Nhập sức chứa mới: ");
                ph.setSucChua(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Phòng học đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy phòng học với mã: " + maPhong);
    }
    // === Lưu danh sách ra file ===
    public void xuatDanhSachHocVienRaFile(List<HocVien> danhSachHocVien) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("hocvien.txt"))) {
            for (HocVien hv : danhSachHocVien) {
                writer.write(hv.getHoTen() + ", " + hv.getMaHocVien());
                writer.newLine();
            }
            System.out.println("Danh sách học viên đã được xuất ra file hocvien.txt.");
        } catch (IOException e) {
            System.out.println("Lỗi khi xuất danh sách học viên ra file.");
        }
    }

    public void xuatDanhSachGiaoVienRaFile(List<GiaoVien> danhSachGiaoVien) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("giaovien.txt"))) {
            for (GiaoVien gv : danhSachGiaoVien) {
                writer.write(gv.getHoTen() + ", " + gv.getChuyenMon());
                writer.newLine();
            }
            System.out.println("Danh sách giáo viên đã được xuất ra file giaovien.txt.");
        } catch (IOException e) {
            System.out.println("Lỗi khi xuất danh sách giáo viên ra file.");
        }
    }
}
