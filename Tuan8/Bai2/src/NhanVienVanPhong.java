class NhanVienVanPhong extends NhanVien {
    double heSoLuong;

    public NhanVienVanPhong(String maNhanVien, String ten, double luongCoBan, double heSoLuong) {
        super(maNhanVien, ten, luongCoBan);
        this.heSoLuong = heSoLuong;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan * heSoLuong;
    }
}