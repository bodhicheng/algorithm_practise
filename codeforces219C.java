
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class hello {
    static StringBuilder s;
    static int n,k;
    static int[] lst1 ,lst0;
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out,true);
    static char getdif(int x) {
        int l = s.length();
        if(x==0) {
            return s.charAt(1)=='A'?'B':'A';
        }
        if(x==l-1) {
            return s.charAt(l-2)=='A'?'B':'A';
        }
        int c = (int)s.charAt(x+1)-(int)s.charAt(x-1);
        char m = (char)min(s.charAt(x-1),s.charAt(x+1));
        return abs(c)>1?(char)(m+1):(m=='A'?(char)(m+2):'A');
    }
    static void print(int x,int c) {
        //out.println(x+ " " + c + " " + (c==1?getdif(x):s.charAt(x)));
        if(c==1) s.setCharAt(x,getdif(x));//out.print(getdif(x));
        //else out.print(s.charAt(x));
        if(x==0) return ;
        if(c==1) print(x-1,lst1[x]);
        else print(x-1,lst0[x]);
    }
    public static void main(String[] args) {

        n = sc.nextInt();k = sc.nextInt();
        s = new StringBuilder(sc.next());
        if(n==1) {
            out.println(0);
            out.println(s);
            return ;
        }
        if(k==2) {
            int ansj = 0,anso = 0;
            for(int i=0;i<n;i++) {
                if((i&1)==1) {
                    if(s.charAt(i) == 'A') ansj++;
                    else anso++;
                } else {
                    if(s.charAt(i)== 'A') anso++;
                    else ansj++;
                }
            }
            if(ansj<anso) {
                out.println(ansj);
                for(int i=0;i<n;i++) {
                    if((i&1)==1) out.print('B');
                    else out.print('A');
                }
            } else {
                out.println(anso);
                for(int i=0;i<n;i++) out.print(((i&1)==1)?'A':'B');
            }
            out.println();
        } else {
            int dp[][] = new int [n][2];
            //String ans0 = "",ans1 = "";
            lst1 = new int[n];
            lst0 = new int[n];
            dp[0][0] = 0;dp[0][1] = 1;
            //ans0 += s.charAt(0);
            //ans1 += getdif(0);
            for(int i=1;i<n;i++) {
                //ans0 += s.charAt(i); ans1 += getdif(i);
                dp[i][1] = min(dp[i-1][1],dp[i-1][0]) + 1;
                if(dp[i-1][1]<=dp[i-1][0]) {
                    lst1[i] = 1;
                    //ans1 = ans1 + getdif(i);
                } else {
                    //ans1 = ans0 + getdif(i);
                    lst1[i] = 0;
                }
                if(s.charAt(i)==s.charAt(i-1)) {
                    dp[i][0] = dp[i-1][1];
                    lst0[i] = 1;
                    //ans0 = ans1 + s.charAt(i);
                } else {
                    dp[i][0] = min(dp[i-1][1],dp[i-1][0]);
                    if(dp[i-1][1]<dp[i-1][0]) {
                        lst0[i] = 1;
                        //ans0 = ans1 + s.charAt(i);
                    } else lst0[i] = 0;//ans0 = ans0 + s.charAt(i);
                }
                //out.println(dp[i][0] + " " + dp[i][1]);
            }
            out.println(min(dp[n-1][0],dp[n-1][1]));
            if(dp[n-1][0]<dp[n-1][1]) {
                print(n-1,0);
                //out.println(ans0);
            } else print(n-1,1);;//out.println(ans1);
            out.println(s);
        }

    }

}
