package quanlytrungtam;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TaiLieu {
    private String tenTaiLieu;
    private String moTa;
    private String noiDung; // Nội dung tài liệu (giả lập)

    // Constructor
    public TaiLieu(String tenTaiLieu, String moTa, String noiDung) {
        this.tenTaiLieu = tenTaiLieu;
        this.moTa = moTa;
        this.noiDung = noiDung;
    }

    // Getter
    public String getTenTaiLieu() {
        return tenTaiLieu;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public static List<TaiLieu> docDanhSachTaiLieu(String fileName) {
        List<TaiLieu> danhSach = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Đọc dòng: " + line); // Debug: Kiểm tra dòng đọc được
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String tenTaiLieu = parts[0].trim();
                    String moTa = parts[1].trim();
                    String noiDung = parts[2].trim();
                    danhSach.add(new TaiLieu(tenTaiLieu, moTa, noiDung));
                    System.out.println("Thêm tài liệu: " + tenTaiLieu); // Debug: Xác nhận thêm thành công
                } else {
                    System.out.println("Dòng không đúng định dạng: " + line); // Debug: Báo lỗi định dạng
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }

        return danhSach;
    }
}