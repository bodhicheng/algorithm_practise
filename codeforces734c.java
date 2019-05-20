import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class practise {
    static final int N = 200010;
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out,true);

    static public void main(String args[]) {
        int n = sc.nextInt(),m = sc.nextInt(),k = sc.nextInt();
        int x = sc.nextInt(),s = sc.nextInt();
        int[] a = new int[N],b = new int [N];
        List<spell> A = new ArrayList<spell>();
        List<spell> B = new ArrayList<spell>();
        for(int i=0;i<m;i++) {
            a[i] = sc.nextInt();
        }
        for(int i=0;i<m;i++) {
            b[i] = sc.nextInt();
            A.add(new spell(a[i],b[i]));
        }
        for(int i=0;i<k;i++) {
            a[i] = sc.nextInt();
        }
        for(int i=0;i<k;i++) {
           b[i] = sc.nextInt();
           B.add(new spell(a[i],b[i]));
        }
        Collections.sort(A); Collections.sort(B);
        int mxc[] = new int[k];
        mxc[0] = B.get(0).a;
        for(int i=1;i<k;i++) {
            mxc[i] = Math.max(B.get(i).a,mxc[i]);
        }
        int r = 0;
        long ans = Long.MAX_VALUE;
        while(r<k && B.get(r).b<=s) r++;
        if(r>0) {
            ans = Math.min(ans,Math.max(0L,(long)x*(n-mxc[r-1])));
        } else {
            ans = Math.min(ans,(long)x*n);
        }
        --r;
        for(int i=0;i<m;i++) {
            spell pot = A.get(i);
            if(pot.b>s) break;
            int l = s - pot.b;
            while(r>=0 && B.get(r).b>l) {
                --r;
            }
            if(r>=0) {
                ans = Math.min(ans,Math.max(0L,(long)pot.a*(n-mxc[r])));
            } else {
                ans = Math.min(ans,(long)pot.a*n);
            }
        }
        out.println(ans);
    }
}
class spell implements Comparable<spell>{
    int a,b;
    spell() {}
    spell(int _a,int _b) {
        a = _a; b = _b;
    }
    public int compareTo(spell x) {
        if(b == x.b) return 0;
        else return b<x.b?-1:1;
    }
}
