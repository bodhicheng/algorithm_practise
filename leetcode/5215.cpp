#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static const int N = 30;
    const int xx[4] = {0,0,1,-1};
    const int yy[4] = {1,-1,0,0};

    vector<vector<int> > mp;
    int vl[N];
    bool vis[N];
    map<pair<int,int>,int> s;
    int dp[N];
    int dfs(int x) {
        //if(dp[x]) return dp[x];
        //cout << vl[x] << endl;
        vis[x] = 1;
        int ret = 0;
        for(int nx:mp[x]) {
            if(!vis[nx]) ret = max(ret,dfs(nx));
        }
        vis[x] = 0;
        return dp[x] = (ret + vl[x]);
    }
    int getMaximumGold(vector<vector<int>>& grid) {
        mp.resize(30);
        s.clear();
        int m = grid.size(),n = grid[0].size();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]!=0) {
                    int q;
                    pair<int,int> y = make_pair(i,j);
                    if(s.count(y)) q = s[y];
                    else {
                        int v = s.size();
                        s[y] = v;
                        q = v;
                        vl[q] = grid[i][j];
                        //cout << i << ' ' << j << ' ' << grid[i][j] <<endl;
                    }
                    for(int k=0;k<4;k++) {
                        int nx = i + xx[k], ny = j + yy[k];
                        if(nx<m && ny<n && nx>=0 && ny>=0 && grid[nx][ny]!=0) {
                            pair<int,int> x = make_pair(nx,ny);
                            int p;
                            if(s.count(x)) p = s[x];
                            else {
                                int v = s.size();
                                s[x] = v;
                                p = v;
                                vl[p] = grid[nx][ny];
                                //cout << nx << ' ' << ny << ' ' << grid[nx][ny] <<endl;
                            }
                            mp[q].push_back(p);
                            //mp[p].push_back(q);
                        }
                    }
                }
            }
        }
        int cnt = s.size();
        //cout << cnt << endl;
        int ans = 0;
        for(int i=0;i<cnt;i++) {
            memset(dp,0,sizeof dp);
            memset(vis,0,sizeof vis);
            ans = max(dfs(i),ans);
        }
        return ans;
    }
};
Solution x;
int main() {
    //vector<vector<int>> a = {{0,0,0,0,0,0,32,0,0,20},{0,0,2,0,0,0,0,40,0,32},{13,20,36,0,0,0,20,0,0,0},{0,31,27,0,19,0,0,25,18,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,18,0,6},{0,0,0,25,0,0,0,0,0,0},{0,0,0,21,0,30,0,0,0,0},{19,10,0,0,34,0,2,0,0,27},{0,0,0,0,0,34,0,0,0,0}};
    vector<vector<int>> a = {{0,0,0,22,0,24},{34,23,18,0,23,2},{11,39,20,12,0,0},{39,8,0,2,0,1},{19,32,26,20,20,30},{0,38,26,0,29,31}};
    cout << x.getMaximumGold(a) <<endl;
}
