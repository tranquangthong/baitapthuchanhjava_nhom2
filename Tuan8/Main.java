import java.text.DecimalFormat;
import java.util.Scanner;

class Main {
    static Scanner sc = new Scanner(System.in);
    public static final DecimalFormat formatter = new DecimalFormat("#,###.##"); // Định dạng số dư
    public static void main(String[] args) {
        QuanLiTaiKhoan danhSachTaiKhoan = new QuanLiTaiKhoan();
        int x;
        do {
            System.out.println("Nhập lựa chọn của bạn: ");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng kí tài khoản");
            System.out.println("3. Xóa tài khoản");
            System.out.println("0. Thoát");
            x = sc.nextInt();
            sc.nextLine();
            switch (x) {
                case 1:
                    System.out.println("Nhập số điện thoại của bạn: ");
                    String soDienThoai = sc.nextLine();
                    System.out.println("Nhập mật khẩu: ");
                    String matKhau = sc.nextLine();
                    danhSachTaiKhoan.dangNhap(soDienThoai, matKhau);
                    TaiKhoan taiKhoan = danhSachTaiKhoan.getTaiKhoanDangNhap(); 
                    int y;
                    if(taiKhoan != null){
                        do {
                            TaiKhoanThanhToan taiKhoanThanhToan = (TaiKhoanThanhToan) taiKhoan;
                            taiKhoanThanhToan.xuat();
                            System.out.println("Nhập lựa chọn của bạn: ");
                            System.out.println("1. Gửi tiền");
                            System.out.println("2. Rút tiền");
                            System.out.println("3. Chuyển tiền");
                            System.out.println("4. Mở tài khoản tiết kiệm");
                            System.out.println("5. Xem lịch sử giao dịch");
                            System.out.println("6. Sử dụng tài khoản tiết kiệm");
                            System.out.println("7. Đổi mật khẩu");
                            System.out.println("8. Đăng ký vay online");
                            System.out.println("9. Trả nợ");
                            System.out.println("10. Xem số nợ của bạn");
                            System.out.println("0. Đăng xuất");
                            y = sc.nextInt();
                            sc.nextLine();
                            switch (y) {
                                case 1:
                                    System.out.println("Nhập số tiền bạn muốn gửi: ");
                                        double soTien = sc.nextDouble();
                                        taiKhoanThanhToan.guiTien(soTien);
                                        taiKhoanThanhToan.themGiaoDich(" +" + TaiKhoan.format(soTien) +" bạn đã gửi " + TaiKhoan.format(soTien) +" vào tài khoản thanh toán của mình" + " số dư của bạn: " + taiKhoanThanhToan.getSoDuFormatted());
                                    break;
                                case 2:
                                    System.out.println("Nhập số tiền bạn muốn rút: ");
                                    double soTien1 = sc.nextDouble();
                                    taiKhoanThanhToan.rutTien(soTien1);
                                    break;
                                case 3:
                                    System.out.println("Nhập số tài khoản bạn muốn chuyển tới: ");
                                    String soTK = sc.nextLine();
                                    if(danhSachTaiKhoan.getDanhSachTaiKhoanSTK().get(soTK) == null){
                                        System.out.println("Không tìm thấy số tài khoản!");
                                    }else{
                                        System.out.println("Nhập số tiền bạn muốn chuyển: ");
                                        double soTienChuyen = sc.nextDouble();
                                        taiKhoanThanhToan.chuyenTien2(danhSachTaiKhoan.getDanhSachTaiKhoanSTK().get(soTK),soTienChuyen);
                                    }
                                    break;
                                case 4:
                                    taiKhoanThanhToan.moTaiKhoanTietKiem();
                                    break;
                                case 5:
                                    for (String string : taiKhoanThanhToan.getLichSuGiaoDich()) {
                                        System.out.println(string);
                                    }
                                    break;
                                case 6:
                                    TaiKhoanTietKiem taiKhoanTietKiem = taiKhoanThanhToan.getTaiKhoanTietKiem();
                                    int z;
                                    if(taiKhoanTietKiem != null){
                                        do {
                                            System.out.println("Nhập lựa chọn của bạn: ");
                                            System.out.println("1. Gửi tiền tiết kiệm");
                                            System.out.println("2. Tính lãi suất");
                                            System.out.println("3. Rút tiền");
                                            System.out.println("4. Rút tiền về tài khoản thanh toán");
                                            System.out.println("5. Xem lịch sử giao dịch");
                                            System.out.println("0. Trở về tài khoản thanh toán");
                                            taiKhoanTietKiem.xuat();
                                            taiKhoanThanhToan.xuat();
                                            z = sc.nextInt();
                                            switch(z){
                                                case 1:
                                                    System.out.println("Nhập số tiền tiết kiệm bạn muốn gửi: ");
                                                    double tienGui = sc.nextDouble();
                                                    taiKhoanThanhToan.guiTienTietKiem(tienGui);
                                                break;
                                                case 2:
                                                break;
                                                case 3:
                                                    System.out.println("Nhập số tiền bạn muốn rút: ");
                                                    double soTienRut = sc.nextDouble();
                                                    taiKhoanTietKiem.rutTien(soTienRut);
                                                break;
                                                case 4:
                                                    System.out.println("Nhập số tiền bạn muốn gửi sang tài khoản thanh toán: ");
                                                    double tienChuyen = sc.nextDouble();
                                                    taiKhoanTietKiem.chuyenTienSangTKThanhToan(taiKhoanThanhToan, tienChuyen);
                                                break;
                                                case 5:
                                                    for (String string : taiKhoanTietKiem.getLichSuGiaoDich()) {
                                                        System.out.println(string);
                                                    }
                                                    break;
                                            }
                                        } while (z != 0);
                                        }else{
                                            System.out.println("Bạn chưa có tài khoản tiền kiệm.Nhập 4 để mở");
                                        }
                                    break;
                                    case 7:
                                        System.out.println("Nhập mật khẩu cũ: ");
                                        String mkCu = sc.nextLine();
                                        taiKhoanThanhToan.doiMatKhau(mkCu);
                                    break;
                                    case 8:
                                        System.out.println("Nhập số tiền bạn muốn vay: ");
                                        double tienVay = sc.nextDouble();
                                        System.out.println("Nhập kì hạn ");
                                        int kyHan = sc.nextInt();
                                        taiKhoanThanhToan.dangKyVay(tienVay, kyHan);
                                        break;
                                    case 9:
                                        System.out.println("Nhập số tiền bạn muốn trả: ");
                                        double tienTra = sc.nextDouble();
                                        taiKhoanThanhToan.traNo(tienTra);
                                        break;
                                    case 10:
                                        System.out.println("Xem số tiền còn nợ của bạn");
                                        taiKhoanThanhToan.xemNo();
                                        break;
                            } 
                        }while (y != 0);
                    }
                    danhSachTaiKhoan.setTaiKhoanDangNhap(null);
                    break;
                case 2:
                    danhSachTaiKhoan.themTaiKhoan(new TaiKhoanThanhToan());
                    break;
                case 3:
                    System.out.println("Nhập số tài khoản bạn muốn xóa");
                    String stk = sc.nextLine();
                    danhSachTaiKhoan.xoaTaiKhoan(stk);
                    break;
            }
        } while (x != 0);
    }
}