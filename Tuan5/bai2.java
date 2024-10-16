import java.util.Scanner;

public class bai2 {
    public static void daoNguocMang(int[] a,int[] mangDaoNguoc, int n){
        int i;
        int j = n - 1;
        for(i = 0; i < n;i++){
            mangDaoNguoc[j] = a[i];
            j--; 
        }
    }
    public static void main(String[] args) {
        int i,n;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so luong phan tu cua mang: ");
        n = sc.nextInt();
        int[] a = new int[n];
        int[] mangDaoNguoc = new int[n];
        
        bai1.nhapMang(a, n);
        System.out.println("danh sach mang la");
        bai1.xuatMang(a, n);

        daoNguocMang(a, mangDaoNguoc, n);
        System.out.println("\nmang sau khi dao nguoc la: ");
        bai1.xuatMang(mangDaoNguoc, n);
    }
}
