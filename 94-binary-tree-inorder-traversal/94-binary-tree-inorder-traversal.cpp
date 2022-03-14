/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        TreeNode* curr = root;
        stack<TreeNode*> tree;
        while (curr || !tree.empty()) {
            while (curr) {
                tree.push(curr);
                curr = curr->left;
            }
            curr = tree.top();
            res.push_back(curr->val);
            tree.pop();
            curr = curr->right;
        }
        return res;
    }
};