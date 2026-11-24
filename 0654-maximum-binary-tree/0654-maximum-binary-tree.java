
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        Stack<TreeNode> stack = new Stack<>();
        for(int num: nums) {

            TreeNode current = new TreeNode(num);
            while(!stack.isEmpty() && stack.peek().val < num) {
                current.left = stack.pop();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = current;
            }
            stack.push(current);
        }
        while(stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }
}