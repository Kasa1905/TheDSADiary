class Solution {
    void func(int idx, int[] nums, List<Integer> a, TreeSet<List<Integer>> ans) {
        int n = nums.length;
        if (idx >= n) {
            if (a.size() >= 2) ans.add(new ArrayList<>(a));
            return;
        }
        if (a.size() == 0 || nums[idx] >= a.get(a.size() - 1)) {
            a.add(nums[idx]);
            func(idx + 1, nums, a, ans);
            a.remove(a.size() - 1);
        }
        func(idx + 1, nums, a, ans);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        TreeSet<List<Integer>> ans = new TreeSet<>((x, y) -> {
            for (int i = 0; i < x.size() && i < y.size(); i++)
                if (!x.get(i).equals(y.get(i))) return Integer.compare(x.get(i), y.get(i));
            return Integer.compare(x.size(), y.size());
        });
        func(0, nums, temp, ans);
        return new ArrayList<>(ans);
    }
}