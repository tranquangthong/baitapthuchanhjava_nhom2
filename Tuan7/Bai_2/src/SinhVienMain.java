import java.util.Scanner;
public class SinhVienMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã sinh viên: ");
        String maSinhVien = scanner.nextLine();

        System.out.print("Nhập tên sinh viên: ");
        String ten = scanner.nextLine();

        System.out.print("Nhập ngày sinh: ");
        String ngaySinh = scanner.nextLine();

        System.out.print("Nhập điểm trung bình: ");
        double diemTrungBinh = scanner.nextDouble();

        SinhVien sv = new SinhVien(maSinhVien, ten, ngaySinh, diemTrungBinh);
        sv.inThongTin();

        scanner.close();
    }
}
