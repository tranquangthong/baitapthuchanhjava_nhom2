class Bao extends TaiLieu {
    String ngayPhatHanh;

    public Bao(String maTaiLieu, String tenTaiLieu, int namXuatBan, String ngayPhatHanh) {
        super(maTaiLieu, tenTaiLieu, namXuatBan);
        this.ngayPhatHanh = ngayPhatHanh;
    }
}