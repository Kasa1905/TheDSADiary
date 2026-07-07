class Solution {
    public int dominantIndex(int[] nums) {
        int max1=-51;
        int idx=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max1){
                max1=nums[i];
                idx=i;
            }
        }
        int n=nums.length;
        for (int i =0;i<nums.length;i++){
            if(nums[i]*2>max1&i!=idx)
            return -1;
        }
        return idx;
    }
}