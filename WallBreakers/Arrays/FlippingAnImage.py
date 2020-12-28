class Solution:
    def flipAndInvertImage(self, A: List[List[int]]) -> List[List[int]]:
      for row in A:
        for col in range((len(row)+1)//2):
          # row[~col] = row[-col-1] = row[len(row) - 1 - col]
          row[col], row[~col] = row[~col]^1, row[col]^1
      
      return A