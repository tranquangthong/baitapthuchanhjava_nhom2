public class NhanVien {
        String maNhanVien;
        String ten;
        double luongCoBan;

        public NhanVien(String maNhanVien, String ten, double luongCoBan) {
            this.maNhanVien = maNhanVien;
            this.ten = ten;
            this.luongCoBan = luongCoBan;
        }

        public double tinhLuong() {
            return luongCoBan;
        }
    }
