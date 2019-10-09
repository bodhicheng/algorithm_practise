#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
//     vector< vector<int> > a = {
//        {1,2,3},
//        {2,3,4}
//    };
    typedef long long ll;
    vector< vector<int> > a = {
        {1},
        {0,2},
        {0,1,3,4},
        {2,4},
        {0}
    };
    static const int N = 1e4;
    static const ll M = 1e9 + 7;
    ll dp[5][N*2 + 10];
    ll dfs(int c,int x) {
        if(dp[c][x]!=0) return dp[c][x];
        if(x==0) return dp[c][x];
        ll ret = 0;
        for(int v:a[c]) ret += dfs(v,x-1);
        ret %= M;
        return dp[c][x] = ret;
    }
    int countVowelPermutation(int n) {
        for(int i=0;i<5;i++) dp[i][0] = 1;
        ll ans = 0LL;
        for(int i=0;i<5;i++) ans += dfs(i,n-1);
        return ans%M;
    }
};
Solution x;
int main () {
    cout << x.countVowelPermutation(20000) << endl;
}
