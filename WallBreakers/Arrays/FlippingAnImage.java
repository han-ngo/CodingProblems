class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
      int row = A.length, col = A[0].length;
      int temp;
      for (int r = 0; r < row; r++) {
        for (int c = 0; c < (col+1)/2; c++) {
          temp = A[r][c];
          A[r][c] = A[r][col-c-1]^1;
          A[r][col-c-1] = temp^1;
        }
      }
      
      return A;
    }
}