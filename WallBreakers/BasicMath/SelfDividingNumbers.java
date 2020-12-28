class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
      ArrayList<Integer> results = new ArrayList<>();
      for (int curNum = left; curNum <= right; curNum++) {
        if (isSelfDividingNumber(curNum)) {
          results.add(curNum);
        }
      }
      return results;
    }
  
    private boolean isSelfDividingNumber(int num) {
      int curNum = num, digit;
      while (num > 0) {
        digit = num % 10;
        num /= 10;
        if (digit == 0 || curNum % digit != 0) {
          return false;
        }
      }
      return true;
    }
}