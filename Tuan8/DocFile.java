import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DocFile {
    public static void ghiFile(TaiKhoan taiKhoan,String lichSuGiaoDich){
        String filePath = "D:\\124THLTHDT05Thu4Tiet78\\Tuan8\\" + taiKhoan.getSoTaiKhoan() + "TenTk" + taiKhoan.chuTaiKhoan + ".txt"; // Đường dẫn file

        // Kiểm tra danh sách giao dịch có hợp lệ không
        if (taiKhoan.lichSuGiaoDich == null || taiKhoan.lichSuGiaoDich.isEmpty()) {
            System.out.println("Danh sách lịch sử giao dịch rỗng. Không có gì để ghi.");
            return;
        }

        try {
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            bufWriter.write(lichSuGiaoDich);
            bufWriter.newLine();
            bufWriter.close();
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi vào file: " + e.getMessage());
        }   
    }

    public static void ghiFile1Argument(TaiKhoan taiKhoan){
        String filePath = "D:\\124THLTHDT05Thu4Tiet78\\Tuan8\\" + taiKhoan.getSoTaiKhoan() + "TenTk" + taiKhoan.chuTaiKhoan + ".txt"; // Đường dẫn file

        try {
            FileWriter fileWriter = new FileWriter(filePath,true);
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
}
