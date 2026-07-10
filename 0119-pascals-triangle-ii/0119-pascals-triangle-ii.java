class Solution {
    public List<Integer> getRow(int r) {
        List<Integer> result=new ArrayList<>();
        long val=1;
        for(int j=0;j<=r;j++){
            result.add((int) val);
            val=val*(r-j)/(j+1);
        }
        return result;
    }
}