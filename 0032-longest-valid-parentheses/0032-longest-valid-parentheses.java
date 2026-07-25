class Solution {
    public int longestValidParentheses(String s) {
        int[] arr=new int[s.length()];
        Stack<Integer> stack=new Stack<>();
        for(int k=0;k<s.length();k++){
            if(s.charAt(k)=='('){
                stack.add(k);
            }
            else if(s.charAt(k)==')'){
                if(!stack.isEmpty()){
                    int top=stack.pop();
                    arr[top]=1;
                    arr[k]=1;
                }
            }
        }
        int max=0;
        int curr=0;
        for(int k=0;k<arr.length;k++){
            if(arr[k]==1){
                curr++;
            }else{
                max=Math.max(curr,max);
                curr=0;
            }
        }
        return Math.max(curr,max);
    }
}