class Solution {
  // public int findComplement(int num) {
  //   StringBuilder sb = new StringBuilder();
  //   char[] binStr = (Integer.toBinaryString(num)).toCharArray();
  //   for (char c : binStr) {
  //     if (c == '0') {
  //       sb.append("1");
  //     } else {
  //       sb.append("0");
  //     }
  //   }
  //   return Integer.parseInt(sb.toString(), 2);
  // }
  public int findComplement(int num) {
    // invert bin then mask with num of bits
    // return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    return num ^ (int)(Math.pow(2, (int)(Math.log(num) / Math.log(2) + 1))-1);
  }
}