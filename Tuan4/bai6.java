import java.util.Scanner;

public class bai6 {
    public static boolean isPalindrome(int n) {
        int original = n;
        int reversed = 0;
        
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        
        return original == reversed;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số nguyên: ");
        int n = scanner.nextInt();
        
        if (isPalindrome(n)) {
            System.out.println(n + " là số đối xứng.");
        } else {
            System.out.println(n + " không phải là số đối xứng.");
        }
    }
    
}
