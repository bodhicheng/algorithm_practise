const int MAXN = 30010;

vector<int> v[MAXN];
int deg[MAXN];

void clear(int n)
{
    for (int i = 0; i < n; ++ i)
    {
        v[i].clear();
        deg[i] = 0;
    }
}

void addedge(int x, int y)
{
    v[x].push_back(y);
    deg[y] ++;
}

int head, tail, Q[MAXN];

bool topsort(int n) {
    head = 0;
    tail = -1;
    for (int i = 0; i < n; ++ i)
        if (!deg[i]) {
            Q[++ tail] = i;
        }
    while (head <= tail) {
        int x = Q[head ++];
        for (auto y : v[x])
            if (!-- deg[y]) Q[++ tail] = y;
    }
    return tail == n-1;
}

class Solution {
public:
    vector<int> sortItems(int n, int m, vector<int>& group, vector<vector<int>>& beforeItems) {

        clear(n);
        for (int i = 0; i < n; ++ i) {
            for (auto x : beforeItems[i]) {
                addedge(x, i);
            }
        }
        if (!topsort(n)) return {};

        int tmp_m = m;

        for (int i = 0; i < n; ++ i) {
            if (group[i] == -1) {
                group[i] = m ++;
            }
        }

        vector<vector<int>> v(m);
        for (int i = 0; i < n; ++ i) v[group[Q[i]]].push_back(Q[i]);

        clear(m);
        for (int i = 0; i < n; ++ i) {
            for (auto x : beforeItems[i]) {
                if (group[x] == group[i]) continue;
                addedge(group[x], group[i]);
            }
        }
        if (!topsort(m)) return {};

        vector<int> ret;
        for (int i = 0; i < m; ++ i) {
            for (auto x : v[Q[i]]) ret.push_back(x);
        }
        return ret;
    }
};
