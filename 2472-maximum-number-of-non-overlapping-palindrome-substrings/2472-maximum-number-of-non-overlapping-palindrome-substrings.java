class Solution {
    public boolean palindrome(String str,int l,int r){
        while(l<r){
            if(str.charAt(l)!=str.charAt(r))
            return false;
            l++;
            r--;
        }
        return true;
    }
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        if(k==1)
        return n;
        int[] dp=new int[n+1];
        for(int i=0;i<n;i++){
            dp[i+1]=Math.max(dp[i+1],dp[i]);
            for(int j=i;j<n;j++){
                if(j-i+1>=k){
                    if(palindrome(s,i,j)){
                        dp[j+1]=Math.max(dp[j+1],dp[i]+1);
                    }
                }
            }
        }
        return dp[n];
    }
}