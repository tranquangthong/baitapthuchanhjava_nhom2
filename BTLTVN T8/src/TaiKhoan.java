public abstract class TaiKhoan {
    protected String soTaiKhoan;
    protected double soDu;

    public TaiKhoan(String soTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.soDu = soDu;
    }

    public abstract void rutTien(double soTien, String withdrawPassword, User user);
    public abstract void ketThucChuKy();

    public abstract void guiTien(double soTien); // Thêm phương thức gửi tiền

    public double getSoDu() {
        return soDu;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }
}
