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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q=new ArrayDeque<>();

        q.offer(root);
        int depth=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode temp=q.peek();
                if(temp.left==null && temp.right==null) return depth;
                else{
                    if(temp.left!=null)
                        q.offer(temp.left);
                    if(temp.right!=null)
                        q.offer(temp.right);
                }
                q.poll();
            }
            depth+=1;
        }
        return 0;
    }
}