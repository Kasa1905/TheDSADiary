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
    public TreeNode sortedArrayToBST(int[] nums) {
        return findans(nums,0,nums.length-1);
    }
    private TreeNode findans(int [] nums,int left,int right){
        if(right<left) return null;
        int mid=(left+right)/2;
        TreeNode root= new TreeNode(nums[mid]);
        TreeNode leftSubtree=findans(nums,left,mid-1);
        TreeNode rightSubtree=findans(nums,mid+1,right);
        root.left=leftSubtree;
        root.right=rightSubtree;
        return root;
    }
}