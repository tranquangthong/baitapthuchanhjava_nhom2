import java.util.Scanner;
   
public class bai4 {
    public static int phanTuXuatHienNhietNhat(int[] a,int[] luuKetQua,int n){
        int i,j,dem,max,vt;
        vt = 0;
        dem = 1;
        for(i = 0; i < n; i++){
            for(j = i + 1; j <= n-1;j++){
                if(a[i] == a[j])
                    dem++;
            }
            luuKetQua[0] = dem;
        }
        max = a[0];
        for(i = 0; i < n;i++)
            if(max < luuKetQua[i]){
                max = luuKetQua[i];
                vt = i;
            }
        return a[vt];
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so luong phan tu cua mang: ");
        n = sc.nextInt();
        int[] a = new int[n];
        int[] luuKetQua = new int[n];
        bai1.nhapMang(a, n);
        System.out.println("danh sach mang la:");
        bai1.xuatMang(a, n);

        int u = phanTuXuatHienNhietNhat(a, luuKetQua, n);
        System.out.println("\nphan tu xuat hien nhieu nhat la " + u);
    }
}
