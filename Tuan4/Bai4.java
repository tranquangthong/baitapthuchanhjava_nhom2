import java.util.Scanner;

public class Bai4 {
    public static boolean KT(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Nhập vào một số
            System.out.print("Nhap vao mot so nguyen: ");
            int n = sc.nextInt();
            
            if (KT(n)) {
                System.out.println(n + " la so nguyen to.");
            } else {
                System.out.println(n + " khong phai la so nguyen to.");
            }
        }
    }
}

