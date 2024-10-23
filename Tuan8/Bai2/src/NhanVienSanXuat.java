class NhanVienSanXuat extends NhanVien {
    int soSanPham;

    public NhanVienSanXuat(String maNhanVien, String ten, double luongCoBan, int soSanPham) {
        super(maNhanVien, ten, luongCoBan);
        this.soSanPham = soSanPham;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + soSanPham * 5;
    }
}
