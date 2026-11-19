class Solution {
    public int triangleNumber(int[] sides) {
        Arrays.sort(sides);
        int totalTriangles = 0;
        for (int longest = sides.length - 1; longest >= 2; longest--) {
            int left = 0;
            int right = longest - 1;

            while (left < right) {
                if (sides[left] + sides[right] > sides[longest]) {
                    totalTriangles += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return totalTriangles;
    }

}