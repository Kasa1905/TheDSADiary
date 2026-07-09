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
    public boolean isBalanced(TreeNode root) {
        try{
            getDepth(root);
        } catch(Exception e){
            return false;
        }
        return true;
    }
    private int getDepth(TreeNode root) throws Exception{
        if(root ==null) return 0;
        int leftDepth=getDepth(root.left);
        int rightDepth=getDepth(root.right);
        if(Math.abs(leftDepth-rightDepth)>1) throw new Exception("NOt Balanced");

        return Math.max(leftDepth,rightDepth)+1;
    }
}