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
  private int sum = 0;

  private int helper(TreeNode node) {
    if (node == null) return 0;

    var left = helper(node.left);
    var right = helper(node.right);

    sum += Math.abs(left - right);

    return left + right + node.val;
  }

  public int findTilt(TreeNode root) {
    helper(root);
    return sum;
  }
} 