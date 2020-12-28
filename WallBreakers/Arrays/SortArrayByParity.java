class Solution {
    public int[] sortArrayByParity(int[] A) {
        int h = 0, t = A.length-1;
        int temp;
        while (h < t) {
            if (A[h] % 2 != 0 && A[t] % 2 == 0) { // h is odd, t is even
                // swap
                temp = A[h];
                A[h] = A[t];
                A[t] = temp;
            }
            
            if (A[h] % 2 == 0) h++;
            if (A[t] % 2 != 0) t--;
        }
        return A;
    }
}