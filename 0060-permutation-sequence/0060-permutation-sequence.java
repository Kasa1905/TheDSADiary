class Solution {
    public String getPermutation(int n, int k) {
        int[] factorials=new int[n];
        factorials[0]=1;
        for(int i=1;i<factorials.length;++i){
            factorials[i]=i*factorials[i-1];
        }
        boolean[] used=new boolean[n];
        int remainder=k-1;
        String answer="";
        for (int i = n - 1; i >= 0; --i) {
            int offset = remainder / factorials[i];
            for (int j = 0; j < used.length; ++j) {
                if (used[j]) continue;
                if (offset == 0) {
                    answer += j + 1;
                    used[j] = true;
                    break;
                }   
                --offset;
            }
            remainder %= factorials[i];
        }        
        return answer;
    }
}