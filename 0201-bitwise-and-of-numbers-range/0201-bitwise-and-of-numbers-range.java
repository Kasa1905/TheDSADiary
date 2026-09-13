class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int diffBits=0;
        while(left!=right){
            left>>=1;
            right>>=1;
            diffBits++;
        }
        return right<<diffBits;
    }
}