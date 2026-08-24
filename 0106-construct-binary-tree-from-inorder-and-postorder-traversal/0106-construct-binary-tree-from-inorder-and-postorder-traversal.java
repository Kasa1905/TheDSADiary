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
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=postorder.length;
        if(n==0) return null;
        if(n==1) return new TreeNode(postorder[0]);
        postIndex=n-1;
        return helper(inorder,postorder,0,n-1);
    }
    TreeNode helper(int[] inorder,int[] postorder,int start,int end){
        if(start>end) return null;
        TreeNode root=new TreeNode(postorder[postIndex--]);
        int curr=findIndex(inorder,root.val);

        root.right=helper(inorder,postorder,curr+1,end);
        root.left=helper(inorder,postorder,start,curr-1);
        return root;
    }
    int findIndex(int[] inorder,int key){
        for(int i=inorder.length-1;i>=0;i--){
            if(inorder[i]==key) return i;
        }
        return -1;
    }
}