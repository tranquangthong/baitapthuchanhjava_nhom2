import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nhap n=");
            int n = sc.nextInt();
            int Tong = 0;
            for(int i=1;i<=n;i++){
                Tong = Tong + i;
            }
            System.out.print(Tong);
        }
    }
}
