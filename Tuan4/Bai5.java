import java.util.Scanner;

public class Bai5 {
    public static int timUCLN(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static int timBCNN(int a, int b, int ucln) {
        return Math.abs(a * b) / ucln;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Nhap so nguyen thu nhat: ");
            int a = sc.nextInt();
            System.out.print("Nhap so nguyen thu hai: ");
            int b = sc.nextInt();
            
            int ucln = timUCLN(a, b);
            int bcnn = timBCNN(a, b, ucln);
            
            System.out.println("Uuc chung lon nhat (UCLN) cua " + a + " va " + b + " la: " + ucln);
            System.out.println("Boi chung nho nhat (BCNN) cua " + a + " va " + b + " la: " + bcnn);
        }
    }
}
