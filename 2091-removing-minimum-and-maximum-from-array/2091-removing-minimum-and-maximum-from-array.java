class Solution {
    public int minimumDeletions(int[] arr) {
        int min = 0;
        int max = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[min]) min = i;
            if (arr[i] > arr[max]) max = i;
        }
        
        int ans = Math.max(min, max) + 1; // delete from left to right
        ans = Math.min(ans, Math.max(arr.length - min, arr.length - max)); // from right to the left
        
		// looking for boundaries
        int left  = Math.min(min, max);  
        int right = Math.max(min, max);
        
        ans = Math.min(ans, left + 1 + arr.length - right); // delete from left and right
        
        return ans;
    }
}