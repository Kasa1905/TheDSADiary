class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100;i++){
            int x=i;
            int mul=1;
            while(x!=0){
                mul=mul*(x%10);
                x=x/10;
            }
            if(mul%t==0) return i;
        }
        return -1;
    }
}