class Solution {
    public int longestSubsequence(int[] nums) {
        int start=0,end=nums.length,curStart=0,max=0,curXor=0;
        while(curStart<end){
            curXor^=nums[curStart++];
            if(curXor!=0)max=curStart-start;
        }
        if(curXor!=0)return max;
        for(int i=0;i<end;i++){
            if(nums[i]!=0)return end-1;
        }
        return 0;
    }
}