/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlytrungtam_hung;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import quanlytrungtam_hung.PhongHoc;

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
            System.out.println("\n=== QUẢN LÝ TRUNG TÂM TIẾNG ANH ===");
            System.out.println("1. Dang nhap voi vai tro hoc vien");
            System.out.println("2. Dang nhap voi vai tro giao vien");
            System.out.println("3. Đăng nhập với vai trò Quản Lý");
            System.out.println("4. Đăng ký tài khoản Học Viên");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
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
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    // Đăng nhập với chức năng quản lý
    private static void dangNhapQuanLy(Scanner scanner, NguoiQuanLy nguoiQuanLy,
                                       List<HocVien> danhSachHocVien,
                                       List<GiaoVien> danhSachGiaoVien,
                                       List<KhoaHoc> danhSachKhoaHoc,
                                       List<PhongHoc> danhSachPhongHoc) {
        System.out.println("\n=== ĐĂNG NHẬP QUẢN LÝ ===");
        System.out.print("Nhập mã trung tâm: ");
        String maTrungTam = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String matKhau = scanner.nextLine();

        // Kiểm tra thông tin đăng nhập (mã cố định do trung tâm cung cấp)
        if (maTrungTam.equals("ADMIN001") && matKhau.equals("password123")) {
            // Tạo mã xác nhận
            String maXacNhan = generateVerificationCode();
            System.out.println("Đăng nhập thành công. Mã xác nhận của bạn: " + maXacNhan);
            menuNguoiQuanLy(scanner, nguoiQuanLy, danhSachHocVien, danhSachGiaoVien, danhSachKhoaHoc, danhSachPhongHoc);
        } else {
            System.out.println("Mã trung tâm hoặc mật khẩu không đúng.");
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
            System.out.println("\n=== MENU QUẢN LÝ ===");
            System.out.println("1. Quản lý Học viên");
            System.out.println("2. Quản lý Giáo viên");
            System.out.println("3. Quản lý Khóa học");
            System.out.println("4. Quản lý Phòng học");
            System.out.println("5. Quay lại");
            System.out.print("Nhập lựa chọn: ");
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
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void menuQuanLyHocVien(Scanner scanner, NguoiQuanLy nguoiQuanLy, List<HocVien> danhSachHocVien) {
        while (true) {
            System.out.println("\n=== QUẢN LÝ HỌC VIÊN ===");
            System.out.println("1. Hiển thị danh sách học viên");
            System.out.println("2. Thêm học viên");
            System.out.println("3. Sửa thông tin học viên");
            System.out.println("4. Xóa học viên");
            System.out.println("5. Xuất danh sách học viên ra file");
            System.out.println("6. Quay lại");
            System.out.print("Nhập lựa chọn: ");
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
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void menuQuanLyGiaoVien(Scanner scanner, NguoiQuanLy nguoiQuanLy, List<GiaoVien> danhSachGiaoVien) {
        while (true) {
            System.out.println("\n=== QUẢN LÝ GIÁO VIÊN ===");
            System.out.println("1. Hiển thị danh sách giáo viên");
            System.out.println("2. Thêm giáo viên");
            System.out.println("3. Sửa thông tin giáo viên");
            System.out.println("4. Xóa giáo viên");
            System.out.println("5. Xuất danh sách giáo viên ra file");
            System.out.println("6. Quay lại");
            System.out.print("Nhập lựa chọn: ");
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
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void menuQuanLyKhoaHoc(Scanner scanner, NguoiQuanLy nguoiQuanLy, List<KhoaHoc> danhSachKhoaHoc, List<GiaoVien> danhSachGiaoVien) {
        while (true) {
            System.out.println("\n=== QUẢN LÝ KHÓA HỌC ===");
            System.out.println("1. Hiển thị danh sách khóa học");
            System.out.println("2. Tạo khóa học mới");
            System.out.println("3. Cập nhật khóa học");
            System.out.println("4. Quay lại");
            System.out.print("Nhập lựa chọn: ");
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
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void menuQuanLyPhongHoc(Scanner scanner, NguoiQuanLy nguoiQuanLy, List<PhongHoc> danhSachPhongHoc) {
        while (true) {
            System.out.println("\n=== QUẢN LÝ PHÒNG HỌC ===");
            System.out.println("1. Hiển thị danh sách phòng học");
            System.out.println("2. Thêm phòng học mới");
            System.out.println("3. Sửa thông tin phòng học");
            System.out.println("4. Quay lại");
            System.out.print("Nhập lựa chọn: ");
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
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    //Đăng kí học viên
    private static void dangKyHocVien(Scanner scanner, List<HocVien> danhSachHocVien) {
        System.out.println("\n=== ĐĂNG KÝ TÀI KHOẢN HỌC VIÊN ===");
        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String soDienThoai = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String matKhau = scanner.nextLine();

        HocVien hocVien = new HocVien(hoTen, gioiTinh, soDienThoai, email, new Date());
        hocVien.setMatKhau(matKhau);
        danhSachHocVien.add(hocVien);
        xuatDanhSachHocVienRaFile(danhSachHocVien);
        System.out.println("Tài khoản học viên được tạo thành công! Mã học viên của bạn là: " + hocVien.getMaHocVien());
    }
    public static void xuatDanhSachHocVienRaFile(List<HocVien> danhSachHocVien) {
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
    //Dang nhap voi vai tro hoc viên
    private static void dangNhapHocVien(Scanner scanner, List<HocVien> danhSachHocVien) {
        System.out.println("\n=== ĐĂNG NHẬP HỌC VIÊN ===");
        System.out.print("Nhập mã học viên: ");
        String maHocVien = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String matKhau = scanner.nextLine();

        for (HocVien hv : danhSachHocVien) {
            if (hv.dangNhap(maHocVien, matKhau)) {
                System.out.println("Đăng nhập thành công!");
                menuHocVien(hv, scanner);
                return;
            }
        }

        System.out.println("Mã học viên hoặc mật khẩu không đúng.");
    }


    // Dang nhap voi vai tro Giao Vien
    private static void dangNhapGiaoVien(Scanner scanner, List<GiaoVien> danhSachGiaoVien) {
        System.out.println("\n=== ĐĂNG NHẬP GIÁO VIÊN ===");
        System.out.print("Nhập mã giáo viên: ");
        String maGiaoVien = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String matKhau = scanner.nextLine();

        for (GiaoVien gv : danhSachGiaoVien) {
            if (gv.dangNhap(maGiaoVien, matKhau)) {
                System.out.println("Đăng nhập thành công!");
                menuGiaoVien(gv, scanner);
                return;
            }
        }

        System.out.println("Mã giáo viên hoặc mật khẩu không đúng.");
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
            System.out.println("1. Xem thông tin cá nhân");
            System.out.println("2. Xem danh sách khóa học");
            System.out.println("3. Thêm lịch dạy");
            System.out.println("4. Nhập điểm cho học viên");
            System.out.println("5. Tải tài liệu lên");
            System.out.println("6. Xem danh sách tài liệu");
            System.out.println("7. Tham gia khóa học");  // Thêm lựa chọn tham gia khóa học
            System.out.println("8. Hiển thị điểm");
            System.out.println("9. Đăng xuất");
            System.out.print("Nhập lựa chọn của bạn: ");
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
                    System.out.print("Nhập lịch dạy: ");
                    String lichDay = scanner.nextLine();
                    giaoVien.capNhatLich(lichDay);
                    break;
            case 4:
                // Nhập điểm cho học viên
                System.out.print("Nhập mã khóa học: ");
                String maKhoaHoc = scanner.nextLine();
                System.out.print("Nhập mã học viên: ");
                String maHocVien = scanner.nextLine();
                System.out.print("Nhập điểm: ");
                try {
                    double diem = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ dòng trống
                    giaoVien.nhapDiemTheoMa(maKhoaHoc, maHocVien, diem);
                } catch (InputMismatchException e) {
                    System.out.println("Lỗi: Điểm phải là số thực!");
                    scanner.nextLine(); // Bỏ dòng lỗi
                }
                break;

                case 5:
                    System.out.print("Nhập đường dẫn tệp tài liệu: ");
                    String duongDanFile = scanner.nextLine();
                    giaoVien.themTaiLieuTuFile(duongDanFile);
                    break;
                case 6:
                    giaoVien.xemDanhSachTaiLieu();
                    break;
                case 7:
                    System.out.print("Nhập tên khóa học bạn muốn tham gia: ");
                    String KhoaHoc = scanner.nextLine();
                    giaoVien.thamGiaKhoaHoc(KhoaHoc);  // Gọi phương thức tham gia khóa học
                    break;
                case 8: 
                    System.out.print("Nhập mã khóa học để hiển thị điểm: ");
                    String maKhoaHocHienThi = scanner.nextLine();
                    giaoVien.hienThiDiemTheoMaKhoaHoc(maKhoaHocHienThi);
                    break;
                case 9:
                    System.out.println("Đăng xuất khỏi tài khoản giáo viên.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}





