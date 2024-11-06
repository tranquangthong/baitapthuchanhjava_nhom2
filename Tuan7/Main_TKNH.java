package Tuan7;

import java.util.Scanner;

public class Main_TKNH {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaiKhoanNH TKNH_TK = new TK_TietKiem();
        TaiKhoanNH TKNH_TT = new TK_ThanhToan();
        
        TKNH_TT.nhap();
        TKNH_TT.xuat();

        while (true) {
            System.out.println("\n Vui long chon mot trong cac thao tac duoi day :");
            System.out.println("1. Gui tien vao tai khoan thanh toan hoac gui tiet kiem");
            System.out.println("2. Rut tien tu tai khoan thanh toan hoac tai khoan tiet kiem");
            System.out.println("3. Kiem tra so du cua tai khoan thanh toan hoac tai khoan tiet kiem");
            System.out.println("4. Thay doi mat khau");
            System.out.println("5. Chuyen tien");
            System.out.println("6. Thoat");
            System.out.print("Chon thao tac muon kiem tra: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    do {
                        System.out.println("Gui tien cho tai khoan ngan hang hay tai khoan tiet kiem:");
                        System.out.println("1. Tai khoan ngan hang");
                        System.out.println("2. Tai khoan tiet kiem");
                        System.out.print("Nhap lua chon: ");
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                TKNH_TT.soDu = TKNH_TT.guiTien(TKNH_TT.matKhau, TKNH_TT.soDu);
                                break;
                            case 2:
                                TKNH_TT.soDu = TKNH_TK.guiTien(TKNH_TT.matKhau, TKNH_TT.soDu);
                                break;
                        
                            default:
                                System.out.println( "Lua chon khong hop le.");
                        }
                    }
                    while (choice != 1 && choice != 2);
                    
                    break;

                case 2:
                    do {
                        System.out.println("Vui long chon tai khoan muon rut tien:");
                        System.out.println("1. Rut tien tu tai khoan thanh toan");
                        System.out.println("2. Rut tien tu tai khoan tiet kiem");
                        System.out.print("Nhap lua chon: ");
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                TKNH_TT.soDu = TKNH_TT.rutTien(TKNH_TT.matKhau, TKNH_TT.soDu);
                                break;
                            case 2:
                                TKNH_TT.soDu = TKNH_TK.rutTien(TKNH_TT.matKhau, TKNH_TT.soDu);
                                break;
                            default:
                                System.out.println( "Lua chon khong hop le. Vui long chon lai.");
                        }
                    }
                    while (choice != 1 && choice != 2);
                    
                    break;

                case 3:
                    do {
                         System.out.println("Vui long chon tai khoan muon kiem tra:");
                        System.out.println("1. Kiem tra so du tai khoan tiet kiem");
                        System.out.println("2. Kiem tra so du tai khoan thanh toan");
                        System.out.print("Nhap lua chon: ");
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                TKNH_TK.kiemTraSoDu(TKNH_TT.matKhau);
                                break;
                            case 2:
                                TKNH_TT.kiemTraSoDu(TKNH_TT.matKhau);
                                break;
                            default:
                                System.out.println( "Lua chon khong hop le.");
                        }
                    }
                    while (choice != 1 && choice != 2);
                   
                    break;

                case 4:
                    TKNH_TT.doiMatKhau();
                    break;
            
                case 5:
                    TKNH_TT.chuyenTien();
                    break;

                case 6:
                    System.out.println("Thoat chuong trinh.");
                    sc.close();
                    return;

                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai");
            }
        }
    }
}