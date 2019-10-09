#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    map<int,int> mp;
    int longestSubsequence(vector<int>& arr, int difference) {
        mp.clear();
        int n = arr.size();
        int dp[n],ans = 1;
        for(int i=0;i<n;i++) dp[i] = 1;
        mp[arr[0]] = 0;
        for(int i=1;i<n;i++) {
            int p,v = arr[i] - difference;
            if(mp.count(v)) {
                p = mp[v];
                dp[i] = dp[p] + 1;
            }
            ans = max(ans,dp[i]);
            mp[arr[i]] = i;
        }
        return ans;
    }
};

int main() {
    return 0;
}
