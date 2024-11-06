import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password; // Mật khẩu đăng nhập
    private String withdrawPassword; // Mật khẩu rút tiền
    private List<TaiKhoan> accounts;

    public User(String username, String password) {
        this.username = username;
        this.password = encryptPassword(password);
        this.accounts = new ArrayList<>();
        this.withdrawPassword = ""; // Mặc định không có mật khẩu rút tiền
    }

    private String encryptPassword(String password) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : password.toCharArray()) {
            encrypted.append((char) (c ^ 'A'));
        }
        return encrypted.toString();
    }

    public boolean verifyPassword(String password) {
        return encryptPassword(password).equals(this.password);
    }

    public boolean verifyWithdrawPassword(String password) {
        return encryptPassword(password).equals(this.withdrawPassword);
    }

    public void setWithdrawPassword(String password) {
        this.withdrawPassword = encryptPassword(password);
        System.out.println("Đặt mật khẩu rút tiền thành công.");
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (verifyPassword(oldPassword)) {
            if (!encryptPassword(newPassword).equals(this.password)) {
                this.password = encryptPassword(newPassword);
                System.out.println("Đổi mật khẩu đăng nhập thành công.");
            } else {
                System.out.println("Mật khẩu mới không được trùng với mật khẩu cũ.");
            }
        } else {
            System.out.println("Mật khẩu cũ không đúng.");
        }
    }

    public void changeWithdrawPassword(String oldWithdrawPassword, String newWithdrawPassword) {
        if (verifyWithdrawPassword(oldWithdrawPassword)) {
            if (!encryptPassword(newWithdrawPassword).equals(this.withdrawPassword)) {
                this.withdrawPassword = encryptPassword(newWithdrawPassword);
                System.out.println("Đổi mật khẩu rút tiền thành công.");
            } else {
                System.out.println("Mật khẩu mới không được trùng với mật khẩu cũ.");
            }
        } else {
            System.out.println("Mật khẩu rút tiền cũ không đúng.");
        }
    }

    public void addAccount(TaiKhoan account) {
        accounts.add(account);
    }

    public List<TaiKhoan> getAccounts() {
        return accounts;
    }

    public String getUsername() {
        return username;
    }
}
