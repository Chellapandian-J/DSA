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
class Solution {

    List<int[]> nodes = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        dfs(root, 0, 0);

        Collections.sort(nodes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // column
            if (a[1] != b[1]) return a[1] - b[1]; // row
            return a[2] - b[2];                   // value
        });

        List<List<Integer>> res = new ArrayList<>();

        int prevCol = Integer.MIN_VALUE;

        for (int[] node : nodes) {
            int col = node[0];
            int val = node[2];

            if (col != prevCol) {
                res.add(new ArrayList<>());
                prevCol = col;
            }

            res.get(res.size() - 1).add(val);
        }

        return res;
    }

    private void dfs(TreeNode node, int row, int col) {
        if (node == null) return;

        nodes.add(new int[]{col, row, node.val});
 
        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }
}
//original solution using a custom class to store node information
class Solution {

    class NodeInfo {
        int col;
        int row;
        int val;

        NodeInfo(int col, int row, int val) {
            this.col = col;
            this.row = row;
            this.val = val;
        }
    }

    List<NodeInfo> nodes = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        dfs(root, 0, 0);

        Collections.sort(nodes, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });

        List<List<Integer>> res = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (NodeInfo node : nodes) {

            if (node.col != prevCol) {
                res.add(new ArrayList<>());
                prevCol = node.col;
            }

            res.get(res.size() - 1).add(node.val);
        }

        return res;
    }

    private void dfs(TreeNode node, int row, int col) {
        if (node == null) return;

        nodes.add(new NodeInfo(col, row, node.val));

        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }
}
/*Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
Return the vertical order traversal of the binary tree.

example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]

example 2:
Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]

time complexity: O(n log n) where n is the number of nodes in the tree, due to sorting the list of nodes.
space complexity: O(n) for storing the list of nodes and the result.*/