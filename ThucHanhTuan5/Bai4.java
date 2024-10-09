/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanhtuan5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Nhập số lượng phần tử của mảng
        System.out.println("Nhập số lượng phần tử của mảng:");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        // Nhập các phần tử của mảng
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập phần tử thứ %d: ", i + 1);
            arr[i] = scanner.nextInt();
        }
        
        // Tìm phần tử xuất hiện nhiều nhất
        int phanTuXuatHienNhieuNhat = timPhanTuXuatHienNhieuNhat(arr);
        System.out.println("Phần tử xuất hiện nhiều nhất là: " + phanTuXuatHienNhieuNhat);
    }

    public static int timPhanTuXuatHienNhieuNhat(int[] arr) {
        // Sử dụng HashMap để đếm số lần xuất hiện của các phần tử
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (countMap.containsKey(arr[i])) {
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            } else {
                countMap.put(arr[i], 1);
            }
        }
        
        // Tìm phần tử có số lần xuất hiện nhiều nhất
        int maxCount = 0;
        int maxElement = arr[0];
        
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxElement = entry.getKey();
            }
        }
        
        return maxElement;
    }
}
