import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class practise {
    static final int N = 300010;
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out,true);

    static public void main(String args[]) {
        int n = sc.nextInt(),k = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++) a[i] = sc.nextInt();

        int cnt = a[0]^1,t = 0,w = 0,l=-1,r=-1;
        int ans = 0;
        if(cnt<=k) {
            l = r = 0;
            ans = 1;
        }
        while(w<n) {
            while(cnt<=k) {
                w++;
                if(w==n) break;
                if(a[w]==0) cnt++;
                if(cnt<=k) {
                    if(w-t+1>ans) {
                        l = t;
                        r = w;
                        ans = w-t+1;
                    }
                }
            }
            while(cnt>k && t<=w) {
                if(a[t]==0) cnt--;
                t++;
            }
        }
        out.println(ans);
        for(int i=0;i<n;i++) {
            if(i>=l&&i<=r) out.print("1");
            else out.print(a[i]);
            if(i!=n-1) out.print(" ");
        }
        out.println();
    }
}
