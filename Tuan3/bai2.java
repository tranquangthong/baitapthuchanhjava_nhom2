package Tuan3;

import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập điểm trung bình: ");
        double diemTrungBinh = scanner.nextDouble();

        String xepLoai;
        if (diemTrungBinh >= 8.0) {
            xepLoai = "Giỏi";
        } else if (diemTrungBinh >= 6.5) {
            xepLoai = "Khá";
        } else if (diemTrungBinh >= 5.0) {
            xepLoai = "Trung bình";
        } else {
            xepLoai = "Yếu";
        }

        System.out.println("Xếp loại học sinh: " + xepLoai);
    }
}
