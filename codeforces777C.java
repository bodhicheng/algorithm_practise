import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class practise {
    static final int N = 100010;
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out,true);
    static class segment implements Comparable<segment> {
        int l,r;
        segment() {
            l = r = -1;
        }
        segment(int a,int b) {
            l = a; r = b;
        }
        void next() {
            l = sc.nextInt();
            r = sc.nextInt();
        }
        public int compareTo(segment x) {
            if(x.l>l) return -1;
            else if(x.l<l) return 1;
            else if(x.r>r) return -1;
            else if(x.r<r) return 1;
            else return 0;
        }
    }
    static class segb implements Comparable<segb> {
        int l,r,id;
        segb(int a,int b,int c) {
            l = a;
            r = b;
            id = c;
        }
        segb() {
            l = r = id = -1;
        }
        public int compareTo(segb x) {
            if(r<x.r) return -1;
            else if(r>x.r) return 1;
            else if(l>x.l) return -1;
            else if(l<x.l) return 1;
            else return 0;
        }
    }
    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt(), cnt = 0;
        int[][]v = new int[n][m];
        int[] lst = new int[m];
        for(int i=0;i<m;i++) lst[i] = 0;
        List<segment> a = new ArrayList<segment>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                v[i][j] = sc.nextInt();
                if(i>0) {
                    if(v[i][j]<v[i-1][j]) {
                        a.add(new segment(lst[j],i-1));
                        lst[j] = i;
                    }
                }
            }
        }
        for(int j=0;j<m;j++) {
            a.add(new segment(lst[j],n-1));
        }
        Collections.sort(a);
        List<segb> b = new ArrayList<segb>();
        int k = sc.nextInt();
        String ans[] = new String[k];
        for(int i=0;i<k;i++) {
            int l = sc.nextInt()-1,r = sc.nextInt()-1;
            b.add(new segb(l,r,i));
        }
        Collections.sort(b);
        int na = a.size(),nb = b.size(),t = 0,w = 0;
        while(t<na && w<nb) {
            while(t<na && w<nb && a.get(t).r>=b.get(w).r) {
                if(a.get(t).l<=b.get(w).l) {
                    ans[b.get(w).id] = "Yes";
                    w++;
                } else {
                    ans[b.get(w).id] = "No";
                    w++;
                }
            }
            while(w<nb && t<na && a.get(t).r<b.get(w).r ) {
                t++;
            }
        }
        if(w<nb) while(w<nb) {ans[b.get(w).id] = "No";;w++;}
        for(int i=0;i<k;i++) {
            out.println(ans[i]);
        }
    }
}
/*
7 1
1 2 3 4 1 3 3
10
1 5
1 6
1 7
2 5
2 6
2 7
5 6
5 7
7 7
3 4
 */
