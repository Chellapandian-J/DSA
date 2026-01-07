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
    private long totalsum=0;
    private long maxproduct=0;
    private static final int mod=1000000007;
    public int maxProduct(TreeNode root) {
        totalsum=gettotal(root);
        getsubtreesum(root);
        return (int)(maxproduct%mod);
    }
    private long gettotal(TreeNode node){
        if(node==null)return 0;
        return node.val+gettotal(node.left)+gettotal(node.right);
    }
    private long getsubtreesum(TreeNode node){
        if(node==null) return 0;
        long left=getsubtreesum(node.left);
        long right=getsubtreesum(node.right);
        long subtree=node.val+left+right;
        long product=subtree*(totalsum-subtree);
        maxproduct=Math.max(maxproduct,product);
        return subtree;
    }
}
/*
Example 1:
Input: root = [1,2,3,4,5,6]
Output: 110
Explanation: 
    The above tree is shown.
    If we split the tree by removing the red edge we get two trees with sums 11 and 10.
    Their product is 110 (11*10)
    This is the maximum product that we can obtain, so we return 110.
    
Example 2:
Input: root = [1,null,2,3,4,null,5,6]
Output: 90
Explanation: 
    The above tree is shown.
    If we split the tree by removing the red edge we get two trees with sums 15 and 6.
    Their product is 90 (15*6)
    This is the maximum product that we can obtain, so we return 90.

time complexity: O(N)
space complexity: O(H) H-height of tree
*/