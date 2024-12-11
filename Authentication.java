/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlytrungtam;

public interface Authentication {
    boolean dangNhap(String id, String matKhau);
    void doiMatKhau(String matKhauCu, String matKhauMoi);
}

