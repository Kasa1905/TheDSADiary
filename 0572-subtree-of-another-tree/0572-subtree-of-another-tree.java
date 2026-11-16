class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) 
            return false;

        if(root.val == subRoot.val){
            // if(subRoot.left == null && subRoot.right == null) 
            //     return
            if(isSame(root,subRoot)) 
                return true;
        }

        boolean left = isSubtree(root.left,subRoot);
        if(left) 
            return true;
        
        boolean right = isSubtree(root.right,subRoot);
        if(right) 
            return right;
            
        return false;
    }
    public boolean isSame(TreeNode p, TreeNode q){
        if(p == null || q == null)
            return p == q;
        return (p.val == q.val) && isSame(p.left,q.left) && isSame(p.right,q.right);
    }
}