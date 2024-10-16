import java.util.Scanner;

public class UCLN_BCNN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên thứ nhất: ");
        int a = scanner.nextInt();
        System.out.print("Nhập số nguyên thứ hai: ");
        int b = scanner.nextInt();

        int ucln = timUCLN(a, b);
        int bcnn = (a * b) / ucln;

        System.out.println("UCLN của " + a + " và " + b + " là: " + ucln);
        System.out.println("BCNN của " + a + " và " + b + " là: " + bcnn);
    }

    public static int timUCLN(int a, int b) {
        if (b == 0) {
            return a;
        }
        return timUCLN(b, a % b);
    }
}
