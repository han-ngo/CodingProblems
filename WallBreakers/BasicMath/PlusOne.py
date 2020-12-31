class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
      string = "".join([str(digit) for digit in digits])
      return [int(digit) for digit in str(int(string)+1)] 