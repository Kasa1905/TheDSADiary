class Solution {
    public int findRotateSteps(String ring, String key) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(ring, key, 0, 0, memo);
    }
    
    private int dfs(String ring, String key, int ringIndex, int keyIndex, Map<String, Integer> memo) {
        if (keyIndex == key.length()) return 0; 
        
        String memoKey = ringIndex + "," + keyIndex;
        if (memo.containsKey(memoKey)) return memo.get(memoKey);
        
        int minSteps = Integer.MAX_VALUE;
        char target = key.charAt(keyIndex);
        
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == target) {
                int dist = Math.abs(i - ringIndex);
                int rotate = Math.min(dist, ring.length() - dist);
                int nextSteps = 1 + dfs(ring, key, i, keyIndex + 1, memo);
                minSteps = Math.min(minSteps, rotate + nextSteps);
            }
        }
        
        memo.put(memoKey, minSteps);
        return minSteps;
    }
}