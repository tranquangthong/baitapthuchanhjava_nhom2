class DangNhap {
    private int soLanSai = 0;
    private final int gioiHanSai = 5;
    private boolean biKhoa = false;

    public boolean dangNhap(TaiKhoan taiKhoan, String soDienThoai, String matKhau) {
        if (biKhoa) {
            System.out.println("Tài khoản đã bị khóa.");
            return false;
        }

        if (taiKhoan.kiemTraSoDienThoai(soDienThoai) && taiKhoan.kiemTraMatKhau(matKhau)) {
            soLanSai = 0;
            System.out.println("Đăng nhập thành công.");
            return true;
        } else {
            soLanSai++;
            System.out.println("Sai thông tin. Còn " + (gioiHanSai - soLanSai) + " lần.");
            if (soLanSai >= gioiHanSai) {
                biKhoa = true;
                System.out.println("Tài khoản đã bị khóa.");
            }
            return false;
        }
    }

    public boolean isBiKhoa() {
        return biKhoa;
    }
}