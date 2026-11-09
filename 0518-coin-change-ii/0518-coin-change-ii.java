class Solution {
    public int change(int amount, int[] coins) {
        if(amount==0) return 1;
        int n=coins.length;
        if(n==0) return 0;

        int[][] dp=new int[amount+1][n];
        Arrays.fill(dp[0],1);
        for(int i=1;i<=amount;i++){
            dp[i][0]=(i<coins[0])?0:dp[i-coins[0]][0];
        }

        for(int j=1;j<n;j++){
            for(int i=1;i<=amount;i++){
                dp[i][j]=dp[i][j-1]+((i<coins[j])?0:dp[i-coins[j]][j]);
            }
        }
        return dp[amount][n-1];
    }
}