class Solution {
    public boolean checkDivisibility(int n) {
        int su=0;
        int pr=1;
        int num=n;
        while(num>0){
            int r=num%10;
            su=su+r;
            pr=pr*r;
            num/=10;
        }
        return n%(su+pr)==0;
    }
}