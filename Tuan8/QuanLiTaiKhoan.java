import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class QuanLiTaiKhoan {
    private HashMap<String, TaiKhoan> danhSachTaiKhoan = new HashMap<>();
    private HashMap<String, TaiKhoan> danhSachTaiKhoanSTK = new HashMap<>();
    private TaiKhoan taiKhoanDangNhap = null;
    public static Scanner sc = new Scanner(System.in);
    public static final DecimalFormat formatter = new DecimalFormat("#,###.##"); // Định dạng số dư
    public TaiKhoan getTaiKhoanDangNhap() {
        return taiKhoanDangNhap;
    }

    public HashMap<String, TaiKhoan> getDanhSachTaiKhoan() {
        return danhSachTaiKhoan;
    }

    public void setDanhSachTaiKhoan(HashMap<String, TaiKhoan> danhSachTaiKhoan) {
        this.danhSachTaiKhoan = danhSachTaiKhoan;
    }

    public HashMap<String, TaiKhoan> getDanhSachTaiKhoanSTK() {
        return danhSachTaiKhoanSTK;
    }

    public void setDanhSachTaiKhoanSTK(HashMap<String, TaiKhoan> danhSachTaiKhoanSTK) {
        this.danhSachTaiKhoanSTK = danhSachTaiKhoanSTK;
    }



    public void setTaiKhoanDangNhap(TaiKhoan taiKhoanDangNhap) {
        this.taiKhoanDangNhap = taiKhoanDangNhap;
    }

    public void themTaiKhoan(TaiKhoan taiKhoan) {
        // Kiểm tra xem số điện thoại đã tồn tại chưa
        if (danhSachTaiKhoan.containsKey(taiKhoan.soDienThoai)) {
            System.out.println("Số điện thoại đã được sử dụng cho tài khoản khác.");
            return;
        }
        // Kiểm tra xem số tài khoản đã tồn tại chưa
        if (danhSachTaiKhoanSTK.containsKey(taiKhoan.soTaiKhoan)) {
            System.out.println("Số tài khoản đã tồn tại.");
            return;
        }
        // Thêm tài khoản vào hai HashMap
        danhSachTaiKhoan.put(taiKhoan.soDienThoai, taiKhoan);
        danhSachTaiKhoanSTK.put(taiKhoan.soTaiKhoan, taiKhoan);
        DocFile.ghiFile1Argument(taiKhoan);
        System.out.println("Tạo tài khoản thành công!");
    }
    
    public void xoaTaiKhoan(String soTaiKhoan){
        TaiKhoan taiKhoan = danhSachTaiKhoanSTK.get(soTaiKhoan);
        if(taiKhoan != null){
            danhSachTaiKhoan.remove(taiKhoan.soDienThoai);
            danhSachTaiKhoanSTK.remove(soTaiKhoan);
            System.out.println("Xóa tài khoản thành công");
        }else{
            System.out.println("Số tài khoản không tồn tại");
        }
    }

    public TaiKhoan timTaiKhoan(String soTaiKhoan){
        return danhSachTaiKhoan.get(soTaiKhoan);
    } 

    public void dangNhap(String soDienThoai,String matKhau){
        TaiKhoan taiKhoan = danhSachTaiKhoan.get(soDienThoai);
        if(taiKhoan != null && taiKhoan.getMatKhau().equals(matKhau)){
            taiKhoanDangNhap = taiKhoan;
        }else{
            System.out.println("Tên đăng nhập hoặc mật khẩu không đúng.");
        }
    }

    public void chuyenTien(String tkNguon,String tkDich){
        if(danhSachTaiKhoanSTK.get(tkDich) == null){
        System.out.println("Không tìm thấy số tài khoản bạn muốn chuyển");
        return;
        }else{
            System.out.println("Nhập số tiền bạn muốn chuyển: ");
            double soTienChuyen = sc.nextDouble();
            if(soTienChuyen > 0 && soTienChuyen <= this.danhSachTaiKhoanSTK.get(tkNguon).getSoDu()){
                ((TaiKhoanThanhToan) this.danhSachTaiKhoanSTK.get(tkNguon)).chuyenTien(soTienChuyen);
                this.danhSachTaiKhoanSTK.get(tkNguon).themGiaoDich(" -"+ TaiKhoan.format(soTienChuyen) + " Bạn đã chuyển " + TaiKhoan.format(soTienChuyen) +" sang STK " + 
                this.danhSachTaiKhoanSTK.get(tkDich).soTaiKhoan + 
                " số dư của bạn là " + this.danhSachTaiKhoanSTK.get(tkNguon).getSoDuFormatted());
                ((TaiKhoanThanhToan) this.danhSachTaiKhoanSTK.get(tkDich)).nhanTien(soTienChuyen);
                this.danhSachTaiKhoanSTK.get(tkDich).themGiaoDich(" +" + TaiKhoan.format(soTienChuyen) + " bạn nhận được từ số tài khoản " + 
                this.danhSachTaiKhoanSTK.get(tkNguon).soTaiKhoan +" số dư của bạn là " +  this.danhSachTaiKhoanSTK.get(tkNguon).getSoDuFormatted());
                System.out.println("Bạn đã chuyển " + TaiKhoan.format(soTienChuyen) + " sang tài khoản " + tkDich + " tên tài khoản: " + this.danhSachTaiKhoanSTK.get(tkDich).chuTaiKhoan);
            }else{
                System.out.println("số tiền chuyển phải lớn hơn 0 và nhỏ hơn hoặc bằng số dư tài khoản nguồn!!");
            }
        }
    }
}
