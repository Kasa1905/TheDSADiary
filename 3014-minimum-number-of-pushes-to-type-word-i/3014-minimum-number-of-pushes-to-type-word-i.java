class Solution {
    public int minimumPushes(String word) {
       int n=word.length();
       int quotient=n/8;
       int remainder=n%8;
       return quotient*(quotient+1)/2*8+remainder*(quotient+1); 
    }
}