import java.util.Scanner;

class TaiKhoan {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;

    // Constructor
    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
    }

    // Phương thức gửi tiền
    public void guiTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Gửi thành công. Số dư hiện tại: " + soDu);
        } else {
            System.out.println("Số tiền không hợp lệ.");
        }
    }

    // Phương thức rút tiền
    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Rút thành công. Số dư hiện tại: " + soDu);
        } else {
            System.out.println("Số tiền không hợp lệ hoặc không đủ số dư.");
        }
    }

    // Phương thức kiểm tra số dư
    public void kiemTraSoDu() {
        System.out.println("Số dư hiện tại: " + soDu);
    }

    // Main để thử nghiệm
    public static void main(String[] args) {
        TaiKhoan tk = new TaiKhoan("123456", "Nguyen Van A", 5000000);
        Scanner sc = new Scanner(System.in);

        // Gửi tiền
        System.out.print("Nhập số tiền gửi: ");
        double soTienGui = sc.nextDouble();
        tk.guiTien(soTienGui);

        // Rút tiền
        System.out.print("Nhập số tiền rút: ");
        double soTienRut = sc.nextDouble();
        tk.rutTien(soTienRut);

        // Kiểm tra số dư
        tk.kiemTraSoDu();
    }
}

