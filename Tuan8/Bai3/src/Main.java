public class Main {
    public static void main(String[] args) {
        TaiLieu[] danhSachTaiLieu = {
                new Sach("S01", "Java cơ bản", 2020, "Nguyen Van A"),
                new TapChi("T01", "Khoa học máy tính", 2021, 12),
                new Bao("B01", "Báo tuổi trẻ", 2023, "23/10/2023")
        };

        for (TaiLieu tl : danhSachTaiLieu) {
            System.out.println("Tài liệu: " + tl.tenTaiLieu);
        }
    }
}
