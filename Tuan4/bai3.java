import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương: ");
        int n = scanner.nextInt();
        long factorial = 1;
        
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        
        System.out.println("Giai thừa của " + n + " là: " + factorial);
    }
}
