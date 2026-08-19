class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        res.add(temp);
        Arrays.sort(nums);
        int l=0,k;
        for(int i=0;i<nums.length;i++){
            if(i==0||nums[i]!=nums[i-1]){
                l=res.size();
            }
            k=res.size();
            for(int j=k-l;j<k;j++){
                temp=new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        } 
        return res;       
    }
}