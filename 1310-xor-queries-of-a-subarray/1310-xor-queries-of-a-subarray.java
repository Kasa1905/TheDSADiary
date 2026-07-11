class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] x=new int[arr.length];
        int[] ans=new int[queries.length];
        x[0]=arr[0];
        for(int i=1;i<arr.length;i++)x[i]=x[i-1]^arr[i];

        for(int i=0;i<queries.length;i++){
            if(queries[i][0]==0){ans[i]=x[queries[i][1]];}
            else{ans[i]=x[queries[i][1]] ^ x[queries[i][0]-1];}
        }
        return ans;

    }
}