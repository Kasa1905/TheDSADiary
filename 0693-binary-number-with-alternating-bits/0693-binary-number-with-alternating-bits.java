class Solution {
    public boolean hasAlternatingBits(int n) {

        String binary = Integer.toBinaryString(n);

        for(int i=0;i<binary.length()-1;i++){
            if((binary.charAt(i)=='0' && binary.charAt(i+1)=='0') || (binary.charAt(i)=='1' && binary.charAt(i+1)=='1')){
                return false;
            }
        }
        return true;
        
    }
}