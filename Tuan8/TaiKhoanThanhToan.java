class TaiKhoanThanhToan extends TaiKhoan {
    private final double phiGiaoDich = 1000;
    private final double hanMucRutTien = 20000000;

    public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, String matKhau, String soDienThoai) {
        super(soTaiKhoan, chuTaiKhoan, matKhau, soDienThoai);
    }

    @Override
    public void rutTien(double soTien) {
        if (soTien > hanMucRutTien) {
            System.out.println("Số tiền vượt quá hạn mức rút!");
        } else if (soDu >= soTien + phiGiaoDich) {
            soDu -= (soTien + phiGiaoDich);
            thongBaoBienDongSoDu("Rút tiền", soTien);
        } else {
            System.out.println("Số dư không đủ.");
        }
    }

    public void thanhToan(double soTien, String benNhan) {
        if (soDu >= soTien + phiGiaoDich) {
            soDu -= (soTien + phiGiaoDich);
            thongBaoBienDongSoDu("Thanh toán cho " + benNhan, soTien);
        } else {
            System.out.println("Số dư không đủ.");
        }
    }

    public void chuyenKhoan(double soTien, TaiKhoan taiKhoanDich) {
        if (soDu >= soTien + phiGiaoDich) {
            soDu -= (soTien + phiGiaoDich);
            taiKhoanDich.guiTien(soTien);
            thongBaoBienDongSoDu("Chuyển khoản", soTien);
        } else {
            System.out.println("Số dư không đủ.");
        }
    }
}
