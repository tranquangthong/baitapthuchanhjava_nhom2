package Tuan7;

import java.util.Scanner;

public class TK_ThanhToan extends TaiKhoanNH{

    public TK_ThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
    }
    public TK_ThanhToan() { super(); }

// Kiểm tra số dư
    public void kiemTraSoDu(String matKhau) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mat khau: ");
        String MK = sc.nextLine();

        if (!matKhau.equals(MK)) {
            System.out.println("Mau khau khong dung. Khong the kiem tra so du");
            return;
        }
        System.out.println("So du hien tai: " + super.soDu);
    }
// End kiểm tra số dư

// Gửi tiền
    public double guiTien(String matKhau, double soDu) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mat khau: ");
        String MK = sc.nextLine();

        if (!matKhau.equals(MK)) {
            System.out.println("Mat khau khong dung. Khong the thuc hien thao tac gui tien.");
            return soDu;
        }
        System.out.print("Nhap so tien muon gui: ");
        double soTienGui = sc.nextDouble();
        if (soTienGui > 0) {
            soDu += soTienGui;
            System.out.println("Da gui: " + soTienGui + ". So du hien tai: " + soDu);
        } 
        else
            System.out.println("So tien gui phai lon hon 0.");
        
        return soDu;
    }
// End gửi tiền

// Chuyển tiền
    public void chuyenTien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tai khoan muon chuyen: ");
        String STK = sc.nextLine();

        if(STK.equals(super.soTaiKhoan))
        {
            System.out.println("Khong the chuyen tien toi chinh minh.");
            return;
        }

        while (true) {
            System.out.print("Nhap so tien muon chuyen: ");
            double soTienChuyen = sc.nextDouble();
            sc.nextLine();

            if(soTienChuyen <= 0)
                System.out.println("So tien chuyen phai lon hon 0. Vui long nhap lai");
            
            else if(soTienChuyen > super.soDu)
            {
                System.out.println("So du khong du de chuyen tien.");
                return;
            }

            else {
                System.out.print("Nhap mat khau: ");
                String MK = sc.nextLine();
            
                if(!super.matKhau.equals(MK))
                    System.out.println("Mat khau khong dung. Khong the thuc hien thao tac chuyen tien.");

                else {
                    super.soDu -= soTienChuyen;
                    System.out.println("Da chuyen tien thanh cong. So du hien tai: " + super.soDu);
                }
                return;
            }  
        }
    }
// End chuyển tiền

// Rút tiền
    public double rutTien(String matKhau, double soDu)
    {
        double hanMucThauChi = 500000000;
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

            if (soTienRut > 0 && soTienRut <= hanMucThauChi) {
                soDu -= soTienRut;
                System.out.println("Da rut: " + soTienRut + ". So du hien tai: " + soDu);
                return soDu;
            }
        
            else if (soTienRut > hanMucThauChi) {
                System.out.println("Khong duoc rut vuot qua han muc thau chi.");
                return soDu;
            }
            else
                System.out.println("So tien rut phai lon hon 0. Vui long nhap lai");
        }
    }
// End rút tiền
}
