
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Nhap ten cua ban: ");
            String Ten = sc.nextLine();
            System.out.println("Nhap tuoi: ");
            int Tuoi =  sc.nextInt();
            System.out.println("Nhap chieu cao: ");
            int Ch = sc.nextInt();
            System.out.print("Ban co thich lap trinh khong?: ");
            boolean Lt = sc.nextBoolean();
            // boolean Lt = sc.nextBoolean();
            System.out.println("Ten ban la: " + Ten);
            System.out.println("Tuoi: " + Tuoi);
            System.out.println("Chieu cao: " + Ch + "cm");
            System.out.println("Có thích lập trình không: " + Lt);
            // System.out.println("Ban co thich lap trinh khong: " + Lt);
        }
    }
}
