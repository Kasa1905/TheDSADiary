class Solution {
    	Integer[] mem;
    public int jump(int[] nums) {
        mem=new Integer[nums.length];
        return jump(0,nums);        
    }
    private int jump(int p, int[] nums) {
        int n = nums.length;
        if(p>=n-1)
            return 0;
        if(mem[p]!=null)
            return mem[p];
        int minSteps = n;
        for(int i=1;i<=nums[p];i++) 
            minSteps = Math.min(minSteps, 1+jump(p+i, nums));
        return mem[p]=minSteps;
    }
}