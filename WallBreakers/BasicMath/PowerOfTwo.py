# import math
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
      if n <= 0:
        return False
      # return math.log10(n)/math.log10(2) % 1 == 0
      return bin(n).count('1') == 1