class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0, j=1, diff=0, n=nums.length, sum=Integer.MIN_VALUE;
        int count=0;
        while(j<n && i<n-1){
            if(nums[j]-nums[i]==k && (nums[i]+nums[j])!=sum){
                sum=nums[i]+nums[j];
                i++; j++; count++;
            }
			else if((nums[j]-nums[i])<k){
                j++;
            }
			else{
                i++;
            }
            if(i==j) j++;
        }
        return count;
    }
}