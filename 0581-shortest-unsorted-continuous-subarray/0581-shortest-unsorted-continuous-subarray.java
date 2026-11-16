class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int leftBoundary = -1, rightBoundary = -1;
        

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i-1]) {
                leftBoundary = i - 1;
                break;
            }
        }
        
        if (leftBoundary == -1) {
            return 0;
        }
        
        for (int i = n-2; i >= 0; i--) {
            if (nums[i] > nums[i+1]) {
                rightBoundary = i + 1;
                break;
            }
        }
        int unsortedMin = Integer.MAX_VALUE;
        int unsortedMax = Integer.MIN_VALUE;
        
        for (int i = leftBoundary; i <= rightBoundary; i++) {
            unsortedMin = Math.min(unsortedMin, nums[i]);
            unsortedMax = Math.max(unsortedMax, nums[i]);
        }
        while (leftBoundary > 0 && nums[leftBoundary-1] > unsortedMin) {
            leftBoundary--;
        }
        while (rightBoundary < n-1 && nums[rightBoundary+1] < unsortedMax) {
            rightBoundary++;
        }
        
        return rightBoundary - leftBoundary + 1;
    }
}