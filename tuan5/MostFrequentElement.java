import java.util.HashMap;
import java.util.Scanner;

public class MostFrequentElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int mostFrequent = arr[0];
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) > frequencyMap.get(mostFrequent)) {
                mostFrequent = key;
            }
        }

        System.out.println("Phần tử xuất hiện nhiều nhất là: " + mostFrequent);
    }
}
