class Solution {
    public boolean isPowerOfTwo(int n) {
      if (n <= 0) return false;
      // String bin = Integer.toBinaryString(n);
      // int originalLen = bin.length();
      // return originalLen - bin.replace("1", "").length() == 1;
      return Math.log10(n)/Math.log10(2) % 1 == 0;
    }
}