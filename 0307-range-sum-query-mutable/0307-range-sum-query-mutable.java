class NumArray {
    int[] tree;
    int[] nums;
    int size;
    public NumArray(int[] nums) {
        this.size=nums.length;
        this.nums=new int[size];
        this.tree=new int[size];
        for(int i=0;i<size;++i)
        update(i,nums[i]);
    }
    
    public void update(int index, int val) {
       int delta=val-nums[index];
       nums[index]=val;
       for(;index<size;index|=index+1)
            tree[index]+=delta; 
    }
    
    public int sumRange(int left, int right) {
        return sum(right)-sum(left-1);
    }

    public int sum(int ind){
        int ans=0;
        while (ind>=0){
            ans+=tree[ind];
            ind&=ind+1;
            ind--;
        }
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */