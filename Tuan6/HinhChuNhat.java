
import java.util.Scanner;

public class HinhChuNhat {
    public Scanner sc=new Scanner(System.in);
    private int chieuDai;
    private int chieuRong;
    public HinhChuNhat(int chieuDai, int chieuRong){
        this.chieuDai=chieuDai;
        this.chieuRong=chieuRong;
    }
    public int chuVi(){
        return (this.chieuDai+this.chieuRong)*2;
    }
    public int dienTich(){
        return this.chieuDai*this.chieuRong;
    }
    
    public void inHCN(){
        System.out.println("Chieu dai hinh chu :"+this.chieuDai);
        System.out.println("Chieu rong hinh chu nhat :"+this.chieuRong);
        System.out.println("Chu vi hinh chu nhat la: "+this.chuVi());
        System.out.println("Dien tich hinh chu nhat la: "+this.dienTich());
    }
    public static void main(String[] args) {
        HinhChuNhat hcn=new HinhChuNhat(5,2);
        hcn.inHCN();
    }
}
