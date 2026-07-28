import java.util.*;

class Solution {
    public String smallestPalindrome(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i] / 2; j++) {
                left.append((char) ('a' + i));
            }

            if (count[i] % 2 == 1) {
                middle = (char) ('a' + i);
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + (middle == 0 ? "" : middle) + right;
    }
}