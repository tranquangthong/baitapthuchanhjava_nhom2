public class Main {
    public static void main(String[] args) {
        NhanVien[] danhSachNhanVien = {
                new NhanVienSanXuat("NV01", "Nguyen Van A", 3000, 100),
                new NhanVienVanPhong("NV02", "Le Thi B", 4000, 1.5)
        };

        for (NhanVien nv : danhSachNhanVien) {
            System.out.println("Nhân viên: " + nv.ten + ", Lương: " + nv.tinhLuong());
        }
    }
}
