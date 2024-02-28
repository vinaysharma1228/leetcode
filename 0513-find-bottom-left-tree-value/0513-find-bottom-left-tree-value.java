
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0; // or any default value based on the problem
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int leftmostValue = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            leftmostValue = queue.peek().val; // Update leftmost value for each level

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return leftmostValue;
    }
}
