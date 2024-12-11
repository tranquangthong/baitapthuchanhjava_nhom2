/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlytrungtam;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QuanLyDiem {
    // Map lưu trữ điểm học viên theo khóa học
    private Map<String, Map<String, Double>> diemHocVienTheoKhoaHoc;

    // Constructor
    public QuanLyDiem() {
        // Khởi tạo Map chứa danh sách điểm theo khóa học
        this.diemHocVienTheoKhoaHoc = new HashMap<>();
    }
    // Thêm điểm vào danh sách
    public void themDiem(String tenKhoaHoc, String maHocVien, Double diem) {
        // Đảm bảo khóa học tồn tại trong Map
        diemHocVienTheoKhoaHoc.putIfAbsent(tenKhoaHoc, new HashMap<>());

        // Thêm hoặc cập nhật điểm học viên
        diemHocVienTheoKhoaHoc.get(tenKhoaHoc).put(maHocVien, diem);
        System.out.println("Đã thêm điểm " + diem + " cho học viên " + maHocVien + " trong khóa học " + tenKhoaHoc);
    }

    // Hiển thị danh sách điểm theo khóa học
    public void hienThiDanhSachDiem() {
        System.out.println("Danh sách điểm theo khóa học:");
        if (diemHocVienTheoKhoaHoc.isEmpty()) {
            System.out.println("Chưa có điểm nào.");
        } else {
            // Duyệt qua các khóa học và điểm học viên
            for (Map.Entry<String, Map<String, Double>> entry : diemHocVienTheoKhoaHoc.entrySet()) {
                String tenKhoaHoc = entry.getKey();
                System.out.println("Khóa học: " + tenKhoaHoc);
                Map<String, Double> diemHocVien = entry.getValue();
                for (Map.Entry<String, Double> diemEntry : diemHocVien.entrySet()) {
                    String maHocVien = diemEntry.getKey();
                    Double diem = diemEntry.getValue();
                    System.out.println("  - Mã học viên: " + maHocVien + ", Điểm: " + diem);
                }
            }
        }
    }

    // Xuất danh sách điểm ra file
    public void xuatDanhSachDiemRaFile() {
        // Tạo đối tượng file để lưu danh sách điểm
        File file = new File("danhSachDiemTheoKhoaHoc.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Kiểm tra xem có điểm nào không
            if (diemHocVienTheoKhoaHoc.isEmpty()) {
                writer.write("Chưa có điểm nào.\n");
            } else {
                writer.write("Danh sách điểm theo khóa học:\n");
                // Duyệt qua các khóa học và điểm học viên
                for (Map.Entry<String, Map<String, Double>> entry : diemHocVienTheoKhoaHoc.entrySet()) {
                    String tenKhoaHoc = entry.getKey();
                    writer.write("Khóa học: " + tenKhoaHoc + "\n");

                    Map<String, Double> diemHocVien = entry.getValue();
                    for (Map.Entry<String, Double> diemEntry : diemHocVien.entrySet()) {
                        String maHocVien = diemEntry.getKey();
                        Double diem = diemEntry.getValue();
                        writer.write("  - Mã học viên: " + maHocVien + ", Điểm: " + diem + "\n");
                    }
                }
            }
            System.out.println("Danh sách điểm đã được xuất ra file: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Lỗi khi xuất file: " + e.getMessage());
        }
    }
}
