class Solution {

    private final TreeMap<Integer, Integer> map;
    private final Random random = new Random(System.currentTimeMillis());
    private int sum = 0;

    public Solution(int[] w) {
        map = new TreeMap<>();
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            map.put(sum, i);
        }
    }

    public int pickIndex() {
        return map.get(map.higherKey(random.nextInt(sum)));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */