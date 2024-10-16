import java.util.Scanner;

public class bai1 {
    static Scanner sc = new Scanner(System.in);

    public static void nhapMang(int[] a, int n){
        int i;
        for(i = 0; i < n; i++){
            System.out.printf("nhap vao a[%d] = ", i+1);
            a[i] = sc.nextInt();
        }
    }

    public static void xuatMang(int[] a, int n){
        int i;
        for(i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
    }
    public static void main(String[] args) {
        int i,n,dem;
        dem = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so luong phan tu cua mang: ");
        n = sc.nextInt();
        int[] a = new int[n];
       
        nhapMang(a, n);
        System.out.println("danh sach mang la");
        xuatMang(a, n);

        System.out.println();
        for(i = 0; i < n; i++){
            dem = dem + a[i];
        }

        System.out.println("tong cua mang la " + dem);
    }
}