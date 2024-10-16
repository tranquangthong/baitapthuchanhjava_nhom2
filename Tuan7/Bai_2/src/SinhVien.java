import java.util.Scanner;

// Lớp Sinh Viên
class SinhVien {
    private String maSinhVien;
    private String ten;
    private String ngaySinh;
    private double diemTrungBinh;
    private String hocLuc;

    public SinhVien(String maSinhVien, String ten, String ngaySinh, double diemTrungBinh) {
        this.maSinhVien = maSinhVien;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        setDiemTrungBinh(diemTrungBinh);
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        if (diemTrungBinh >= 0 && diemTrungBinh <= 10) {
            this.diemTrungBinh = diemTrungBinh;
            xepLoai();
        } else {
            throw new IllegalArgumentException("Điểm trung bình phải từ 0 đến 10.");
        }
    }

    private void xepLoai() {
        if (diemTrungBinh >= 8) {
            hocLuc = "Giỏi";
        } else if (diemTrungBinh >= 6.5) {
            hocLuc = "Khá";
        } else if (diemTrungBinh >= 5) {
            hocLuc = "Trung bình";
        } else {
            hocLuc = "Yếu";
        }
    }

    public void inThongTin() {
        System.out.println("Mã SV: " + maSinhVien + ", Tên: " + ten + ", Ngày sinh: " + ngaySinh +
                ", Điểm TB: " + diemTrungBinh + ", Học lực: " + hocLuc);
    }
}