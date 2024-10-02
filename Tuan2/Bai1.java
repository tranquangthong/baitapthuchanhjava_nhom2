
import java.util.Scanner;

public class Bai1{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nhập tên của bạn: ");
            String Name = sc.nextLine();
            System.out.println("Hello " + Name);
        }
    }
}

