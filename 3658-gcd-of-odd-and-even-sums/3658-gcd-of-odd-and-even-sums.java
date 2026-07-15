class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd=0;
        int sumEven=0;
        int num=1;

        for(int i=0;i<n;i++){
            sumOdd+=num;
            num=num+2;
        }
        num=2;
        for(int i=0;i<n;i++){
             sumEven+=num;
             num+=2;
        }
        return getGcd(sumEven,sumOdd);
    }
    int getGcd(int sumEven,int sumOdd){
        int gcd=1;
        int small=Math.min(sumEven,sumOdd);
        for(int i=2;i<=small;i++){
            if(sumOdd%i==0 && sumEven%i==0){
                gcd=i;
            }
        }
        return gcd;
    }
}