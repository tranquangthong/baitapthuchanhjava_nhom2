import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien {
    private String maSV;
    private String ten;
    private String ngaySinh;
    private double diemTB;

    // Constructor
    public SinhVien(String maSV, String ten, String ngaySinh, double diemTB) {
        this.maSV = maSV;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.diemTB = diemTB;
    }

    // Phương thức nhập thông tin
    public static SinhVien nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên: ");
        String maSV = sc.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        String ten = sc.nextLine();
        System.out.print("Nhập ngày sinh: ");
        String ngaySinh = sc.nextLine();
        System.out.print("Nhập điểm trung bình: ");
        double diemTB = sc.nextDouble();
        return new SinhVien(maSV, ten, ngaySinh, diemTB);
    }

    // Phương thức in thông tin
    public void inThongTin() {
        System.out.println("Mã SV: " + maSV);
        System.out.println("Tên: " + ten);
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Điểm trung bình: " + diemTB);
    }

    public double getDiemTB() {
        return diemTB;
    }

    // Main để thử nghiệm
    public static void main(String[] args) {
        ArrayList<SinhVien> dsSinhVien = new ArrayList<>();
        dsSinhVien.add(nhapThongTin());
        dsSinhVien.add(nhapThongTin());

        // Sắp xếp danh sách sinh viên theo điểm trung bình giảm dần
        Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
            public int compare(SinhVien sv1, SinhVien sv2) {
                return Double.compare(sv2.getDiemTB(), sv1.getDiemTB());
            }
        });

        // In thông tin sinh viên
        for (SinhVien sv : dsSinhVien) {
            sv.inThongTin();
        }
    }
}
