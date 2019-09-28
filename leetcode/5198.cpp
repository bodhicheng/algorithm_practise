#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef unsigned long long ull;

class Solution {
public:
    ull lcm(ull a,ull b) {
        return a*b/__gcd(a,b);
    }
    ull lcm(ull a,ull b,ull c) {
        ull g = __gcd(a,b),v = a*b/g;
        return v*c/__gcd(v,c);
    }
    bool check(ull x,int &n,int &a,int &b,int &c) {
        ull v = x/a + x/b + x/c - x/lcm(a,b) - x/lcm(a,c) - x/lcm(b,c) + x/lcm(a,b,c);
        bool ret = (v>=n);
        //cout << x << ' ' << v << ' ' << n << ' ' << ret << endl;
        return ret;
    }
    int nthUglyNumber(int n, int a, int b, int c) {
        ull l = 0, r = 1e18+10,mid;
        while(l<r) {
            mid = (l+r)>>1;
            if(check(mid,n,a,b,c)) r = mid;
            else l = mid + 1;
        }
        return r;
    }
};

Solution x;
int main() {
    cout << x.nthUglyNumber(3,2,3,5) << endl;;
    cout << x.nthUglyNumber(4,2,3,4) << endl;;
    cout << x.nthUglyNumber(5,2,11,13) << endl;;
    cout << x.nthUglyNumber(1000000000,2,217983653,336916467) << endl;;
    //cout << LONG_MAX << endl;
}
