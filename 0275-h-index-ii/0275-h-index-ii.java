class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int l=0,h=citations.length;
        while(l<h){
            int m=l+h>>>1;
            if(citations[m]==n-m)
                return n-m;
            else if(citations[m]<n-m){
                l=m+1;
            }else{
                h=m;
            }
        }
        return n-l;
    }
}