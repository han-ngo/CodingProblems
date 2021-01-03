class Solution:
  def findComplement(self, num: int) -> int:
    result = ''
    binStr = bin(num)
    for b in binStr[2:]:
      if b == '0': 
        result += '1'
      else: 
        result += '0'
    return int(result,2)
  # def findComplement(self, num: int) -> int:
  #   size = len(bin(num))-2 # exclude '0b'
  #   # return num ^ (2**num.bit_length()-1)
  # return num ^ (2**size - 1)