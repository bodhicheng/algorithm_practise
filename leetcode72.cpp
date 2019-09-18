#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int minDistance(string word1, string word2) {
        int n = word1.length(),m = word2.length();
        if(n==0||m==0) return max(n,m);
        int dp[n][m];
        dp[0][0] = word1[0] != word2[0];
        for(int i=1;i<m;i++) dp[0][i] = max(dp[0][i-1] + (int)(word1[0]!=word2[i]),i);
        for(int i=1;i<n;i++) {
            dp[i][0] = max(dp[i-1][0] + (int)(word1[i]!=word2[0]),i);
            for(int j=1;j<m;j++) {
                if(word1[i]==word2[j]) dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = min(dp[i][j-1],dp[i-1][j]) + 1;
                    dp[i][j] = min(dp[i][j],dp[i-1][j-1] + 1);
                }
            }
        }
        return dp[n-1][m-1];
    }
};
int main() {
    Solution x;
    cout << x.minDistance("intention","execution") << endl;;
    return 0;
}
