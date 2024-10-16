import java.util.Scanner;

// Lớp Hình Tròn
class HinhTron {
    private double banKinh;

    public HinhTron(double banKinh) {
        if (banKinh > 0) {
            this.banKinh = banKinh;
        } else {
            throw new IllegalArgumentException("Bán kính phải lớn hơn 0.");
        }
    }

    public double tinhChuVi() {
        return 2 * Math.PI * banKinh;
    }

    public double tinhDienTich() {
        return Math.PI * banKinh * banKinh;
    }
}