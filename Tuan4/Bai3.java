import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nhap So nguyen duong ");
            int n = sc.nextInt();
            long giaithua = 1;
            for(int i=1;i<= n;i++){
                giaithua = giaithua * i;
            }
            System.out.println(giaithua);
        }
    }
}
