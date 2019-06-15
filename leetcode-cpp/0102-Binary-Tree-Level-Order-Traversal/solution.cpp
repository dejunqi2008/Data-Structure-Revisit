#include <iostream>
#include <vector>
#include <queue>
#include "../utils/TreeNode.h"

using namespace std;

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if (!root) return {};

        vector<vector<int>> res;
        queue<TreeNode*> queue;
        queue.push(root);

        while (!queue.empty()) {
            int n = queue.size();
            vector<int> tmp;
            for (int i = 0; i < n; i++) {
                
                TreeNode* cur = queue.front();
                queue.pop();
                
                tmp.push_back(cur->val);
                if (cur->left != NULL) {
                    queue.push(cur->left);
                }
                if (cur->right != NULL) {
                    queue.push(cur->right);
                }
            }
            res.push_back(tmp);
        }

        return res;
    }
};

int main(void) {

    return 0;
}
