class TreeAncestor {
    int[][] dp;
    int maxRow;
    public TreeAncestor(int n, int[] parent) {
        maxRow=(int)(Math.log(n)/Math.log(2))+1;
        dp=new int[maxRow][n];
        dp[0]=parent;
        for(int i=1;i<maxRow;i++){
            for(int j=0;j<n;j++){
                int pre=dp[i-1][j];
                dp[i][j]=pre==-1 ? -1:dp[i-1][pre];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int maxRow=this.maxRow;
        while(k>0 && node>-1){
            if(k>=1<<maxRow){
                node=dp[maxRow][node];
                k-=1<<maxRow;
            }else{
                maxRow--;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */