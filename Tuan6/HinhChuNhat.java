class HinhChuNhat {
    private double chieuDai;
    private double chieuRong;

    // Constructor
    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    // Phương thức tính diện tích
    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }

    // Phương thức tính chu vi
    public double tinhChuVi() {
        return 2 * (chieuDai + chieuRong);
    }

    // Phương thức in kết quả
    public void hienThiKetQua() {
        System.out.println("Chiều dài: " + chieuDai);
        System.out.println("Chiều rộng: " + chieuRong);
        System.out.println("Diện tích: " + tinhDienTich());
        System.out.println("Chu vi: " + tinhChuVi());
    }

    // Main để thử nghiệm
    public static void main(String[] args) {
        HinhChuNhat hcn = new HinhChuNhat(5, 3);
        hcn.hienThiKetQua();
    }
}
