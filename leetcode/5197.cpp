#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        sort(arr.begin(),arr.end());
        int n = arr.size();
        int mn = 1e6 + 10;
        for(int i=0;i<n-1;i++) {
            mn = min(abs(arr[i+1]-arr[i]),mn);
        }
        vector<vector<int> > ans;
        for(int i=0;i<n-1;i++) {
            if(abs(arr[i+1]-arr[i])==mn) {
                vector<int> t = {arr[i],arr[i+1]};
                ans.push_back(t);
            }
        }
        return ans;
    }
};

int main() {

    return 0;
}
