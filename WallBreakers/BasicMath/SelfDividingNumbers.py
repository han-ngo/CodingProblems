class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
      def self_dividing_number(num):
        curNum = num
        while num > 0:
          digit = num % 10
          num = num // 10
          if digit == 0 or curNum % digit != 0:
            return False
        return True
        # for digit in str(num):
        #   if digit == '0' or num % int(digit) != 0:
        #     return False
        # return True
      
      results = []
      for num in range(left, right + 1):
        if self_dividing_number(num):
          results.append(num)
      return results