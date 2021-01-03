class Solution {
  public int totalHammingDistance(int[] nums) {
    int len = nums.length, sum = 0;
    int bitCount;
    for (int b=0; b<32; b++) {
      bitCount = 0;
      for (int num : nums) {
        bitCount += (num >> b) & 1;
      }
      sum += bitCount*(len-bitCount);
    }
    return sum;
  }
}