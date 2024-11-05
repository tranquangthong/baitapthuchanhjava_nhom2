
abstract class TaiKhoan {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    protected double soDu = 0;
    private String matKhau;
    private String soDienThoai;

    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, String matKhau, String soDienThoai) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.matKhau = matKhau;
        this.soDienThoai = soDienThoai;
    }

    public boolean kiemTraMatKhau(String matKhau) {
        return this.matKhau.equals(matKhau);
    }

    public boolean kiemTraSoDienThoai(String soDienThoai) {
        return this.soDienThoai.equals(soDienThoai);
    }

    public void doiMatKhau(String matKhauMoi) {
        this.matKhau = matKhauMoi;
    }

    public void guiTien(double soTien) {
        soDu += soTien;
        thongBaoBienDongSoDu("Gửi tiền", soTien);
    }

    public abstract void rutTien(double soTien);

    public void xemSoDu() {
        System.out.println("Số dư hiện tại: " + soDu);
    }

    public void xuatThongTin() {
        System.out.println("Thông tin tài khoản:");
        System.out.println("Số tài khoản: " + soTaiKhoan);
        System.out.println("Chủ tài khoản: " + chuTaiKhoan);
        System.out.println("Số điện thoại: " + soDienThoai);
        System.out.println("Số dư: " + soDu);
    }

    protected void thongBaoBienDongSoDu(String loaiGiaoDich, double soTien) {
        System.out.println(loaiGiaoDich + " thành công. Số tiền: " + soTien + ". Số dư mới: " + soDu);
    }
}