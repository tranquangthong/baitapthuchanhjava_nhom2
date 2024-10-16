import java.util.Scanner;

class HinhChuNhat {
    private double chieuDai;
    private double chieuRong;

    public void nhapKichThuoc() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chiều dài: ");
        chieuDai = sc.nextDouble();
        System.out.print("Nhập chiều rộng: ");
        chieuRong = sc.nextDouble();
    }

    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }

    public double tinhChuVi() {
        return 2 * (chieuDai + chieuRong);
    }

    public void hienThi() {
        System.out.println("Chiều dài: " + chieuDai);
        System.out.println("Chiều rộng: " + chieuRong);
        System.out.println("Diện tích: " + tinhDienTich());
        System.out.println("Chu vi: " + tinhChuVi());
    }

    public static void main(String[] args) {
        HinhChuNhat hcn = new HinhChuNhat();
        hcn.nhapKichThuoc();
        hcn.hienThi();
    }
}
