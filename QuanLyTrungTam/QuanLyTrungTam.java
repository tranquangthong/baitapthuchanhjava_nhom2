/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlytrungtam;



/**
 *
 * @author LENOVO
 */




import java.util.*;

public class QuanLyTrungTam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==== QUAN LY TRUNG TAM TIENG ANH ====");
            System.out.println("1. Dang nhap voi vai tro Hoc Vien");
            System.out.println("2. Dang nhap voi vai tro Giao Vien");
            System.out.println("3. Dang ky tai khoan Hoc Vien");
            System.out.println("4. Dang ky tai khoan Giao Vien");
            System.out.println("5. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (luaChon) {
                case 1:
                    dangNhapHocVien(scanner);
                    break;
                case 2:
                    dangNhapGiaoVien(scanner); // Gọi phương thức từ class GiaoVien
                    break;
                case 3:
                    TaiKhoan.dangKyHocVien(scanner); // Gọi phương thức đăng ký từ lớp TaiKhoan
                    break;
                case 4:
                    TaiKhoan.dangKyGiaoVien(scanner); // Gọi phương thức đăng ký từ lớp TaiKhoan
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        }
    }

    // Đăng nhập với vai trò Học Viên
    private static void dangNhapHocVien(Scanner scanner) {
        HocVien hocVien = HocVien.dangNhapHocVien(scanner, TaiKhoan.getDanhSachHocVien());
        if (hocVien != null) {
            menuHocVien(hocVien, scanner); // Chuyển đến menu học viên nếu đăng nhập thành công
        }
    }

    // Đăng nhập với vai trò Giáo Viên
    private static void dangNhapGiaoVien(Scanner scanner) {
        GiaoVien giaoVien = GiaoVien.dangNhapGiaoVien(scanner, TaiKhoan.getDanhSachGiaoVien());
        if (giaoVien != null) {
            menuGiaoVien(giaoVien, scanner); // Chuyển đến menu giáo viên nếu đăng nhập thành công
        }
    }

    // Menu dành cho Học Viên
    private static void menuHocVien(HocVien hocVien, Scanner scanner) {
        while (true) {
            System.out.println("\n=== MENU HOC VIEN ===");
            System.out.println("1. Xem thong tin ca nhan");
            System.out.println("2. Xem lich hoc");
            System.out.println("3. Xem diem thi");
            System.out.println("4. Dang ky khoa hoc");
            System.out.println("5. Gui phan hoi");
            System.out.println("6. Dang xuat");
            System.out.print("Nhap lua chon cua ban: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (luaChon) {
                case 1:
                    hocVien.hienThiThongTin();
                    break;
                case 2:
                    hocVien.xemLichHoc();
                    break;
                case 3:
                    hocVien.xemDiemThi();
                    break;
                case 4:
                    System.out.print("Nhap ten khoa hoc muon dang ky: ");
                    String khoaHoc = scanner.nextLine();
                    hocVien.themKhoaHoc(khoaHoc);
                    break;
                case 5:
                    System.out.print("Nhap phan hoi cua ban: ");
                    String phanHoi = scanner.nextLine();
                    hocVien.guiPhanHoi(phanHoi);
                    break;
                case 6:
                    System.out.println("Dang xuat hoc vien.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    // Menu dành cho Giáo Viên
    private static void menuGiaoVien(GiaoVien giaoVien, Scanner scanner) {
        while (true) {
            System.out.println("\n=== MENU GIAO VIEN ===");
            System.out.println("1. Xem thong tin ca nhan");
            System.out.println("2. Xem danh sach khoa hoc");
            System.out.println("3. Them lich day");
            System.out.println("4. Nhap diem cho hoc vien");
            System.out.println("5. Gui thong bao");
            System.out.println("6. Dang xuat");
            System.out.print("Nhap lua chon cua ban: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (luaChon) {
                case 1:
                    giaoVien.hienThiThongTin();
                    break;
                case 2:
                    giaoVien.xemDanhSachKhoaHoc();
                    break;
                case 3:
                    System.out.print("Nhap lich day: ");
                    String lichDay = scanner.nextLine();
                    giaoVien.themLichDay(lichDay);
                    break;
                case 4:
                    System.out.print("Nhap ten hoc vien: ");
                    String tenHocVien = scanner.nextLine();
                    System.out.print("Nhap diem: ");
                    Double diem = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ dòng trống
                    giaoVien.nhapDiem(tenHocVien, diem);
                    break;
                case 5:
                    System.out.print("Nhap thong bao: ");
                    String thongBao = scanner.nextLine();
                    giaoVien.guiThongBao(thongBao);
                    break;
                case 6:
                    System.out.println("Dang xuat giao vien.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }
}



