class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>>lastElements = new HashMap<>();
        for (int element: nums){
            int subseqCount = 0;
            if (lastElements.containsKey(element-1)){
                subseqCount = lastElements.get(element-1).poll();
                if (lastElements.get(element-1).isEmpty()) lastElements.remove(element-1);
            }
            lastElements.putIfAbsent(element, new PriorityQueue<>());
            lastElements.get(element).add(subseqCount+1);
        }
        for (Map.Entry<Integer,PriorityQueue<Integer>>entry: lastElements.entrySet()){
            while (!entry.getValue().isEmpty()){
                if (entry.getValue().poll()<3)return false;
            }
        }
        return true;
    }
}