import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số tài khoản:");
        String soTaiKhoan = sc.nextLine();
        System.out.println("Nhập tên chủ tài khoản:");
        String chuTaiKhoan = sc.nextLine();
        System.out.println("Nhập số dư ban đầu:");
        double soDu = sc.nextDouble();
        sc.nextLine();
        System.out.println("Nhập mật khẩu tài khoản:");
        String matKhau = sc.nextLine();
        TaiKhoan taiKhoan = new TaiKhoan(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        taiKhoan.kiemTraSoDu();
        taiKhoan.doiMatKhau();
    }
}
