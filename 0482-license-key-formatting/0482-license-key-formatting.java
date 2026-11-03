class Solution {
    public String licenseKeyFormatting(String S, int K) {
        
        StringBuilder sb = new StringBuilder();

        for (int i = S.length() - 1, count = 0 ; i >= 0 ; --i) {
            
            char c = S.charAt(i);
            if (c == '-') continue;

            if (count == K) {
                sb.append('-');
                count = 0;
            }

            sb.append(Character.toUpperCase(c));
            ++count;
        }

        return sb.reverse().toString();
    }
}