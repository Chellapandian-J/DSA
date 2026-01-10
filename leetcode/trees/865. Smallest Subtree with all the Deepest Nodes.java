class Solution {

    // Helper class to store depth and subtree root
    private static class Result {
        TreeNode node;
        int depth;

        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(null, 0);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        }

        if (right.depth > left.depth) {
            return new Result(right.node, right.depth + 1);
        }

        // depths are equal → this node is LCA of deepest nodes
        return new Result(root, left.depth + 1);
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]

Example 2:
Input: root = [1]
Output: [1]

Example 3:
Input: root = [0,1,3,null,2]
Output: [2]

time complexity: O(N)
space complexity: O(H) H-height of tree
*/
