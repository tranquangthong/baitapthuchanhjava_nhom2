package taikhoan;

import java.util.Scanner;

public class TaiKhoan {

    public static void main(String[] args) {
        HeThongNganHang heThongNganHang = new HeThongNganHang();
        Scanner sc = new Scanner(System.in);
        boolean dangChay = true;

        TaiKhoanNganHang taiKhoanHienTai = null;

        while (dangChay) {
            hienThiMenuChinh();
            int luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    heThongNganHang.dangKi();
                    break;
                case 2:
                    taiKhoanHienTai = heThongNganHang.dangNhap();
                    if (taiKhoanHienTai != null) {
                        hienThiMenuChucNang(sc, heThongNganHang, taiKhoanHienTai);
                    } else {
                        System.out.println("Dang nhap that bai.");
                    }
                    break;
                case 3:
                    System.out.println("Thoat chuong trinh.");
                    dangChay = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
        sc.close();
    }

    private static void hienThiMenuChinh() {
        System.out.println("----- MENU CHINH -----");
        System.out.println("1. Dang ky tai khoan");
        System.out.println("2. Dang nhap");
        System.out.println("3. Thoat");
        System.out.print("Nhap lua chon cua ban: ");
    }

    private static void hienThiMenuChucNang(Scanner sc, HeThongNganHang heThongNganHang, TaiKhoanNganHang taiKhoanHienTai) {
        boolean dangNhap = true;
        while (dangNhap) {
            taiKhoanHienTai.hienThiMenu();
            int luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1: // Rut tien
                    System.out.print("Nhap so tien muon rut: ");
                    double soTienRut = sc.nextDouble();
                    sc.nextLine();
                    taiKhoanHienTai.rutTien(soTienRut);
                    break;
                case 2: // Gui tien
                    System.out.print("Nhap so tien muon gui: ");
                    double soTienGui = sc.nextDouble();
                    sc.nextLine();
                    taiKhoanHienTai.guiTien(soTienGui);
                    break;
                case 3: // Kiem tra so du
                    System.out.println("So du hien tai: " + taiKhoanHienTai.getSoDu());
                    break;
                case 4:
                    if (taiKhoanHienTai instanceof TaiKhoanTietKiem) {
                        // Truong hop 4 cho TaiKhoanTietKiem: Tinh lai suat
                        ((TaiKhoanTietKiem) taiKhoanHienTai).tinhLai();
                    } else if (taiKhoanHienTai instanceof TaiKhoanThanhToan) {
                        // Truong hop 4 cho TaiKhoanThanhToan: Chuyen khoan
                        System.out.print("Nhap so tai khoan nhan: ");
                        String soTaiKhoanNhan = sc.nextLine();
                        System.out.print("Nhap so tien muon chuyen: ");
                        double soTienChuyen = sc.nextDouble();
                        sc.nextLine();
                        TaiKhoanNganHang taiKhoanNhan = heThongNganHang.timTaiKhoan(soTaiKhoanNhan);
                        if (taiKhoanNhan != null) {
                            ((TaiKhoanThanhToan) taiKhoanHienTai).chuyenKhoan(taiKhoanNhan, soTienChuyen, heThongNganHang);
                        } else {
                            System.out.println("Tai khoan nhan khong ton tai.");
                        }
                    }
                    break;
                case 5:
                    if (taiKhoanHienTai instanceof TaiKhoanTietKiem) {
                        // Truong hop 5 cho TaiKhoanTietKiem: Doi mat khau
                        heThongNganHang.doiMatKhau(taiKhoanHienTai);
                    } else if (taiKhoanHienTai instanceof TaiKhoanThanhToan) {
                     System.out.println("Chon loai hoa don de thanh toan:");
                        System.out.println("1. Hoa don dien");
                        System.out.println("2. Hoa don nuoc");
                        System.out.println("3. Hoa don internet");
                        int loaiHoaDon = sc.nextInt();
                        sc.nextLine();

                        IThanhToanHoaDon hoaDon;
                        switch (loaiHoaDon) {
                            case 1:
                                hoaDon = new HoaDonDien();
                                break;
                            case 2:
                                hoaDon = new HoaDonNuoc();
                                break;
                            case 3:
                                hoaDon = new HoaDonInternet();
                                break;
                            default:
                                System.out.println("Lua chon khong hop le.");
                                continue;
                        }

                        System.out.print("Nhap so tien can thanh toan: ");
                        double soTien = sc.nextDouble();
                        sc.nextLine();

                        ((TaiKhoanThanhToan) taiKhoanHienTai).thanhToanHoaDon(hoaDon, soTien);
                    }
                    break;
                case 6:
                    if (taiKhoanHienTai instanceof TaiKhoanTietKiem) {
                        // Truong hop 6 cho TaiKhoanTietKiem: Dang xuat
                        System.out.println("Da dang xuat.");
                        dangNhap = false;
                    } else if (taiKhoanHienTai instanceof TaiKhoanThanhToan) {
                        // Truong hop 6 cho TaiKhoanThanhToan: Doi mat khau
                        heThongNganHang.doiMatKhau(taiKhoanHienTai);
                    }
                    break;
                case 7:
                    if (taiKhoanHienTai instanceof TaiKhoanThanhToan) {
                        // Truong hop 7 cho TaiKhoanThanhToan: Dang xuat
                        System.out.println("Da dang xuat.");
                        dangNhap = false;
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }
}
