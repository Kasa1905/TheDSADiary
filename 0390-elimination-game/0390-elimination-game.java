class Solution {
    public int lastRemaining(int n) {
        int passes=0,count=n,gap=1,first=1;
        while(count>1){
            passes++;
            if((passes&1)==1 ||(count&1)==1){
                first+=gap;
            }
            count>>=1;
            gap<<=1;
        }
        return first;
    }
}