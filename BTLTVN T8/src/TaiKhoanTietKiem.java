public class TaiKhoanTietKiem extends TaiKhoan {
    private double laiSuat = 5.0; // Lãi suất cố định là 5%

    public TaiKhoanTietKiem(String soTaiKhoan, double soDu) {
        super(soTaiKhoan, soDu);
    }

    @Override
    public void rutTien(double soTien, String withdrawPassword, User user) {
        System.out.println("Tài khoản tiết kiệm không hỗ trợ rút tiền trực tiếp.");
    }

    public void tinhLaiSuat() {
        double tienLai = soDu * laiSuat / 100;
        soDu += tienLai;
        System.out.println("Đã cộng lãi " + tienLai + ". Số dư mới: " + soDu);
    }

    @Override
    public void ketThucChuKy() {
        tinhLaiSuat();
    }

    @Override
    public void guiTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Đã gửi " + soTien + ". Số dư mới: " + soDu);
        } else {
            System.out.println("Số tiền gửi phải lớn hơn 0.");
        }
    }
}
