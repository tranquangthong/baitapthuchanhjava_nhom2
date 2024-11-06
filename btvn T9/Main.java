import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Tên đăng nhập: ");
                    String username = scanner.nextLine();
                    System.out.print("Mật khẩu: ");
                    String password = scanner.nextLine();
                    bank.register(username, password);
                }
                case 2 -> {
                    System.out.print("Tên đăng nhập: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Mật khẩu: ");
                    String loginPassword = scanner.nextLine();
                    User user = bank.login(loginUsername, loginPassword);

                    if (user != null) {
                        manageUserAccounts(scanner, user);
                    }
                }
                case 3 -> {
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void manageUserAccounts(Scanner scanner, User user) {
        while (true) {
            System.out.println("\n1. Tạo Tài Khoản Tiết Kiệm");
            System.out.println("2. Tạo Tài Khoản Thanh Toán");
            System.out.println("3. Xem Tài Khoản");
            System.out.println("4. Đổi mật khẩu đăng nhập");
            System.out.println("5. Đặt mật khẩu rút tiền");
            System.out.println("6. Đổi mật khẩu rút tiền");
            System.out.println("7. Rút tiền");
            System.out.println("8. Gửi tiền vào tài khoản");
            System.out.println("9. Đăng Xuất");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Số tài khoản: ");
                    String soTkTietKiem = scanner.nextLine();
                    System.out.print("Số dư ban đầu: ");
                    double soDuTietKiem = scanner.nextDouble();
                    user.addAccount(new TaiKhoanTietKiem(soTkTietKiem, soDuTietKiem));
                    System.out.println("Tạo Tài Khoản Tiết Kiệm thành công!");
                }
                case 2 -> {
                    System.out.print("Số tài khoản: ");
                    String soTkThanhToan = scanner.nextLine();
                    System.out.print("Số dư ban đầu: ");
                    double soDuThanhToan = scanner.nextDouble();
                    System.out.print("Hạn mức thấu chi: ");
                    double hanMucThauChi = scanner.nextDouble();
                    user.addAccount(new TaiKhoanThanhToan(soTkThanhToan, soDuThanhToan, hanMucThauChi));
                    System.out.println("Tạo Tài Khoản Thanh Toán thành công!");
                }
                case 3 -> {
                    System.out.println("Danh sách tài khoản:");
                    for (TaiKhoan tk : user.getAccounts()) {
                        System.out.println("Số tài khoản: " + tk.getSoTaiKhoan() + ", Số dư: " + tk.getSoDu());
                    }
                }
                case 4 -> {
                    System.out.print("Mật khẩu cũ: ");
                    String oldPassword = scanner.nextLine();
                    System.out.print("Mật khẩu mới: ");
                    String newPassword = scanner.nextLine();
                    user.changePassword(oldPassword, newPassword);
                }
                case 5 -> {
                    System.out.print("Mật khẩu rút tiền mới: ");
                    String withdrawPassword = scanner.nextLine();
                    user.setWithdrawPassword(withdrawPassword);
                }
                case 6 -> {
                    System.out.print("Mật khẩu rút tiền cũ: ");
                    String oldWithdrawPassword = scanner.nextLine();
                    System.out.print("Mật khẩu rút tiền mới: ");
                    String newWithdrawPassword = scanner.nextLine();
                    user.changeWithdrawPassword(oldWithdrawPassword, newWithdrawPassword);
                }
                case 7 -> {
                    System.out.print("Nhập số tài khoản để rút tiền: ");
                    String soTaiKhoan = scanner.nextLine();
                    TaiKhoan taiKhoan = user.getAccounts().stream()
                            .filter(tk -> tk.getSoTaiKhoan().equals(soTaiKhoan))
                            .findFirst()
                            .orElse(null);

                    if (taiKhoan != null) {
                        System.out.print("Số tiền muốn rút: ");
                        double soTien = scanner.nextDouble();
                        scanner.nextLine(); // Đọc dòng mới
                        System.out.print("Mật khẩu rút tiền: ");
                        String withdrawPassword = scanner.nextLine();
                        taiKhoan.rutTien(soTien, withdrawPassword, user);
                    } else {
                        System.out.println("Tài khoản không tồn tại.");
                    }
                }
                case 8 -> {
                    System.out.print("Nhập số tài khoản để gửi tiền: ");
                    String soTaiKhoan = scanner.nextLine();
                    TaiKhoan taiKhoan = user.getAccounts().stream()
                            .filter(tk -> tk.getSoTaiKhoan().equals(soTaiKhoan))
                            .findFirst()
                            .orElse(null);

                    if (taiKhoan != null) {
                        System.out.print("Số tiền muốn gửi: ");
                        double soTien = scanner.nextDouble();
                        taiKhoan.guiTien(soTien);
                    } else {
                        System.out.println("Tài khoản không tồn tại.");
                    }
                }
                case 9 -> {
                    System.out.println("Đăng xuất thành công.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
