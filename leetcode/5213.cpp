#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int minCostToMoveChips(vector<int>& chips) {
        int a = 0,b = 0;
        for(int x:chips) if(x&1) a++;else b++;
        return min(a,b);
    }
};
int main() {

}
