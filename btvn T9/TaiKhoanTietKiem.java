public class TaiKhoanTietKiem extends TaiKhoan {
    private double laiSuat = 5.0; // Lãi suất cố định là 5%

    public TaiKhoanTietKiem(String soTaiKhoan, double soDu) {
        super(soTaiKhoan, soDu);
    }

    @Override
    public void rutTien(double soTien, String withdrawPassword, User user) {
        if (soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Đã rút " + soTien + ". Số dư mới: " + soDu);
        } else {
            System.out.println("Không thể rút quá số dư hiện tại.");
        }
    }

    public void tinhLaiSuat() {
        double tienLai = soDu * laiSuat / 100;
        soDu += tienLai;
        System.out.println("Đã cộng lãi " + tienLai + ". Số dư mới: " + soDu);
    }

    public void ketThucChuKy() {
        tinhLaiSuat();
    }
}
