class Chim extends DongVat {
    public Chim(String ten, int tuoi) {
        super(ten, tuoi);
    }

    @Override
    public void tiengKeu() {
        System.out.println(ten + " kêu: Chip chip");
    }
}
