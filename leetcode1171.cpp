#include <bits/stdc++.h>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
class Solution {
public:
    ListNode* removeZeroSumSublists(ListNode* head) {
        map<int,ListNode*> mp;
        mp[0] = NULL;
        ListNode *x = new ListNode(head->val);
        x->next = head->next;
        int s = 0,cnt = 0;
        while(x!=NULL) {
            s += x->val;
            if(mp.count(s)) {
                if(s==0) head = x->next;
                else {
                    ListNode *p = mp[s];
                    p->next = x->next;
                }
            }
            else {
                mp[s] = x;
            }
            x = x->next;
        }
        return head;
    }
};
int main() {


    return 0;
}
