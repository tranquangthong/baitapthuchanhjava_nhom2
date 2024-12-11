/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlytrungtam;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import quanlytrungtam.PhongHoc;

import java.util.*;

public class QuanLyTrungTam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Danh sách để lưu trữ thông tin
        List<HocVien> danhSachHocVien = new ArrayList<>();
        List<GiaoVien> danhSachGiaoVien = new ArrayList<>();
        List<KhoaHoc> danhSachKhoaHoc = new ArrayList<>();
        List<PhongHoc> danhSachPhongHoc = new ArrayList<>();

        // Tạo tài khoản cố định cho người quản lý
        NguoiQuanLy nguoiQuanLy = new NguoiQuanLy("Admin");

        // Chương trình chính
        while (true) {
            System.out.println("\n=== QUAN LY TRUNG TAM TIENG ANH ===");
            System.out.println("1. Dang nhap voi vai tro hoc vien");
            System.out.println("2. Dang nhap voi vai tro giao vien");
            System.out.println("3. Đang nhap voi vai tro Quan Ly");
            System.out.println("4. Đang ky tai khoan Hoc Vien");
            System.out.println("5. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (luaChon) {
                case 1:
                    dangNhapHocVien(scanner, danhSachHocVien);
                    break;
                case 2:
                    dangNhapGiaoVien(scanner, danhSachGiaoVien);
                    break;
                case 3:
                    dangNhapQuanLy(scanner, nguoiQuanLy, danhSachHocVien, danhSachGiaoVien, danhSachKhoaHoc, danhSachPhongHoc);
                    break;
                case 4:
                    dangKyHocVien(scanner, danhSachHocVien);
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        }
    }

    // Đăng nhập với chức năng quản lý
    private static void dangNhapQuanLy(Scanner scanner, NguoiQuanLy nguoiQuanLy,
                                       List<HocVien> danhSachHocVien,
                                       List<GiaoVien> danhSachGiaoVien,
                                       List<KhoaHoc> danhSachKhoaHoc,
                                       List<PhongHoc> danhSachPhongHoc) {
        System.out.println("\n=== ĐANG NHAP QUAN LY ===");
        System.out.print("Nhap ma trung tam: ");
        String maTrungTam = scanner.nextLine();
        System.out.print("Nhap mat khau: ");
        String matKhau = scanner.nextLine();

        // Kiểm tra thông tin đăng nhập (mã cố định do trung tâm cung cấp)
        if (maTrungTam.equals("ADMIN001") && matKhau.equals("password123")) {
            // Tạo mã xác nhận
            String maXacNhan = generateVerificationCode();
            System.out.println("Đang nhap thanh cong. Ma xac nhan cua ban: " + maXacNhan);
            menuNguoiQuanLy(scanner, nguoiQuanLy, danhSachHocVien, danhSachGiaoVien, danhSachKhoaHoc, danhSachPhongHoc);
        } else {
            System.out.println("Ma trung tam hoac mat khau khong dung.");
        }
    }

    // Hàm tạo mã xác nhận ngẫu nhiên
    private static String generateVerificationCode() {
        return "CONFIRM-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }

    //Menu người quản lý
    private static void menuNguoiQuanLy(Scanner scanner, NguoiQuanLy nguoiQuanLy,
                                        List<HocVien> danhSachHocVien,
                                        List<GiaoVien> danhSachGiaoVien,
                                        List<KhoaHoc> danhSachKhoaHoc,
                                        List<PhongHoc> danhSachPhongHoc) {
        while (true) {
            System.out.println("\n=== MENU QUAN LY ===");
            System.out.println("1. Quan ly Hoc vien");
            System.out.println("2. Quan ly Giao vien");
            System.out.println("3. Quan ly Khoa hoc");
            System.out.println("4. Quan ly Phong hoc");
            System.out.println("5. Quay lai");
            System.out.print("Nhap lua chon: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (luaChon) {
                case 1:
                    menuQuanLyHocVien(scanner, nguoiQuanLy, danhSachHocVien);
                    break;
                case 2:
                    menuQuanLyGiaoVien(scanner, nguoiQuanLy, danhSachGiaoVien);
                    break;
                case 3:
                    menuQuanLyKhoaHoc(scanner, nguoiQuanLy, danhSachKhoaHoc, danhSachGiaoVien);
                    break;
                case 4:
                    menuQuanLyPhongHoc(scanner, nguoiQuanLy, danhSachPhongHoc);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    private static void menuQuanLyHocVien(Scanner scanner, NguoiQuanLy nguoiQuanLy, List<HocVien> danhSachHocVien) {
        while (true) {
            System.out.println("\n=== QUAN LY HOC VIEN ===");
            System.out.println("1. Hien thi danh sach hoc vien");
            System.out.println("2. Them hoc vien");
            System.out.println("3. Sua thong tin hoc vien");
            System.out.println("4. Xoa hoc vien");
            System.out.println("5. Xuat danh sach hoc vien ra file");
            System.out.println("6. Quay lại");
            System.out.print("Nhap lua chon: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    nguoiQuanLy.hienThiDanhSachHocVien(danhSachHocVien);
                    break;
                case 2:
                    nguoiQuanLy.themHocVien(scanner, danhSachHocVien);
                    break;
                case 3:
                    nguoiQuanLy.suaThongTinHocVien(scanner, danhSachHocVien);
                    break;
                case 4:
                    nguoiQuanLy.xoaHocVien(scanner, danhSachHocVien);
                    break;
                case 5:
                    nguoiQuanLy.xuatDanhSachHocVienRaFile(danhSachHocVien);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    private static void menuQuanLyGiaoVien(Scanner scanner, NguoiQuanLy nguoiQuanLy, List<GiaoVien> danhSachGiaoVien) {
        while (true) {
            System.out.println("\n=== QUAN LY GIAO VIEN ===");
            System.out.println("1. Hien thi danh sach giao vien");
            System.out.println("2. Them giao vien");
            System.out.println("3. Sua thong tin giao vien");
            System.out.println("4. Xoa giao vien");
            System.out.println("5. Xuat danh sach giao vien ra file");
            System.out.println("6. Quay lai");
            System.out.print("Nhap lua chon: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (luaChon) {
                case 1:
                    nguoiQuanLy.hienThiDanhSachGiaoVien(danhSachGiaoVien);
                    break;
                case 2:
                    nguoiQuanLy.themGiaoVien(scanner, danhSachGiaoVien);
                    break;
                case 3:
                    nguoiQuanLy.suaThongTinGiaoVien(scanner, danhSachGiaoVien);
                    break;
                case 4:
                    nguoiQuanLy.xoaGiaoVien(scanner, danhSachGiaoVien);
                    break;
                case 5:
                    nguoiQuanLy.xuatDanhSachGiaoVienRaFile(danhSachGiaoVien);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    private static void menuQuanLyKhoaHoc(Scanner scanner, NguoiQuanLy nguoiQuanLy, List<KhoaHoc> danhSachKhoaHoc, List<GiaoVien> danhSachGiaoVien) {
        while (true) {
            System.out.println("\n=== QUAN LY KHOA HOC ===");
            System.out.println("1. Hien thi danh sach khoa hoc");
            System.out.println("2. Tao khoa hoc moi");
            System.out.println("3. Cap nhat khoa hoc");
            System.out.println("4. Quay lai");
            System.out.print("Nhap lua chon: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (luaChon) {
                case 1:
                    nguoiQuanLy.hienThiDanhSachKhoaHoc(danhSachKhoaHoc);
                    break;
                case 2:
                    nguoiQuanLy.taoKhoaHoc(scanner, danhSachKhoaHoc, danhSachGiaoVien);
                    break;
                case 3:
                    nguoiQuanLy.capNhatKhoaHoc(scanner, danhSachKhoaHoc);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    private static void menuQuanLyPhongHoc(Scanner scanner, NguoiQuanLy nguoiQuanLy, List<PhongHoc> danhSachPhongHoc) {
        while (true) {
            System.out.println("\n=== QUAN LY PHONG HOC ===");
            System.out.println("1. Hien thi danh sach phong hoc");
            System.out.println("2. Them phong hoc moi");
            System.out.println("3. Sua thong tin phong hoc");
            System.out.println("4. Quay lai");
            System.out.print("Nhap lua chon: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (luaChon) {
                case 1:
                    nguoiQuanLy.hienThiDanhSachPhongHoc(danhSachPhongHoc);
                    break;
                case 2:
                    nguoiQuanLy.themPhongHoc(scanner, danhSachPhongHoc);
                    break;
                case 3:
                    nguoiQuanLy.suaPhongHoc(scanner, danhSachPhongHoc);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    //Đăng kí học viên
    private static void dangKyHocVien(Scanner scanner, List<HocVien> danhSachHocVien) {
        System.out.println("\n=== ĐANG KY TAI KHOAN HOC VIEN ===");
        System.out.print("Nhap ho ten: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap gioi tinh: ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Nhap so đien thoai: ");
        String soDienThoai = scanner.nextLine();
        System.out.print("Nhap email: ");
        String email = scanner.nextLine();
        System.out.print("Nhap mat khau: ");
        String matKhau = scanner.nextLine();

        HocVien hocVien = new HocVien(hoTen, gioiTinh, soDienThoai, email, new Date());
        hocVien.setMatKhau(matKhau);
        danhSachHocVien.add(hocVien);
        xuatDanhSachHocVienRaFile(danhSachHocVien);
        System.out.println("Tai khoan hoc vien đuoc tao thanh cong! Ma hoc vien cua ban la: " + hocVien.getMaHocVien());
    }
    public static void xuatDanhSachHocVienRaFile(List<HocVien> danhSachHocVien) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("hocvien.txt"))) {
            for (HocVien hv : danhSachHocVien) {
                writer.write(hv.getHoTen() + ", " + hv.getMaHocVien());
                writer.newLine();
            }
            System.out.println("Danh sach hoc vien đa đuoc xuat ra file hocvien.txt.");
        } catch (IOException e) {
            System.out.println("Loi khi xuat danh sach hoc vien ra file.");
        }
    }
    //Dang nhap voi vai tro hoc viên
    private static void dangNhapHocVien(Scanner scanner, List<HocVien> danhSachHocVien) {
        System.out.println("\n=== ĐANG NHAP HOC VIEN ===");
        System.out.print("Nhap ma hoc vien: ");
        String maHocVien = scanner.nextLine();
        System.out.print("Nhap mat khau: ");
        String matKhau = scanner.nextLine();

        for (HocVien hv : danhSachHocVien) {
            if (hv.dangNhap(maHocVien, matKhau)) {
                System.out.println("Đang nhap thanh cong!");
                menuHocVien(hv, scanner);
                return;
            }
        }

        System.out.println("Ma hoc vien hoac mat khau khong đung.");
    }


    // Dang nhap voi vai tro Giao Vien
    private static void dangNhapGiaoVien(Scanner scanner, List<GiaoVien> danhSachGiaoVien) {
        System.out.println("\n=== ĐANG NHaP GIaO VIeN ===");
        System.out.print("Nhap ma giao vien: ");
        String maGiaoVien = scanner.nextLine();
        System.out.print("Nhap mat khau: ");
        String matKhau = scanner.nextLine();

        for (GiaoVien gv : danhSachGiaoVien) {
            if (gv.dangNhap(maGiaoVien, matKhau)) {
                System.out.println("Đang nhap thanh cong!");
                menuGiaoVien(gv, scanner);
                return;
            }
        }

        System.out.println("Ma giao vien hoac mat khau khong dung.");
    }


    // Menu danh cho Hoc Vien
    private static void menuHocVien(HocVien hocVien, Scanner scanner) {
        while (true) {
            System.out.println("\n=== MENU HOC VIEN ===");
            System.out.println("1. Xem thong tin ca nhan");
            System.out.println("2. Xem lich hoc");
            System.out.println("3. Xem diem thi");
            System.out.println("4. Dang ky khoa hoc");
            System.out.println("5. Thanh toan hoc phi");
            System.out.println("6. Dang xuat");
            System.out.print("Nhap lua chon cua ban: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Doc bo dong trong

            switch (luaChon) {
                case 1:
                    hocVien.hienThiThongTin();
                    break;
                case 2:
                    hocVien.xemLich();
                    break;
                case 3:
                    hocVien.hienThiDiemTheoMaHocVien();
                    break;
                case 4:
                    System.out.print("Nhap ten khoa hoc muon dang ky: ");
                    String khoaHoc = scanner.nextLine();
                    hocVien.thamGiaKhoaHoc(khoaHoc);
                    break;
                case 5:
                    System.out.print("Nhap ten khoa hoc can thanh toan: ");
                    String khoaHocThanhToan = scanner.nextLine();
                    hocVien.thanhToanHocPhi(khoaHocThanhToan);
                    break;
                case 6:
                    System.out.println("Dang xuat khoi tai khoan hoc vien.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    //
// Menu dành cho Giáo Viên
    private static void menuGiaoVien(GiaoVien giaoVien, Scanner scanner) {
        QuanLyDiem quanLyDiem = new QuanLyDiem();

        // Giả sử bạn đã có một Map diemHocVienTheoKhoaHoc
        Map<String, Map<String, Double>> diemHocVienTheoKhoaHoc = new HashMap<>();


        while (true) {
            System.out.println("\n=== MENU GIAO VIEN ===");
            System.out.println("1. Xem thong tin ca nhan");
            System.out.println("2. Xem danh sach khoa hoc");
            System.out.println("3. Them lich day");
            System.out.println("4. Nhap điem cho học vien");
            System.out.println("5. Tai tai lieu len");
            System.out.println("6. Xem danh sach tai lieu");
            System.out.println("7. Tham gia khoa hoc");  // Thêm lựa chọn tham gia khóa học
            System.out.println("8. Hien thi điem");
            System.out.println("9. Dang xuat");
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
                    giaoVien.capNhatLich(lichDay);
                    break;
            case 4:
                // Nhập điểm cho học viên
                System.out.print("Nhap ma khoa hoc: ");
                String maKhoaHoc = scanner.nextLine();
                System.out.print("Nhap ma hoc vien: ");
                String maHocVien = scanner.nextLine();
                System.out.print("Nhap điem: ");
                try {
                    double diem = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ dòng trống
                    giaoVien.nhapDiemTheoMa(maKhoaHoc, maHocVien, diem);
                } catch (InputMismatchException e) {
                    System.out.println("Loi: Điem phai là so thuc!");
                    scanner.nextLine(); // Bỏ dòng lỗi
                }
                break;

                case 5:
                    System.out.print("Nhap duong dan tep tai lieu: ");
                    String duongDanFile = scanner.nextLine();
                    giaoVien.themTaiLieuTuFile(duongDanFile);
                    break;
                case 6:
                    giaoVien.xemDanhSachTaiLieu();
                    break;
                case 7:
                    System.out.print("Nhap ten khoa hoc ban muon tham gia: ");
                    String KhoaHoc = scanner.nextLine();
                    giaoVien.thamGiaKhoaHoc(KhoaHoc);  // Gọi phương thức tham gia khóa học
                    break;
                case 8: 
                    System.out.print("Nhap ma khoa hoc de hien thi điem: ");
                    String maKhoaHocHienThi = scanner.nextLine();
                    giaoVien.hienThiDiemTheoMaKhoaHoc(maKhoaHocHienThi);
                    break;
                case 9:
                    System.out.println("Dang xuat khoi tai khoan giao vien.");
                    return;

                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }
}





