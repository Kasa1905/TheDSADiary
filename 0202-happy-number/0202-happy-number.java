class Solution {
    public boolean isHappy(int n) {
        while(n!=1 && n!=4){
            n=getSum(n);
        }   
        return n==1;
    }

    public int getSum(int n){
        int sum=0;
        while(n>0){
            int digit=n%10;
            sum=sum+(digit*digit);
            n=n/10;
        }
        return sum;
    }
}