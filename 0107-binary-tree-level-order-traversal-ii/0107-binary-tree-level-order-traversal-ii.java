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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        travelTree(0, root, result);
        List<List<Integer>> reverseRst = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            reverseRst.add(result.get(result.size() - i - 1));
        }
        return reverseRst;
    }

    private void travelTree(int level, TreeNode root, List<List<Integer>> result) {
        if (root == null) return;
        if (result.size() <= level) result.add(new ArrayList<>());
        result.get(level).add(root.val);
        travelTree(level + 1, root.left, result);
        travelTree(level + 1, root.right, result);
    }
}