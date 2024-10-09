/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanhtuan6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
class SinhVien {
    public static Scanner sc=new Scanner(System.in);
    private String maSV;
    private String ten;
    private String ngaySinh;
    private float DTB;
    public SinhVien(){
        
    }
    public void nhapThongTin(){
        System.out.print("Nhap ma sinh vien:");
        this.maSV=sc.nextLine();
        System.out.print("Nhap ten sinh vien:");
        this.ten=sc.nextLine();
        System.out.print("Nhap ngay sinh (dd/mm/yyyy):");
        this.ngaySinh=sc.nextLine();
        System.out.print("Nhap diem TB:");
        this.DTB=sc.nextFloat();
        sc.nextLine();//đọc kí tự xuống dòng
    }
    public void inThongTin(){
        System.out.println("Ma SV: "+this.maSV);
        System.out.println("Ten: "+this.ten);
        System.out.println("Ngay sinh: "+this.ngaySinh);
        System.out.println("Diem TB: "+this.DTB);
    }

    public float getDTB() {
        return DTB;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<SinhVien> danhSachSV=new ArrayList<>();
        System.out.println("Nhap so luong sinh vien:");
        int soLuong=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<soLuong;i++){
            System.out.println("Nhap thong tin sinh vien thu:"+(i+1)+":");
            SinhVien sv=new SinhVien();
            sv.nhapThongTin();
            danhSachSV.add(sv);
        }
        Collections.sort(danhSachSV, new Comparator<SinhVien>(){
            public int compare(SinhVien sv1, SinhVien sv2){
                return Float.compare(sv2.getDTB(),sv1.getDTB());
            }
        });
        System.out.print("\nDanh sach sinh vien sau khi sap xep theo diem trung binh giam dan la:");
        for(SinhVien sv:danhSachSV){
            sv.inThongTin();
            System.out.println("---------------");
        }
    }
}
