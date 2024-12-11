/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlytrungtam;

/**
 *
 * @author LENOVO
 */
public class PhongHoc {
    private String maPhong; // Ma phong hoc
    private int sucChua; // Suc chua cua phong hoc
    private boolean tinhTrang; // true: san sang, false: dang su dung

    // Constructor
    public PhongHoc(String maPhong, int sucChua) {
        this.maPhong = maPhong;
        this.sucChua = sucChua;
        this.tinhTrang = true; // Phong hoc mac dinh san sang
    }

    // Getter va Setter
    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    // Phuong thuc
    public void kiemTraTinhTrang() {
        System.out.println(tinhTrang ? "Phong hoc dang san sang." : "Phong hoc dang duoc su dung.");
    }

    public void datPhong() {
        if (tinhTrang) {
            tinhTrang = false;
            System.out.println("Phong hoc da duoc dat.");
        } else {
            System.out.println("Phong hoc khong the dat vi dang duoc su dung.");
        }
    }

    public void huyDatPhong() {
        if (!tinhTrang) {
            tinhTrang = true;
            System.out.println("Da huy dat phong hoc.");
        } else {
            System.out.println("Phong hoc khong duoc dat, khong the huy.");
        }
    }
}

