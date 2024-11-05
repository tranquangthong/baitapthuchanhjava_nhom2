/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan6_tlthdt;

/**
 *
 * @author Hi
 */
public class TaiKhoanTietKiem extends TaiKhoan {
    private double laiSuat;

    public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double laiSuat) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.laiSuat = laiSuat;
    }
    
    // Phương thức tính lãi dựa trên số tháng
    public void tinhLai(int soThang) {
        double tienLai = this.soDu * laiSuat * soThang / 12;
        setSoDu(this.soDu + tienLai);
        System.out.println("Tinh lai thanh cong !! Tien lai : " + tienLai + ", So du moi : " + this.soDu);
    }
    @Override
    public void rutTien() {
        boolean giaoDichThanhCong = false;
        do{
        System.out.println("Nhap so tien can rut :");
        double soTien = sc.nextDouble();
        if (soTien > 0 && soTien <= this.soDu) {
            this.soDu -= soTien;
            System.out.println("Rut tien thanh cong !! So du hien tai : " + this.soDu );
            giaoDichThanhCong = true;
        } else {
            System.out.println("So tien rut khong hop le hoac so du khong du .");
        }
        }while(!giaoDichThanhCong);
    }
    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

  
}
