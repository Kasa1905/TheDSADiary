class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length,i=0,max=0;
        Stack<Integer> s=new Stack<>();
        while(i<n){
            while(!s.isEmpty() && heights[i]<heights[s.peek()]){
                max=Math.max(max,heights[s.pop()]*(i-(s.isEmpty()?0:s.peek()+1)));
            }
            s.push(i++);
        }
        while(!s.isEmpty()){
            max=Math.max(max,heights[s.pop()]*(n-(s.isEmpty()?0:s.peek()+1)));
        }
        return max;
    }
}