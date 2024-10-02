
import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int Goc, Thang;
            System.out.print("Nhap so tien gui (VNĐ):");
            Goc = sc.nextInt();
            System.out.print("\nNhap lai suat hang nam (%):");
            float Lai = sc.nextFloat();
            System.out.print("\nNhap so thang gui:");
            Thang = sc.nextInt();
            double TienLai = (double)Goc*((double)Lai/100)*(((double)Thang*30)/365);
            double TienNhan = (double)Goc + TienLai;

            System.out.printf("So tien lai sau %d thang: %.2f VND%n", Thang, TienLai);
            System.out.printf("Tong so tien goc và lai cuoi ky: %.2f VND%n", TienNhan);
        }
    }
}
