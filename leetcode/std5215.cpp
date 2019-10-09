#include <bits/stdc++.h>
using namespace std;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

class Solution {
public:
    int n, m;
    vector<vector<int>> g, u;
    int ret;

    void dfs(int x, int y, int s)
    {
        if (s > ret) ret = s;
        u[x][y] = 1;
        for (int k = 0; k < 4; ++ k)
        {
            int tx = x+dx[k], ty = y+dy[k];
            if (0 <= tx && tx < n && 0 <= ty && ty < m && !u[tx][ty] && g[tx][ty])
                dfs(tx, ty, s+g[tx][ty]);
        }
        u[x][y] = 0;
    }

    int getMaximumGold(vector<vector<int>>& grid) {
        g = grid;
        n = g.size();
        m = g[0].size();
        u = vector<vector<int>>(n, vector<int>(m));
        ret = 0;
        for (int i = 0; i < n; ++ i)
            for (int j = 0; j < m; ++ j)
                if (g[i][j])
                {
                    dfs(i, j, g[i][j]);
                }
        return ret;
    }
};
Solution x;
int main() {
    //vector<vector<int>> a = {{0,0,0,0,0,0,32,0,0,20},{0,0,2,0,0,0,0,40,0,32},{13,20,36,0,0,0,20,0,0,0},{0,31,27,0,19,0,0,25,18,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,18,0,6},{0,0,0,25,0,0,0,0,0,0},{0,0,0,21,0,30,0,0,0,0},{19,10,0,0,34,0,2,0,0,27},{0,0,0,0,0,34,0,0,0,0}};
    vector<vector<int>> a = {{0,0,0,22,0,24},{34,23,18,0,23,2},{11,39,20,12,0,0},{39,8,0,2,0,1},{19,32,26,20,20,30},{0,38,26,0,29,31}};
    cout << x.getMaximumGold(a) <<endl;
}
