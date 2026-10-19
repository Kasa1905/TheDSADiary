class Solution {
    int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums=nums;
        this.random=new Random();
    }
    
    public int pick(int target) {
        int idx=-1;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                count++;
                if(random.nextInt(count)==0){
                    idx=i;
                }
            }
        }
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */