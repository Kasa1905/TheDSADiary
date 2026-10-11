public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int count = 0;
        if (n == 0) return 1;
        boolean[] flags = new boolean[10];
        count += countNumbersWithUniqueDigits(n-1);
        for (int i = 1; i < 10; i++) {
            flags[i] = true;
            count += search(n-1, flags);
            flags[i] = false;
        }
        return count;
    }
    
    public int search(int n, boolean[] flags) {
        if (n == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (flags[i] == false) {
                flags[i] = true;
                count += search(n-1, flags);
                flags[i] = false;
            }
        }
        return count;
    }
}