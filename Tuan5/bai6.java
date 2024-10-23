import java.util.ArrayList;
import java.util.Scanner;

public class bai6 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> danhSach = new ArrayList<>();
        
        // Thêm phần tử vào danh sách
        System.out.println("Nhập số lượng phần tử của danh sách:");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập phần tử thứ %d: ", i + 1);
            int phanTu = scanner.nextInt();
            danhSach.add(phanTu);
        }
        
        // Thêm phần tử vào vị trí chỉ định
        System.out.println("Nhập phần tử cần thêm:");
        int phanTuMoi = scanner.nextInt();
        System.out.println("Nhập vị trí cần thêm (bắt đầu từ 0):");
        int viTri = scanner.nextInt();
        
        if (viTri >= 0 && viTri <= danhSach.size()) {
            danhSach.add(viTri, phanTuMoi);
            System.out.println("Danh sách sau khi thêm:");
            System.out.println(danhSach);
        } else {
            System.out.println("Vị trí không hợp lệ.");
        }
        
        // Xóa phần tử tại vị trí chỉ định
        System.out.println("Nhập vị trí cần xóa:");
        int viTriXoa = scanner.nextInt();
        
        if (viTriXoa >= 0 && viTriXoa < danhSach.size()) {
            danhSach.remove(viTriXoa);
            System.out.println("Danh sách sau khi xóa:");
            System.out.println(danhSach);
        } else {
            System.out.println("Vị trí không hợp lệ.");
        }
    }
}