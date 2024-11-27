public class TaiKhoanThanhToan extends TaiKhoan implements IGiaoDich{
    private double soTienDaVay = 0;
    private double hanMucThauChi;
    private TaiKhoanTietKiem taiKhoanTietKiem = null;
    
    public TaiKhoanThanhToan() {
        this.nhap();
    }   

    public TaiKhoanThanhToan(String soDienThoai,String soTK, String chuTK, double soDu, String matKhau, double hanMucThauChi,
            TaiKhoanTietKiem taiKhoanTietKiem) {
        super(soDienThoai,soTK, chuTK, soDu, matKhau);
        this.hanMucThauChi = hanMucThauChi;
        this.taiKhoanTietKiem = taiKhoanTietKiem;
    }

    public TaiKhoanTietKiem getTaiKhoanTietKiem() {
        return taiKhoanTietKiem;
    }

    public void setTaiKhoanTietKiem(TaiKhoanTietKiem taiKhoanTietKiem) {
        this.taiKhoanTietKiem = taiKhoanTietKiem;
    }

    public void nhap(){
        System.out.println("Nhập số điện thoại của bạn tạo: ");
        String sdt;
        do {
            sdt = sc.nextLine();
            if(kiemTraSoDienThoai(sdt)){
                this.soDienThoai = sdt;
            }else{
                System.out.println("Số điện thoại phải bắt đầu bằng 0 và có 10 số kể cả số 0");
            }
        } while (!kiemTraSoDienThoai(sdt));
        this.soTaiKhoan = 100000 + random.nextInt(900000)+"";
        System.out.println("Nhập tên chủ tài khoản: ");
        this.chuTaiKhoan = sc.nextLine();
        System.out.println("Nhập mật khẩu bạn muốn tạo: ");
        String mk;
        String kiemTraLaiMk;
        do{
            mk = sc.nextLine();
            boolean isDungSai = TaiKhoan.kiemTraMatKhau(mk);
            if(isDungSai){
                System.out.println("Nhập lại mật khẩu của bạn: ");
                kiemTraLaiMk = sc.nextLine();
                while(!kiemTraLaiMk.equals(mk)){
                    System.out.println("Bạn nhập sai vui lòng nhập lại!");
                    kiemTraLaiMk = sc.nextLine();
                }
                this.setMatKhau(mk);
            }else{
                inRaThongBaoMK(isDungSai);
            }
        }while(!kiemTraMatKhau(mk));
        
        
    }

    public void xuat(){
        System.out.println("-----Tài khoản thanh toán-----");
        System.out.println("| Số tài khoản: " + this.soTaiKhoan + " | Tên tài khoản: " + this.chuTaiKhoan + " | số dư của bạn: " + this.getSoDuFormatted() + " |");
        System.out.println("-----------------------------");
    }

    public void thanhToan(){
        double soTien = sc.nextDouble();
        System.out.println("Nhập số tiền bạn muốn thanh toán: ");
        if(soTien > 0 && soTien <= this.soDu){
            this.soDu = this.soDu - soTien;
            System.out.println("Bạn đã thanh toán " + formatter.format(soTien));
            System.out.println("Số dư của bạn là " + this.getSoDuFormatted());
            this.themGiaoDich(" -"+ TaiKhoan.format(soTien) + " Bạn đã thanh toán " + TaiKhoan.format(soTien) +" số dư của bạn là " + this.getSoDuFormatted());
        }else{
        System.out.println("Số tiền thanh toán phải lớn hơn 0 và nhỏ hơn số dư!!");
        }   
    }
        
    public void moTaiKhoanTietKiem(){
        if(this.taiKhoanTietKiem == null){
        this.taiKhoanTietKiem = new TaiKhoanTietKiem(this.soTaiKhoan+"-TK",this.chuTaiKhoan);
        System.out.println("Mở tài khoản tiết kiệm thành công!");
        this.taiKhoanTietKiem.xuat();
        }else{
            System.out.println("Bạn đã có tài khoản tiết kiệm rồi!");
        }
    }

    public void chuyenTien(double soTien) {
        if(soTien > 0 && soTien <= (this.soDu+this.hanMucThauChi)){
            this.soDu = this.soDu - soTien;
            System.out.println("Số dư của bạn là " + this.getSoDuFormatted());
        }else{
            System.out.println("Số tiền bạn muốn chuyển phải lớn hơn 0 và nhỏ hơn hoặc bằng số dư cộng với hạn mức thấu chi");
        }
    }

    public void chuyenTien2(TaiKhoan tkDich, double soTienChuyen){
        if(tkDich == null){
            System.out.println("Không tìm thấy số tài khoản bạn muốn chuyển");
            return;
            }else{
                System.out.println("Nhập số tiền bạn muốn chuyển: ");
                if(soTienChuyen > 0 && soTienChuyen <= this.soDu){
                    this.soDu -= soTienChuyen;
                    this.themGiaoDich(" -"+ TaiKhoan.format(soTienChuyen) + " Bạn đã chuyển " + TaiKhoan.format(soTienChuyen) +" sang STK " + tkDich.soTaiKhoan + " số dư của bạn là " + this.getSoDuFormatted());
                    tkDich.soDu += soTienChuyen;
                    tkDich.themGiaoDich(" +" + TaiKhoan.format(soTienChuyen) + " bạn nhận được từ số tài khoản " + this.soTaiKhoan + " số dư của bạn là " +  tkDich.getSoDuFormatted());
                    System.out.println(" -"+ TaiKhoan.format(soTienChuyen) + " Bạn đã chuyển " + TaiKhoan.format(soTienChuyen) +" sang STK " + tkDich.soTaiKhoan + " số dư của bạn là " + this.getSoDuFormatted());
                }else{
                    System.out.println("số tiền chuyển phải lớn hơn 0 và nhỏ hơn hoặc bằng số dư tài khoản nguồn!!");
                }
        }
    }

    public void nhanTien(double tienNhan){
        if(tienNhan > 0){
            this.soDu += tienNhan;
        } else {
            System.out.println("Số tiền gửi phải lớn hơn 0");
        }
    }

    public void guiTienTietKiem(double soTien){
        if(soTien > 0 && soTien < this.soDu){
            this.taiKhoanTietKiem.setsoDuTietKiem(soTien);
            this.soDu = this.soDu - soTien;
            System.out.println("Bạn đã gửi " + TaiKhoan.format(soTien) + " sang tài khoản tiết kiệm");
            this.taiKhoanTietKiem.themGiaoDich(" -" + TaiKhoan.format(soTien) + " bạn nhận được " + TaiKhoan.format(soTien) + " từ tài khoản thanh toán " + "số dư tiết kiệm của bạn là " + TaiKhoan.format(this.taiKhoanTietKiem.getsoDuTietKiem()));
            this.themGiaoDich(" -" + TaiKhoan.format(soTien) + " Bạn đã gửi " + TaiKhoan.format(soTien) + " sang tài khoản tiết kiệm" + " số dư của bạn là " + this.getSoDuFormatted());
        }else{
            System.out.println("Số tiền gửi > 0 và <= số dư tài khoản thanh toán");
        }
    }

    @Override
    public void rutTien(double soTien) {
        if(soTien > 0 && soTien <= (this.soDu+this.hanMucThauChi)){
            this.soDu = this.soDu - soTien;
            System.out.println("Số dư của bạn là " + this.getSoDuFormatted());
            this.themGiaoDich(" -"+ TaiKhoan.format(soTien) + " số tiền bạn rút" + " số dư của bạn là " + this.getSoDuFormatted());
        }else{
            System.out.println("Số tiền bạn muốn rút phải lớn hơn 0 và nhỏ hơn hoặc bằng số dư cộng với hạn mức thấu chi");
        }
    }

    @Override
    public void dangKyVay(double soTien, int kyHan) {
        // Giả định lãi suất 5%/tháng (có thể tuỳ chỉnh)
        final double laiSuatThang = 0.5;
        double tongTienPhaiTra;

        // Kiểm tra số tiền vay hợp lệ
        if (soTien <= 0) {
            System.out.println("❌ Số tiền vay phải lớn hơn 0.");
            return;
        }

        // Kiểm tra kỳ hạn hợp lệ
        if (kyHan <= 0) {
            System.out.println("❌ Kỳ hạn vay phải lớn hơn 0 tháng.");
            return;
        }

        // Tính tổng số tiền phải trả dựa trên lãi suất
        tongTienPhaiTra = soTien + (soTien * laiSuatThang * kyHan);

        // Cập nhật thông tin vay
        this.soTienDaVay += soTien;
        this.soDu += soTien; // Cộng tiền vay vào số dư

        // Thông báo chi tiết khoản vay
        System.out.println("✔ Bạn đã vay thành công " + TaiKhoan.format(soTien) + ".");
        System.out.println("📅 Kỳ hạn: " + kyHan + " tháng.");
        System.out.println("💰 Tổng tiền phải trả (bao gồm lãi suất): " + TaiKhoan.format(tongTienPhaiTra));
        System.out.println("💳 Số dư hiện tại: " + this.getSoDuFormatted());

        // Ghi vào lịch sử giao dịch
        this.themGiaoDich(" +" + TaiKhoan.format(soTien) + " - Bạn đã vay online trong " + kyHan + " tháng. Số dư hiện tại: " + this.getSoDuFormatted());
    }



    @Override
    public void traNo(double soTien) {
        if (soTien > 0 && soTien <= this.soDu && soTien <= this.soTienDaVay) {
            this.soDu -= soTien;
            this.soTienDaVay -= soTien;
            System.out.println("Bạn đã trả " + TaiKhoan.format(soTien) + " tiền vay. Số dư còn lại: " + this.getSoDuFormatted());
            this.themGiaoDich(" -" + TaiKhoan.format(soTien) + " Bạn đã trả nợ. Số dư hiện tại: " + this.getSoDuFormatted());
        } else {
            System.out.println("Số tiền trả phải lớn hơn 0, nhỏ hơn hoặc bằng số dư và số tiền đã vay.");
        }
    }

    public void xemNo() {
        System.out.println("===== THÔNG TIN NỢ =====");
        if (this.soTienDaVay > 0) {
            System.out.println("💳 Tổng số tiền đã vay: " + TaiKhoan.format(this.soTienDaVay));
            System.out.println("💰 Số dư hiện tại: " + this.getSoDuFormatted());
        } else {
            System.out.println("✔ Bạn không còn nợ khoản vay nào.");
        }
        System.out.println("========================");
    }
}       
