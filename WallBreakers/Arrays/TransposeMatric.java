class Solution {
    public int[][] transpose(int[][] A) {
      int rowNum = A.length, colNum = A[0].length;
      int[][] result = new int[colNum][rowNum];
      for (int row = 0; row < rowNum; row++) {
        for (int col = 0; col < colNum; col++) {
          result[col][row] = A[row][col];
        } 
      }
      return result;
    }
}