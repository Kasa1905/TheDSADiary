class Solution {
    public int removeBoxes(int[] boxes) {
        int n=boxes.length;
        int[][][] dp=new int[n][n][n];
        return remove(boxes,0,n-1,0,dp);
    }
    public int remove(int[] b, int left, int right, int streak, int[][][] dp){
        if(left>right)  return 0;
        if(dp[left][right][streak]!=0)  return dp[left][right][streak];
        int max=remove(b,left+1,right,0,dp)+(streak+1)*(streak+1);
        for(int i=left+1;i<=right;i++){
            if(b[left]==b[i]){
                int removeMiddle=remove(b,left+1,i-1,0,dp);
                int mergeLater   =remove(b,i,right,streak+1,dp); 
                max=Math.max(removeMiddle+mergeLater   ,max);
            }
        }
        return dp[left][right][streak]=max;
    }
}