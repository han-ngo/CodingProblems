class Solution {
    public List<String> fizzBuzz(int n) {
      List<String> results = new ArrayList<>();
      StringBuilder sb = new StringBuilder();
      for (int num = 1; num <= n; num++) {
        if (num % 3 == 0 && num % 5 == 0) {
          results.add("FizzBuzz");
        } else if (num % 3 == 0) {
          results.add("Fizz");
        } else if (num % 5 == 0) {
          results.add("Buzz");
        } else {
          results.add(Integer.toString(num));
        }
      }
      
      return results;
    }
}