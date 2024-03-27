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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a map to store the indices of values in the inorder array
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1, indexMap);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> indexMap) {
        if (preStart > preorder.length - 1 || inStart > inEnd)
            return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // Find the index of the root value in the inorder array
        int inIndex = indexMap.get(root.val);
        
        // Recursively build left and right subtrees
        root.left = buildTreeHelper(preorder, inorder, preStart + 1, inStart, inIndex - 1, indexMap);
        root.right = buildTreeHelper(preorder, inorder, preStart + inIndex - inStart + 1, inIndex + 1, inEnd, indexMap);
        
        return root;
    }
}
