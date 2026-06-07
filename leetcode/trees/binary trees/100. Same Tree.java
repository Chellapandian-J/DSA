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
//using bfs
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> n=new LinkedList<>();
        Queue<TreeNode> m=new LinkedList<>();
        n.offer(p);
        m.offer(q);
        while(!n.isEmpty() && !m.isEmpty()){
            TreeNode node1=n.poll();
            TreeNode node2=m.poll();
            if(node1==null && node2==null){
                continue;
            }
            if(node1==null || node2==null){
                return false;
            }
            if(node1.val!=node2.val){
                return false;
            }
            n.offer(node1.left);
            n.offer(node1.right);

            m.offer(node2.left);
            m.offer(node2.right);
        }
        return n.isEmpty() && m.isEmpty();
    }
}
//using dfs
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
/*100. Same Tree
Given the roots of two binary trees p and q, write a function to
check if they are the same or not.
Two binary trees are considered the same if they are structurally
identical, and the nodes have the same value.
Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false

time complexity: O(N) N-number of nodes in tree
space complexity: O(H) H-height of tree
*/  w