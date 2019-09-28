/**
 * 将图中n个元素拓扑排序，结果存在Q中。
 * 其中deg[i]表示点i的入度，v[i]是一个vector，存放点i可以到达的点。
 */
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