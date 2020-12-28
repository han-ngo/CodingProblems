class Solution:
    def transpose(self, A: List[List[int]]) -> List[List[int]]:
      row, col = len(A), len(A[0])
      result = [[0] * row for _ in range(col)]
      for r in range(row):
        for c in range(col):
          result[c][r] = A[r][c]

      return result
