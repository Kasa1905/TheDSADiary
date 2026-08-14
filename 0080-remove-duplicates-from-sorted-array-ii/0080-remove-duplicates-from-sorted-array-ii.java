class Solution {
    public int removeDuplicates(int[] nums) {
        int writeIndex=1;
        int duplicateCount=0;
        int prevElement=nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]!=prevElement){
                duplicateCount=0;
            }else{
                duplicateCount++;
            }
            if(duplicateCount<=1){
                nums[writeIndex++]=nums[i];
                prevElement=nums[i];
            }
        }
        return writeIndex;
    }
}