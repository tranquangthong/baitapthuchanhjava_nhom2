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
                    scanner.nextLine();
                    user.addAccount(new TaiKhoanTietKiem(soTkTietKiem, soDuTietKiem));
                    System.out.println("Tạo Tài Khoản Tiết Kiệm thành công!");
                }
                case 2 -> {
                    System.out.print("Số tài khoản: ");
                    String soTkThanhToan = scanner.nextLine();
                    System.out.print("Số dư ban đầu: ");
                    double soDuThanhToan = scanner.nextDouble();
                    scanner.nextLine();
                    user.addAccount(new TaiKhoanThanhToan(soTkThanhToan, soDuThanhToan));
                    System.out.println("Tạo Tài Khoản Thanh Toán thành công!");
                }
                case 3 -> user.getAccounts().forEach(tk ->
                        System.out.println("Tài khoản: " + tk.getSoTaiKhoan() + ", Số dư: " + tk.getSoDu()));
                case 4 -> {
                    System.out.print("Nhập mật khẩu cũ: ");
                    String oldPassword = scanner.nextLine();
                    System.out.print("Nhập mật khẩu mới: ");
                    String newPassword = scanner.nextLine();
                    user.changePassword(oldPassword, newPassword);
                }
                case 5 -> {
                    System.out.print("Nhập mật khẩu rút tiền mới: ");
                    String newWithdrawPassword = scanner.nextLine();
                    user.setWithdrawPassword(newWithdrawPassword);
                }
                case 6 -> {
                    System.out.print("Nhập mật khẩu rút tiền cũ: ");
                    String oldWithdrawPassword = scanner.nextLine();
                    System.out.print("Nhập mật khẩu rút tiền mới: ");
                    String newWithdrawPassword = scanner.nextLine();
                    user.changeWithdrawPassword(oldWithdrawPassword, newWithdrawPassword);
                }
                case 7 -> {
                    System.out.print("Nhập số tài khoản: ");
                    String soTaiKhoanRutTien = scanner.nextLine();
                    System.out.print("Nhập số tiền cần rút: ");
                    double soTienRut = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Nhập mật khẩu rút tiền: ");
                    String withdrawPassword = scanner.nextLine();

                    TaiKhoan taiKhoanRut = user.getAccounts().stream()
                            .filter(tk -> tk.getSoTaiKhoan().equals(soTaiKhoanRutTien))
                            .findFirst()
                            .orElse(null);

                    if (taiKhoanRut != null) {
                        taiKhoanRut.rutTien(soTienRut, withdrawPassword, user);
                    } else {
                        System.out.println("Số tài khoản không tồn tại.");
                    }
                }
                case 8 -> {
                    System.out.print("Nhập số tài khoản: ");
                    String soTaiKhoanGuiTien = scanner.nextLine();
                    System.out.print("Nhập số tiền cần gửi: ");
                    double soTienGui = scanner.nextDouble();
                    scanner.nextLine();

                    TaiKhoan taiKhoanGui = user.getAccounts().stream()
                            .filter(tk -> tk.getSoTaiKhoan().equals(soTaiKhoanGuiTien))
                            .findFirst()
                            .orElse(null);

                    if (taiKhoanGui != null) {
                        taiKhoanGui.guiTien(soTienGui);
                    } else {
                        System.out.println("Số tài khoản không tồn tại.");
                    }
                }
                case 9 -> {
                    System.out.println("Đăng xuất.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
