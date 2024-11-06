package Tuan7;

import java.util.Scanner;

public class TK_TietKiem extends TaiKhoanNH{
    private double tienLai;
    private double TKTietKiem = 0;

    public TK_TietKiem(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double tienLai, double TKTietKiem) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.TKTietKiem = TKTietKiem;
        this.tienLai = tienLai;
    }

    public TK_TietKiem() { super(); }

    public double getTKTietKiem() { return TKTietKiem;  }

    public void setTKTietKiem(double TKTietKiem) { this.TKTietKiem = TKTietKiem; }

// Kiểm tra số dư
    public void kiemTraSoDu(String matKhau) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mat khau: ");
        String MK = sc.nextLine();

        if (!matKhau.equals(MK)) {
            System.out.println("Mau khau khong dung. Khong the kiem tra so du");
            return;
        }
        System.out.println("So du hien tai: " + TKTietKiem);
    }
// End kiểm tra số dư

//Gửi tiền 
    public double guiTien(String matKhau, double soDu) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mat khau: ");
        String MK = sc.nextLine();

        if (!matKhau.equals(MK)) {
            System.out.println("Mat khau khong dung. Khong the thuc hien thao tac gui tiet kiem.");
            return soDu;
        }

        System.out.print("Nhap so tien muon gui tiet kiem: ");
        double tienGuiTK = sc.nextDouble();
    
        if(tienGuiTK <= 0)
        {
            System.out.println( "So tien gui phai lon hon 0.");
            return soDu;
        }
    
        if(tienGuiTK > soDu)
        {
            System.out.println( "So du khong du de gui tiet kiem.");
            return soDu;
        }
        
        while (true) {
            System.out.println("Gui tiet kiem co ky han hay khong ky han:");
            System.out.println("1. Ky han");
            System.out.println("2. Khong ky han");
            System.out.print("Nhap lua chon: ");
            int luaChon = sc.nextInt();
            switch (luaChon) {
                case 1:
                    double laiSuat = 7;
                    while (true) {
                        System.out.print("Nhap thoi gian gui (tinh theo thang): ");
                        int thoiGianGui = sc.nextInt();

                        if (thoiGianGui <= 0)
                            System.out.println("Thoi gian gui phai lon hon 0. Vui long thuc hien lai");
                        else {
                            this.tienLai = (laiSuat / 100) / 12 * tienGuiTK * thoiGianGui;
                            this.TKTietKiem = tienGuiTK + this.tienLai;
                            soDu -= tienGuiTK;
                            System.out.println("Da gui tiet kiem. So du hien tai: " + soDu);
                            System.out.println("So du tiet kiem: " + this.TKTietKiem);
                            return soDu;
                        }
                    }
                     
                case 2:
                    laiSuat = 5;
                    this.tienLai = laiSuat/100 * tienGuiTK;
                    this.TKTietKiem = tienGuiTK + this.tienLai;
                    soDu -= tienGuiTK;
                    System.out.println("Da gui tiet kiem. So du hien tai: " + soDu);
                    System.out.println("So du tiet kiem: " + this.TKTietKiem);
                    return soDu;

                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }        
        }
    }
// End gửi tiền

// Rút tiền
    public double rutTien(String matKhau, double soDu) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mat khau: ");
        String MK = sc.nextLine();
        
        if (!matKhau.equals(MK)) {
            System.out.println("Mat khau khong dung. Khong the thuc hien thao tac rut tien.");
            return soDu;
        }
        
        while (true) {
            System.out.print("Nhap so tien muon rut: ");
            double soTienRut = sc.nextDouble();

            if (soTienRut > 0 && soTienRut <= this.TKTietKiem) {
                this.TKTietKiem -= soTienRut;
                System.out.println("Da rut: " + soTienRut + ". So du hien tai: " + this.TKTietKiem);
                return soDu;
            }
        
            else if (soTienRut > this.TKTietKiem) {
                System.out.println("Khong du so du de rut.");
                return soDu;
            }

            else
                System.out.println("So tien rut phai lon hon 0. Vui long nhap lai");
        } 
    }
// End rút tiền
}
