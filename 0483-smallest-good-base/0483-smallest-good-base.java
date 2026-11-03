class Solution {

    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        int maxLen = 64 - Long.numberOfLeadingZeros(num);

        for (int m = maxLen; m >= 2; m--) {

            long left = 2;
            long right = (long) Math.pow(num, 1.0 / (m - 1));

            while (left <= right) {
                long mid = left + (right - left) / 2;

                long sum = geometricSum(mid, m, num);

                if (sum == num) {
                    return String.valueOf(mid);
                } else if (sum < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return String.valueOf(num - 1);
    }

    private long geometricSum(long base, int len, long limit) {
        long sum = 1;
        long curr = 1;

        for (int i = 1; i < len; i++) {

            if (curr > limit / base) {
                return limit + 1;
            }

            curr *= base;

            if (sum > limit - curr) {
                return limit + 1;
            }

            sum += curr;
        }

        return sum;
    }
}