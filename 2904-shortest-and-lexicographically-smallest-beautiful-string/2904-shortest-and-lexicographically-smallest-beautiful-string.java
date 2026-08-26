class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int minLen = Integer.MAX_VALUE;
        String minStr = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                queue.add(i);
                if (queue.size() == k) {
                    int start = queue.peek();
                    int len = i - start + 1;
                    String str = s.substring(start, i + 1);
                    if (len < minLen || (len == minLen && str.compareTo(minStr) < 0)) {
                        minLen = len;
                        minStr = str;
                    }
                    queue.poll();
                }
            }
        }

        return minStr;
    }
}