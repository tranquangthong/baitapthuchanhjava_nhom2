import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaiKhoan taiKhoanTietKiem = null;
        TaiKhoan taiKhoanThanhToan = null;
        TaiKhoan taiKhoanDangNhap = null;
        DangNhap dangNhap = new DangNhap();
        boolean dangNhapThanhCong = false;
        boolean daDangKy = false;

        while (true) {
            System.out.println("\n--- MENU ---");
            if (!daDangKy) {
                System.out.println("1. Đăng ký tài khoản");
            }
            if (!dangNhapThanhCong && daDangKy) {
                System.out.println("2. Đăng nhập");
            }
            if (dangNhapThanhCong) {
                System.out.println("3. Xem số dư");
                System.out.println("4. Gửi tiền");
                System.out.println("5. Rút tiền");
                System.out.println("6. Đổi mật khẩu");
                System.out.println("7. Xem thông tin tài khoản");
                System.out.println("8. Chuyển khoản");
                System.out.println("9. Thanh toán");
                System.out.println("10. Tính lãi suất hàng tháng (TK Tiết Kiệm)");
                System.out.println("11. Đăng xuất");
            }
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1:
                    if (!daDangKy) {
                        System.out.print("Nhập số tài khoản: ");
                        String soTaiKhoan = scanner.nextLine();
                        System.out.print("Nhập chủ tài khoản: ");
                        String chuTaiKhoan = scanner.nextLine();

                        String soDienThoai;
                        while (true) {
                            System.out.print("Nhập số điện thoại (10 hoặc 11 số): ");
                            soDienThoai = scanner.nextLine();
                            if (DangKy.kiemTraSoDienThoaiHopLe(soDienThoai)) {
                                break;
                            } else {
                                System.out.println("Số điện thoại không hợp lệ.");
                            }
                        }

                        String matKhau;
                        while (true) {
                            System.out.print("Nhập mật khẩu (tối thiểu 8 ký tự, có chữ hoa, chữ thường, số và ký tự đặc biệt): ");
                            matKhau = scanner.nextLine();
                            if (DangKy.kiemTraMatKhauHopLe(matKhau)) {
                                break;
                            } else {
                                System.out.println("Mật khẩu không hợp lệ.");
                            }
                        }

                        taiKhoanTietKiem = new TaiKhoanTietKiem(soTaiKhoan, chuTaiKhoan, matKhau, soDienThoai);
                        taiKhoanThanhToan = new TaiKhoanThanhToan(soTaiKhoan, chuTaiKhoan, matKhau, soDienThoai);
                        daDangKy = true;
                        System.out.println("Đăng ký thành công.");
                    } else {
                        System.out.println("Bạn đã đăng ký.");
                    }
                    break;
                case 2:
                    if (!daDangKy) {
                        System.out.println("Bạn chưa đăng ký.");
                        break;
                    }
                    System.out.println("Chọn loại tài khoản:");
                    System.out.println("1. Tài khoản tiết kiệm");
                    System.out.println("2. Tài khoản thanh toán");
                    int loaiTaiKhoan = scanner.nextInt();
                    scanner.nextLine();
                    taiKhoanDangNhap = loaiTaiKhoan == 1 ? taiKhoanTietKiem : taiKhoanThanhToan;

                    while (!dangNhap.isBiKhoa()) {
                        System.out.print("Nhập số điện thoại: ");
                        String soDienThoai = scanner.nextLine();
                        System.out.print("Nhập mật khẩu: ");
                        String matKhauDangNhap = scanner.nextLine();
                        if (dangNhap.dangNhap(taiKhoanDangNhap, soDienThoai, matKhauDangNhap)) {
                            dangNhapThanhCong = true;
                            break;
                        }
                    }
                    break;
                case 3:
                    if (dangNhapThanhCong) taiKhoanDangNhap.xemSoDu();
                    else System.out.println("Bạn chưa đăng nhập.");
                    break;
                case 4:
                    if (dangNhapThanhCong) {
                        System.out.print("Nhập số tiền gửi: ");
                        double soTienGui = scanner.nextDouble();
                        scanner.nextLine();
                        taiKhoanDangNhap.guiTien(soTienGui);
                    } else System.out.println("Bạn chưa đăng nhập.");
                    break;
                case 5:
                    if (dangNhapThanhCong) {
                        System.out.print("Nhập số tiền rút: ");
                        double soTienRut = scanner.nextDouble();
                        scanner.nextLine();
                        taiKhoanDangNhap.rutTien(soTienRut);
                    } else System.out.println("Bạn chưa đăng nhập.");
                    break;
                case 6:
                    if (dangNhapThanhCong) {
                        String matKhauMoi;
                        while (true) {
                            System.out.print("Nhập mật khẩu mới: ");
                            matKhauMoi = scanner.nextLine();
                            if (DangKy.kiemTraMatKhauHopLe(matKhauMoi)) {
                                taiKhoanDangNhap.doiMatKhau(matKhauMoi);
                                System.out.println("Đổi mật khẩu thành công.");
                                break;
                            } else {
                                System.out.println("Mật khẩu không hợp lệ.");
                            }
                        }
                    } else System.out.println("Bạn chưa đăng nhập.");
                    break;
                case 7:
                    if (dangNhapThanhCong) taiKhoanDangNhap.xuatThongTin();
                    else System.out.println("Bạn chưa đăng nhập.");
                    break;
                case 8:
                    if (dangNhapThanhCong && taiKhoanDangNhap instanceof TaiKhoanThanhToan) {
                        System.out.print("Nhập số tiền chuyển khoản: ");
                        double soTienChuyen = scanner.nextDouble();
                        scanner.nextLine();
                        ((TaiKhoanThanhToan) taiKhoanDangNhap).chuyenKhoan(soTienChuyen, taiKhoanTietKiem);
                    } else System.out.println("Chỉ áp dụng cho tài khoản thanh toán và khi đã đăng nhập.");
                    break;
                case 9:
                    if (dangNhapThanhCong && taiKhoanDangNhap instanceof TaiKhoanThanhToan) {
                        System.out.print("Nhập số tiền thanh toán: ");
                        double soTienThanhToan = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Nhập tên bên nhận: ");
                        String benNhan = scanner.nextLine();
                        ((TaiKhoanThanhToan) taiKhoanDangNhap).thanhToan(soTienThanhToan, benNhan);
                    } else System.out.println("Chỉ áp dụng cho tài khoản thanh toán và khi đã đăng nhập.");
                    break;
                case 10:
                    if (dangNhapThanhCong && taiKhoanDangNhap instanceof TaiKhoanTietKiem) {
                        ((TaiKhoanTietKiem) taiKhoanDangNhap).tinhLaiSuatHangThang();
                    } else System.out.println("Chỉ áp dụng cho tài khoản tiết kiệm và khi đã đăng nhập.");
                    break;
                case 11:
                    dangNhapThanhCong = false;
                    taiKhoanDangNhap = null;
                    System.out.println("Đã đăng xuất.");
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }
    }
}