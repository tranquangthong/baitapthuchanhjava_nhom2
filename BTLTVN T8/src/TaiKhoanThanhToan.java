public class TaiKhoanThanhToan extends TaiKhoan {
    private double phiRutTienDuoi100K = 0.03; // 3% phí
    private double phiRutTienTren100K = 0.01; // 1% phí

    public TaiKhoanThanhToan(String soTaiKhoan, double soDu) {
        super(soTaiKhoan, soDu);
    }

    @Override
    public void rutTien(double soTien, String withdrawPassword, User user) {
        if (user.verifyWithdrawPassword(withdrawPassword)) {
            double phi = soTien < 100000 ? soTien * phiRutTienDuoi100K : soTien * phiRutTienTren100K;
            double tongTienRut = soTien + phi;

            if (tongTienRut <= soDu) {
                soDu -= tongTienRut;
                System.out.println("Đã rút " + soTien + " với phí " + phi + ". Số dư mới: " + soDu);
            } else {
                System.out.println("Số dư không đủ để thực hiện giao dịch.");
            }
        } else {
            System.out.println("Mật khẩu rút tiền không đúng.");
        }
    }

    @Override
    public void ketThucChuKy() {
        System.out.println("Không có thay đổi vào cuối kỳ cho Tài Khoản Thanh Toán.");
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
