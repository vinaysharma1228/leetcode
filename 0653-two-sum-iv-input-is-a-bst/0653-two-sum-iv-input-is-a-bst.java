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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> elements = new ArrayList<>();
        inorderTraversal(root, elements);

        int left = 0, right = elements.size() - 1;

        while (left < right) {
            int currentSum = elements.get(left) + elements.get(right);

            if (currentSum == k) {
                return true;
            } else if (currentSum < k) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    private void inorderTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorderTraversal(node.left, result);
            result.add(node.val);
            inorderTraversal(node.right, result);
        }
    }
}