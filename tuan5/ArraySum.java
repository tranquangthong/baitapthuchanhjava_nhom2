import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        int sum = 0;

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }

        System.out.println("Tổng các phần tử trong mảng là: " + sum);
    }
}
