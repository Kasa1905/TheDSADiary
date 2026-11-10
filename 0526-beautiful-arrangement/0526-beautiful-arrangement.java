class Solution {
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    private int permute(int[] A, int i) {
        if(i == 0) return 1;
        int count = 0;
        for(int j = i; j >= 0; j--) {
            swap(A, i, j);
            if(A[i] % (i + 1) == 0 || (i + 1) % A[i] == 0) {
                count += permute(A, i - 1);
            }
            swap(A, i, j);
        }
        return count;
    }
    public int countArrangement(int n) {
        int[] A = new int[n];
        for(int i = 0; i < n; i++) {
            A[i] = i + 1;
        }
        return permute(A, n - 1);
    }
}