class TaiKhoanTietKiem extends TaiKhoan {
    private double laiSuat = 0.03;

    public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, String matKhau, String soDienThoai) {
        super(soTaiKhoan, chuTaiKhoan, matKhau, soDienThoai);
    }

    @Override
    public void rutTien(double soTien) {
        if (soDu >= soTien) {
            soDu -= soTien;
            thongBaoBienDongSoDu("Rút tiền", soTien);
        } else {
            System.out.println("Số dư không đủ để rút.");
        }
    }

    public void tinhLaiSuatHangThang() {
        double tienLai = soDu * laiSuat;
        guiTien(tienLai); // Gửi tiền lãi suất vào tài khoản
    }
}
