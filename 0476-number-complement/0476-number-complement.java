class Solution {
    public int findComplement(int num) {
        if(num==0) return 1;
        int bitiLength=Integer.toBinaryString(num).length();
        int mask=(1<<bitiLength)-1;
        return num^mask;
    }
}