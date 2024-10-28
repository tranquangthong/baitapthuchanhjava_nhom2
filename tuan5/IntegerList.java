import java.util.ArrayList;
import java.util.Scanner;

public class IntegerList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> integerList = new ArrayList<>();

        System.out.println("Nhập số lượng phần tử của danh sách:");
        int size = scanner.nextInt();

        System.out.println("Nhập các phần tử của danh sách:");
        for (int i = 0; i < size; i++) {
            integerList.add(scanner.nextInt());
        }

        System.out.println("Các phần tử trong danh sách là:");
        for (int num : integerList) {
            System.out.print(num + " ");
        }
    }
}
