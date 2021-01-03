class Solution:
  def hammingDistance(self, x: int, y: int) -> int:
    diff, count = x^y, 0
    while diff > 0:
      diff &= (diff-1) # set rightmost bit 1 to 0
      count += 1
    return count
    # return bin(x^y).count("1");