import java.util.Scanner;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;;

public abstract class TaiKhoan {
    Random random = new Random();
    public Scanner sc = new Scanner(System.in);
    protected String soTaiKhoan;
    protected String soDienThoai;
    protected String chuTaiKhoan;
    protected double soDu;
    protected ArrayList<String> lichSuGiaoDich = new ArrayList<>();
    private String matKhau;
    public static final DecimalFormat formatter = new DecimalFormat("#,###.##"); // Định dạng số dư
    public TaiKhoan() {
    }

    public TaiKhoan(String soTk,String chuTk){
        this.soTaiKhoan = soTk;
        this.chuTaiKhoan = chuTk;
    }

    public TaiKhoan(String soDienThoai,String soTK,String chuTK,double soDu,String matKhau){
        this.soDienThoai = soDienThoai;
        this.soTaiKhoan = soTK;
        this.chuTaiKhoan = chuTK;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }   

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }

    public void setChuTaiKhoan(String chuTaiKhoan) {
        this.chuTaiKhoan = chuTaiKhoan;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau){
        this.matKhau = matKhau;
    }

    public ArrayList<String> getLichSuGiaoDich() {
        return lichSuGiaoDich;
    }

    public void setLichSuGiaoDich(ArrayList<String> lichSuGiaoDich) {
        this.lichSuGiaoDich = lichSuGiaoDich;
    }

    public void guiTien(double tienGui){
        if(tienGui > 0){
            this.soDu += tienGui;
        } else {
            return;
        }
    }

    public void doiMatKhau(String mkCu) {
        String mkMoi,ktMkMoi;
        int i;
        i = 0;
        while(!mkCu.equals(this.matKhau)){
            System.out.println("Mật khẩu cũ không đúng vui lòng nhập lại: ");
            mkCu = sc.nextLine();
            i++;
            if(i == 3){
                System.out.println("Bạn nhập sai mật khẩu cũ quá nhiều lần");
                return;
            }
        }
        boolean isDungSai = false;
        do {
            System.out.println("Nhập mật khẩu mới mà bạn muốn đổi: ");
            mkMoi = sc.nextLine();
            isDungSai = kiemTraMatKhau(mkMoi); // Kiểm tra mật khẩu mới hợp lệ
            
            if (!isDungSai) {
                TaiKhoan.inRaThongBaoMK(isDungSai); // Thông báo mật khẩu không hợp lệ
                continue;
            }
        
            if (mkMoi.equals(mkCu)) {
                System.out.println("Mật khẩu mới không được trùng với mật khẩu cũ!!");
                continue;
            }
        
            // Xác nhận lại mật khẩu
            System.out.println("Nhập lại mật khẩu mới: ");
            ktMkMoi = sc.nextLine();
            while (!ktMkMoi.equals(mkMoi)) {
                System.out.println("Mật khẩu xác nhận không khớp! Vui lòng nhập lại: ");
                ktMkMoi = sc.nextLine();
            }
        
            // Đổi mật khẩu thành công
            this.matKhau = mkMoi;
            System.out.println("Đã đổi mật khẩu thành công!");
            System.out.println("Mật khẩu mới của bạn là " + this.getMatKhau());
            break; // Thoát vòng lặp khi thành công
        } while (true);
        
    }

    public void themGiaoDich(String chiTiet){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        lichSuGiaoDich.add( formattedDateTime + chiTiet);
        DocFile.ghiFile(this, formattedDateTime + chiTiet);
    }

    public String getSoDuFormatted() {
        return formatter.format(soDu) + " VNĐ";
    }

    public static String format(double soTien){
        return formatter.format(soTien) + " VNĐ"; 
    }

    public void hienThiSoDu() {
        System.out.println("Số dư tài khoản: " + this.getSoDuFormatted());
    }

    public static boolean kiemTraSoDienThoai(String soDienThoai) {
        // Kiểm tra độ dài là 10
        if (soDienThoai.length() != 10) {
            return false;
        }
    
        // Kiểm tra ký tự đầu tiên là '0'
        if (soDienThoai.charAt(0) != '0') {
            return false;
        }
    
        // Kiểm tra tất cả các ký tự đều là số
        for (int i = 1; i < soDienThoai.length(); i++) {
            if (!Character.isDigit(soDienThoai.charAt(i))) {
                return false;
            }
        }
    
        return true; // Nếu tất cả điều kiện đúng
    }    

    public static boolean kiemTraMatKhau(String matKhau){
        if(matKhau.length() < 8){
            return false;
        }
        boolean coChuInHoa = false; 
        boolean coChuSo = false;    
        for (char c : matKhau.toCharArray()) {
            if(Character.isUpperCase(c)){
                coChuInHoa = true;
            }
            if(Character.isDigit(c)){
                coChuSo = true;
            }

            if(coChuInHoa && coChuSo){
                return true;
            }
        }
       return false;
    }

    public static void inRaThongBaoMK(boolean kiemTraMatKhau){
        if(!kiemTraMatKhau){
            System.out.println("Mật khẩu phải có ít nhất 8 kí tự 1 chữ cái in hoa và 1 chữ số!!");
        }
    }
    public abstract void  rutTien(double soTien);
}
