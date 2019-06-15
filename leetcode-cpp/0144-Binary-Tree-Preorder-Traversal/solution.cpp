#include <iostream>
#include <vector>
#include <stack>
#include "../utils/TreeNode.h"

using namespace std;

class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        
        vector<int> res;
        if (root == NULL) {
            return res;
        }
        stack<TreeNode*> stack;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode* cur = stack.top();
            stack.pop();
            res.push_back(cur->val);
            if (cur->right != NULL) {
                stack.push(cur->right);
            }
            if (cur->left != NULL) {
                stack.push(cur->left);
            } 
        }

        return res;
    }
};

int main(void) {

    return 0;
}