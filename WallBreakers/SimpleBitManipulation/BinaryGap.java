class Solution {
  public int binaryGap(int n) {
    int count = 0, max = 0;
    boolean firstBitFound = false;
    while (n > 0) {
      if (firstBitFound) count++;
      if ((n & 1) == 1) { // last bit set
        firstBitFound = true;
        max = Math.max(max, count);
        count = 0;
      }
      n >>= 1;
    }
    return max;
  }
  // public int binaryGap(int n) {
  //   if (Integer.bitCount(n) < 2) return 0;
  //   char[] bin = Integer.toBinaryString(n).toCharArray();
  //   int count = 0, max = 0;
  //   for (char bit : bin)  {
  //     if (bit == '1') {
  //       max = Math.max(max, count+1);
  //       count = 0;
  //       continue;
  //     }
  //     if (bit == '0') count++;
  //   }
  //   return max;
  // }
}