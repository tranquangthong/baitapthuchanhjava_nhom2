public class bai7 {
    private String maSV;
    private String ten;
    private double diemTB;

    public bai7(String maSV, String ten, double diemTB) {
        this.maSV = maSV;
        this.ten = ten;
        this.diemTB = diemTB;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getTen() {
        return ten;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return "MaSV: " + maSV + ", Ten: " + ten + ", DiemTB: " + diemTB;
    }
}

