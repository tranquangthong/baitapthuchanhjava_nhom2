public class TaiKhoanTietKiem extends TaiKhoan{
    private String maSoTaiKhoanTietKiem;
    private double soDuTietKiem;
    private double laiSuatTheoNam;

    public TaiKhoanTietKiem() {
        this.nhap();
    }

    public TaiKhoanTietKiem(String soDienThoai,String soTK, String chuTK, double soDu, String matKhau, double soDuTietKiem,
            double laiSuatTheoNam) {
        super(soDienThoai,soTK, chuTK, soDu, matKhau);
        this.soDuTietKiem = soDuTietKiem;
        this.laiSuatTheoNam = laiSuatTheoNam;
    }

    public TaiKhoanTietKiem(String soTK, String chuTK) {
        super(soTK, chuTK);
    }

    public void nhap(){
        this.maSoTaiKhoanTietKiem = this.soTaiKhoan + "-TK";
        this.xuat();
    }

    public void xuat(){
        System.out.println("-----Tài khoản tiết kiệm-----");
        System.out.println("| Số tài khoản tiết kiệm: " + this.soTaiKhoan + " | Tên tài khoản : " + this.chuTaiKhoan + 
        " | Số dư tiết kiệm : " + TaiKhoan.format(this.soDuTietKiem));
        System.out.println("Số tài khoản tiết kiệm ");
        System.out.println("------------------------------");
    }

    public double getsoDuTietKiem() {
        return soDuTietKiem;
    }

    public void setsoDuTietKiem(double soDuTietKiem) {
        this.soDuTietKiem = this.soDuTietKiem + soDuTietKiem;
    }

    public double getLaiSuatTheoNam() {
        return laiSuatTheoNam;
    }

    public void setLaiSuatTheoNam(double laiSuat) {
        this.laiSuatTheoNam = laiSuat;
    }

    public void chuyenTienSangTKThanhToan(TaiKhoanThanhToan taiKhoanThanhToan, double tienChuyen){
            if(tienChuyen > 0 && tienChuyen <= this.soDuTietKiem){
                this.soDuTietKiem = this.soDuTietKiem - tienChuyen;
                taiKhoanThanhToan.soDu += tienChuyen;
                taiKhoanThanhToan.themGiaoDich(" +"+ TaiKhoan.format(tienChuyen) + " Bạn đã nhận được " + TaiKhoan.format(tienChuyen) +" từ tài khoản tiết kiệm");
                System.out.println("Số dư tiết kiệm của bạn là: " + TaiKhoan.format(this.soDuTietKiem));
                this.lichSuGiaoDich.add("Bạn đã chuyển " + TaiKhoan.format(tienChuyen) + " từ tài khoản tiết kiệm sang tài khoản thanh toán");
                this.themGiaoDich(" -"+TaiKhoan.format(tienChuyen) + " Bạn đã chuyển " + TaiKhoan.format(tienChuyen) + " từ tài khoản tiết kiệm sang tài khoản thanh toán" + "số dư tiết kiệm của bạn là " + TaiKhoan.format(this.soDuTietKiem));
            }else{
                System.out.println("Số tiền phải lớn hơn 0 và nhỏ hơn hoặc bằng số dư tiết kiệm");
            }
    }

    // public void tinhLaiSuat(){
    //     double lai = this.soDuTietKiem * (this.laiSuatTheoNam / 100);
    //     this.soDuTietKiem = this.soDuTietKiem + lai;
    //     System.out.println("Lãi suất được cộng vào là: " + lai);
    //     System.out.println("Số dư tiết kiệm sau khi tính lãi " + this.soDuTietKiem + "VNĐ");
    // }

    @Override
    public void rutTien(double soTien) {
        if(soTien > 0 && soTien <= this.soDuTietKiem){
            this.soDuTietKiem = this.soDuTietKiem - soTien;
            this.themGiaoDich(" -" + TaiKhoan.format(soTien) +" Bạn đã rút " + TaiKhoan.format(soTien) + " từ tài khoản tiết kiệm của mình" +" số dư của bạn là " + TaiKhoan.format(this.soDuTietKiem));
        }else{
            System.out.println("Số tiền bạn muốn rút phải lớn hơn 0 và nhỏ hơn hoặc bằng số dư tiết kiệm");
        }
    }

}
