import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien {
    private String maSV;
    private String tenSV;
    private String ngaySinh;
    private double diemTB;

    public SinhVien() {
    }

    public void nhapThongTin
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên: ");
        maSV = sc.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        tenSV = sc.nextLine();
        System.out.print("Nhập ngày sinh: ");
        ngaySinh = sc.nextLine();
        System.out.print("Nhập điểm trung bình: ");
        diemTB = sc.nextDouble();
    }

    public void inThongTin() {
        System.out.println("Mã SV: " + maSV);
        System.out.println("Tên SV: " + tenSV);
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Điểm trung bình: " + diemTB);
    }

    public double getDiemTB() {
        return diemTB;
    }

    public static void main(String[] args) {
        ArrayList<SinhVien> danhSachSV = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        int soSV = sc.nextInt();

        for (int i = 0; i < soSV; i++) {
            SinhVien sv = new SinhVien();
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");
            sv.nhapThongTin();
            danhSachSV.add(sv);
        }

        Collections.sort(danhSachSV, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                return Double.compare(sv2.getDiemTB(), sv1.getDiemTB());
            }
        });

        System.out.println("\nDanh sách sinh viên sau khi sắp xếp theo điểm trung bình giảm dần:");
        for (SinhVien sv : danhSachSV) {
            sv.inThongTin();
            System.out.println();
        }
    }
}

