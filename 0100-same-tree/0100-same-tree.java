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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: both nodes are null, indicating equality
        if (p == null && q == null) {
            return true;
        }

        // If one node is null while the other is not, they are not equal
        if (p == null || q == null) {
            return false;
        }

        // Check if the current nodes have the same value
        if (p.val != q.val) {
            return false;
        }

        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
