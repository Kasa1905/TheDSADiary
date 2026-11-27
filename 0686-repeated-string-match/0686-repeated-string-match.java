class Solution {
    public int repeatedStringMatch(String a, String b) {
        int minRepeats = (int) Math.ceil((double) b.length() / a.length());
        StringBuilder res = new StringBuilder();

            for (int i = 1; i <= minRepeats + 1; i++) {
        res.append(a);

        if (res.toString().contains(b)) {
            return i;
        }
    }

    return -1;
}
}