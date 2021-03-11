官方题解的思路 + 宽度优先搜索
```
class Solution {
public:
    int widthOfBinaryTree(TreeNode* root) {
        int maxWidth = 0;
        root->val = 1;

        queue<TreeNode*> q;
        q.push(root);

        while (q.size())
        {   //更新最大长度
            maxWidth = max(maxWidth, q.back()->val - q.front()->val + 1);
            int size = q.size();
            int tmp = q.front()->val - 1;           //为了避免数字过大，让val每次基于q.front的编号做缩小

            while (size -- )
            {
                auto t = q.front();
                q.pop();

                t->val -= tmp;
                if (t->left)
                {
                    t->left->val = 2 * t->val;      //左子树的pos = 2 *pos
                    q.push(t->left);
                }
                if (t->right)
                {
                    t->right->val = 2 * t->val + 1; //右子树的pos = 2 * pos + 1
                    q.push(t->right);
                }
            }
        }

        return maxWidth;
    }
};
```