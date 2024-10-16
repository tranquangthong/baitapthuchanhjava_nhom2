import java.util.Scanner;

public class TaiKhoan {
    public Scanner sc = new Scanner(System.in);
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    private String matKhau;
   
    public TaiKhoan(String soTK,String chuTK,double soDu,String matKhau){
        this.soTaiKhoan=soTK;
        this.chuTaiKhoan=chuTK;
        this.soDu=soDu;
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

    public void guiTien(){
        double tienGui = 0;
        System.out.println("Nhap so tien can gui:");
        tienGui = sc.nextDouble();
        if(tienGui <= 0){
                System.out.println("so tien gui phai lon hon 0");
        } else {
        this.soDu += tienGui;
        }
        System.out.println("so du cua ban la " + this.getSoDu());
    }

    public void rutTien(){
        double tienRut = 0;
        System.out.println("Nhap so tien can rut:");
        tienRut = sc.nextDouble();
        if(tienRut <= 0 || tienRut > this.soDu){
                System.out.println("so tien rut phai lon hon 0 va nho hon so du");
        }else{
            this.soDu -= tienRut;
        }
        System.out.println("so du cua ban la " + this.getSoDu());
    }

    public void doiMatKhau() {
        String mkCu,mkMoi;
        System.out.println("Nhập mật khẩu cũ: ");
        mkCu = sc.nextLine();
        if (!this.matKhau.equals(mkCu)) {
            System.out.println("Mật khẩu cũ không đúng!");
            return;
        } else {
            System.out.println("Nhap mật khẩu mới: ");
            mkMoi = sc.nextLine();
            if(this.matKhau.equals(mkMoi)){
                System.out.println("Mật khẩu cũ không được trùng với mật khẩu mới");
                return;
            }
            this.matKhau = mkMoi;
            System.out.println("Đã thay đổi mật khẩu thành công.");
            System.out.println("mật khẩu mới của bạn là " + this.getMatKhau());
        } 
    }

}
