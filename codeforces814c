
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class practise {
    static final int N = 300010;
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out,false);

    static public void main(String args[]) {
        int n = sc.nextInt();//k = sc.nextInt();
        String s = sc.next();
        int q = sc.nextInt();
        //out.println(n*26 + " " + q);
        if(n*26>q) {
            for (int i = 0; i < q; i++) {
                int k = sc.nextInt();
                String favor = sc.next();
                int cnt, t = 0, w = 0;
                int ans = 0;
                if (s.charAt(0) != favor.charAt(0)) {
                    cnt = 1;
                } else cnt = 0;
                if (cnt <= k) ans = 1;

                while (w < n) {
                    while (cnt <= k) {
                        w++;
                        if (w == n) break;
                        if (s.charAt(w) != favor.charAt(0)) cnt++;
                        if (cnt <= k) {
                            if (w - t + 1 > ans) {
                                ans = w - t + 1;
                            }
                        }
                    }
                    while (cnt > k && t <= w) {
                        if (s.charAt(t) != favor.charAt(0)) cnt--;
                        t++;
                    }
                }
                out.println(ans);
            }
        } else {
            //out.println("!!!");
            int num[] = new int[26];
            int Ans[][] = new int [n+1][26];
            for(int i=0;i<n;i++) {
                char x = s.charAt(i);
                num[x-'a']++;
            }
            for(int k=1;k<=n;k++) {
                for(int i=0;i<26;i++) {
                    if(n-num[i]<=k) Ans[k][i] = n;
                    else {
                        String favor = String.valueOf((char)('a'+i));
                        //out.println(k + " " + favor);
                        int cnt, t = 0, w = 0;
                        int ans = 0;
                        if (s.charAt(0) != favor.charAt(0)) {
                            cnt = 1;
                        } else cnt = 0;
                        if (cnt <= k) ans = 1;

                        while (w < n) {
                            while (cnt <= k) {
                                w++;
                                if (w == n) break;
                                if (s.charAt(w) != favor.charAt(0)) cnt++;
                                if (cnt <= k) {
                                    if (w - t + 1 > ans) {
                                        ans = w - t + 1;
                                    }
                                }
                            }
                            while (cnt > k && t <= w) {
                                if (s.charAt(t) != favor.charAt(0)) cnt--;
                                t++;
                            }
                        }
                        Ans[k][i] = ans;
                    }
                }
            }
            for(int i=0;i<q;i++) {
                int k = sc.nextInt();
                String favor = sc.next();
                out.println(Ans[k][favor.charAt(0)-'a']);
            }
        }
        out.flush();
    }
}
