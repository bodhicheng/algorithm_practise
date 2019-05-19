import java.io.PrintWriter;
import java.util.Scanner;


public class practise {
    static final int N = 1024;
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out,true);
    static public void main(String args[]) {

        int n = sc.nextInt(), m = sc.nextInt();
        int [][] a = new int[n][m];
        int ans = 0,r = -1,c = -1;
        boolean f = false;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                a[i][j] = sc.nextInt();
                if(f==false && j!=0 && a[i][j]!=a[i][j-1]) {
                    r = i;c = j; f = true;
                }
            }
            ans ^= a[i][0];
        }
        if(ans!=0) {
            out.println("TAK");
            for(int i=0;i<n-1;i++) out.print("1 ");
            out.println(1);
        } else if(f) {
            out.println("TAK");
            for(int i=0;i<n-1;i++)
                if(i!=r) out.print("1 ");
                else out.print((c+1)+" ");
            if(r==n-1) out.println(c+1);
            else out.println(1);
        } else out.println("NIE");
    }

}
