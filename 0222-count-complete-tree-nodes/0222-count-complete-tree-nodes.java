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
    public int countNodes(TreeNode root) {
       return root==null ? 0: findLastIndex(root,1); 
    }
    private int lHeight(TreeNode node,int count){
        return node==null ? count - 1 : lHeight(node.left,count+1);
    }
    private int findLastIndex(TreeNode node,int currIndex){
        if(node.left==null && node.right==null) return currIndex;
        if(lHeight(node.left,1)==lHeight(node.right,1))
            return findLastIndex(node.right,currIndex*2+1);
        else return findLastIndex(node.left,currIndex*2);
    }
}