class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxLeft = height[l];
        int maxRight = height[r];
        int res = 0;
        while(l < r) {
            if(height[l] < height[r]) {
                maxLeft = Math.max(maxLeft, height[l]);
                res += maxLeft - height[l];
                l++;
            } else {
                maxRight = Math.max(maxRight, height[r]);
                res += maxRight - height[r];
                r--;
            }
        }
        return res;
    }
}