public class TaiKhoanThanhToan extends TaiKhoan {
    private double hanMucThauChi; // Hạn mức thấu chi

    public TaiKhoanThanhToan(String soTaiKhoan, double soDu, double hanMucThauChi) {
        super(soTaiKhoan, soDu);
        this.hanMucThauChi = hanMucThauChi;
    }

    @Override
    public void rutTien(double soTien, String withdrawPassword, User user) {
        double tongTienRut = soTien;

        if (user.verifyWithdrawPassword(withdrawPassword)) {
            if (soDu + hanMucThauChi >= tongTienRut) {
                soDu -= tongTienRut;
                System.out.println("Đã rút " + soTien + ". Số dư mới: " + soDu);
            } else {
                System.out.println("Số dư không đủ để thực hiện giao dịch.");
            }
        } else {
            System.out.println("Mật khẩu rút tiền không đúng.");
        }
    }

    public void ketThucChuKy() {
        System.out.println("Không có thay đổi vào cuối kỳ cho Tài Khoản Thanh Toán.");
    }
}
