import java.util.regex.Pattern;

class DangKy {
    public static boolean kiemTraMatKhauHopLe(String matKhau) {
        return matKhau.length() >= 8 &&
                Pattern.compile("[A-Z]").matcher(matKhau).find() &&
                Pattern.compile("[a-z]").matcher(matKhau).find() &&
                Pattern.compile("[0-9]").matcher(matKhau).find() &&
                Pattern.compile("[^a-zA-Z0-9]").matcher(matKhau).find();
    }

    public static boolean kiemTraSoDienThoaiHopLe(String soDienThoai) {
        return soDienThoai.matches("\\d{10,11}");
    }
}
