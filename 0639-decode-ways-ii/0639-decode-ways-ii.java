class Solution {
    	private static final int MOD = 1000000007;

    public int numDecodings(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int n = str.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;

        dp[1] = ways(str.charAt(0));

        for (int i = 2; i <= n; i++) {
            long oneCharWays = (long) ways(str.charAt(i - 1)) * dp[i - 1];
            long twoCharWays = ways(str.charAt(i - 2), str.charAt(i - 1)) * dp[i - 2];
            dp[i] = (int) ((oneCharWays + twoCharWays) % MOD);
        }

        return dp[n];
    }


    private int ways(char curr) {
        if (curr == '*') {
            return 9;
        } else if (curr != '0') {
            return 1;
        } else {
            return 0;
        }
    }

    private long ways(char curr, char prev) {
        if (curr == '*' && prev == '*') {
            return 15;
        } else if (curr == '*') {
            return prev > '6' ? 1 : 2;
        } else if (prev == '*') {
            return (curr == '1') ? 9 : (curr == '2') ? 6 : 0;
        } else {
            int val = Integer.parseInt("" + curr + prev);
            return val >= 10 && val <= 26 ? 1 : 0;
        }
    }
}