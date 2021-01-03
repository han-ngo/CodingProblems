class Solution:
  def binaryGap(self, n: int) -> int:
    count, maxDist = 0, 0
    firstBitFound = False
    while n > 0:
      # for bit in bin(n):
      if firstBitFound:
        count += 1
      if (n & 1) == 1:
        # if bit == '1':
        firstBitFound = True
        maxDist = max(count, maxDist)
        count = 0
      n >>= 1
    return maxDist