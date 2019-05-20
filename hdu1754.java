import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Character.isDigit;

public class Main {
    static final int N = 200010;
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out,false);
    static int []treel = new int[N*4],treer = new int[N*4],treemx = new int[N*4];
    static int[] a = new int[N];
    static void pushup(int root) {
        int ls = root<<1; int rs = ls|1;
        treemx[root] = Math.max(treemx[ls] , treemx[rs]);
    }
    static void build(int root,int l,int r) {
        treel[root] = l; treer[root] = r;
        if(l==r) {
            treemx[root] = a[l];
            return ;
        }
        int ls = root<<1; int rs = ls|1; int mid = (l+r)/2;
        build(ls,l,mid);
        build(rs,mid+1,r);
        pushup(root);
    }
    static int querymax(int root,int l,int r) {
        if(l<=treel[root] && r>=treer[root]) {
            return treemx[root];
        }
        int ls = root<<1; int rs = ls|1; int mid = (treel[root]+treer[root])/2;
        int ret = Integer.MIN_VALUE;
        if(l<=mid) ret = querymax(ls,l,r);
        if(r>mid) ret = Math.max(ret,querymax(rs,l,r));
        return ret;
    }
    static void modify(int root,int p,int s) {
        if(treel[root] == treer[root]) {
            treemx[root] = s;
            return ;
        }
        int ls = root<<1; int rs = ls|1; int mid = (treel[root]+treer[root])/2;
        if(p<=mid) modify(ls,p,s);
        else modify(rs,p,s);
        pushup(root);
    }
    static public void main(String args[]) throws IOException {
        while(sc.hasNextInt()) {
            int n = sc.nextInt(), q = sc.nextInt();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            build(1, 0, n - 1);
            for (int i = 0; i < q; i++) {
                String s = sc.next();
                int l = sc.nextInt() - 1, r = sc.nextInt();
                if (s.compareTo("Q")==0) out.println(querymax(1, l, r - 1));
                else modify(1, l, r);
            }
        }
        out.flush();
    }
}
