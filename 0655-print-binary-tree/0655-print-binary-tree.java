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
    public List<List<String>> printTree(final TreeNode root) {
        final int width = (int) Math.pow(2, getHeight(root)) - 1;
        final List<List<String>> result = new ArrayList<>();

        dfs(root, result, 0, width, 0, width);

        return result;
    }

    private void dfs(final TreeNode root, final List<List<String>> result, final int l, final int r, final int level, final int width) {
        if(root != null) {
            if(level >= result.size()) {
                result.add(new ArrayList<>());

                for(int i = 0; i < width; ++i)
                    result.get(level).add("");
            }

            final int mid = (l + r) / 2;
            
            result.get(level).set(mid, String.valueOf(root.val));

            dfs(root.left, result, l, mid, level + 1, width);
            dfs(root.right, result, mid, r, level + 1, width);
        }
    }

    private int getHeight(final TreeNode root) {
        if(root == null)
            return 0;
        
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}