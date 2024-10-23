public class Main {
    public static void main(String[] args) {
        DongVat[] danhSachDongVat = {
                new Meo("Mèo", 2),
                new Cho("Chó", 3),
                new Chim("Chim", 1)
        };

        for (DongVat dv : danhSachDongVat) {
            dv.tiengKeu();
        }
    }
}

