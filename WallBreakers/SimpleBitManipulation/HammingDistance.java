class Solution {
  public int hammingDistance(int x, int y) {
    int dist = 0;
    x ^= y;
    while (x>0) {
      x &= (x-1); // set rightmost 1 to 0
      dist++;
    }
    return dist;
  }
  // public int hammingDistance(int x, int y) {
  //   return Integer.bitCount(x^y);
  // }
}