class Solution {
    public List<Integer> grayCode(int n) {
        int s=1<<n;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<s;i++) result.add(i^(i>>1));
        return result;
    }
}