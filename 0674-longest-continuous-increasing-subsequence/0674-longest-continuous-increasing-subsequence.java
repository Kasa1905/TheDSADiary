class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int maxSize = 1;
        int count = 1;

        for (int j=1; j<n; j++) {
            if (nums[j] > nums[j - 1]) count++;
            else {
                maxSize = Math.max(maxSize, count);
                count = 1;
            }
        }

        return Math.max(maxSize, count);
    }
}