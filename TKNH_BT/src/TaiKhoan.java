import java.util.Scanner;

public class TaiKhoan {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    private String matKhau;

    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }
    public void guiTien(double soTien) {
        if (soTien > 0) {
            this.soDu += soTien;
            System.out.println("Gửi tiền thành công. Số dư mới: " + this.soDu);
        } else {
            System.out.println("Số tiền gửi không hợp lệ!");
        }
    }
    public void rutTien(double soTien) {
        if (soTien > 0 && this.soDu >= soTien) {
            this.soDu -= soTien;
            System.out.println("Rút tiền thành công. Số dư còn lại: " + this.soDu);
        } else {
            System.out.println("Số tiền rút không hợp lệ hoặc không đủ số dư!");
        }
    }
    public void kiemTraSoDu() {
        System.out.println("Số dư hiện tại: " + this.soDu);
    }
    public void doiMatKhau() {
        Scanner sc = new Scanner(System.in);
        boolean daThayDoi = false;
        while (!daThayDoi) {
            System.out.println("Nhập mật khẩu hiện tại:");
            String matKhauCuNhap = sc.nextLine();
            if (this.matKhau.equals(matKhauCuNhap)) {
                System.out.println("Nhập mật khẩu mới:");
                String matKhauMoiNhap = sc.nextLine();
                if (this.matKhau.equals(matKhauMoiNhap)) {
                    System.out.println("Mật khẩu mới trùng với mật khẩu cũ! Vui lòng nhập mật khẩu khác!");
                } else {
                    this.matKhau = matKhauMoiNhap;
                    daThayDoi = true;
                    System.out.println("Thay đổi mật khẩu thành công!");
                }
            } else {
                System.out.println("Mật khẩu hiện tại không đúng! Vui lòng thử lại.");
            }
        }
    }

    // Getter cho số tài khoản và tên chủ tài khoản
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }
}
