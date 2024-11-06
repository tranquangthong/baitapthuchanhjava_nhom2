public abstract class TaiKhoan {
    protected String soTaiKhoan;
    protected double soDu;

    public TaiKhoan(String soTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.soDu = soDu;
    }

    public abstract void rutTien(double soTien, String withdrawPassword, User user);

    public void guiTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Đã gửi " + soTien + ". Số dư mới: " + soDu);
        } else {
            System.out.println("Số tiền gửi phải lớn hơn 0.");
        }
    }

    public double getSoDu() {
        return soDu;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }
}
