import java.util.Scanner;

public class Bai6 {
    public static boolean KTDoiXung(int n) {
        int original = n;
        int reverse = 0;
        
        while (n != 0) {
            int lastDigit = n % 10; 
            reverse = reverse * 10 + lastDigit; 
            n /= 10;
        }
        return original == reverse;
    }
     public static void main(String[] args) {
         try (Scanner sc = new Scanner(System.in)) {
             System.out.print("Nhap vao mot so nguyen: ");
             int n = sc.nextInt();
             
             if (KTDoiXung(n)) {
                 System.out.println(n + " la so đoi xung.");
             } else {
                 System.out.println(n + " khong phai la so đoi xung.");
             }}
    }
}
