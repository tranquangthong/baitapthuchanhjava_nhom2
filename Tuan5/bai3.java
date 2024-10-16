import java.util.Scanner;

public class bai3 {
    public static void sapXepTang(int[] a, int n){
        int i,j,temp;
        for(i = 0; i < n-1; i++)
            for(j = i+1; j < n; j++)
            if(a[i] > a[j]){
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so luong phan tu cua mang: ");
        n = sc.nextInt();
        int[] a = new int[n];
        bai1.nhapMang(a, n);
        System.out.println("danh sach mang la:");
        bai1.xuatMang(a, n);
        sapXepTang(a, n);
        System.out.println("\nmang sau khi sap duoc sap xep:");
        bai1.xuatMang(a, n);
    }
}
