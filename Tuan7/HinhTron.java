/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thuchanhtuan7;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class HinhTron {
    public Scanner sc=new Scanner(System.in);
private double banKinh;
    // Đảm bảo bán kính lớn hơn 0
    public void nhapBanKinh(double banKinh) {
        if (banKinh > 0) {
            this.banKinh = banKinh;
        } else {
            System.out.println("Ban kinh phai lon hon 0!");
        }
    }

    public double getBanKinh() {
        return banKinh;
    }

    // Tính chu vi
    public double tinhChuVi() {
        return 2 * Math.PI * banKinh;
    }

    // Tính diện tích
    public double tinhDienTich() {
        return Math.PI * banKinh * banKinh;
    }
}

