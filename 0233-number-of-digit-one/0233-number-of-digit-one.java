class Solution {
    public int countDigitOne(int n) {
        String number = String.valueOf(n);
        int digits = number.length();
        int t = 1;
        int res = 0;
        for (int i = digits - 1; i >= 0; i--) {
            int d = (n / t) % 10;
            int xyz = n / t / 10;
            int abc = n % t;
            if (d == 0) {
                res += xyz * t;
            } else if (d == 1) {
                res += xyz * t + abc + 1;
            } else {
                res += xyz * t + t;
            }
            t = t * 10;
        }
        return res;
    }
}