class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        size = len(s)
        for i in range(size//2):
          s[i], s[~i] = s[~i], s[i]
          # s[i], s[size-i-1] = s[size-i-1], s[i]

        # s[:] = s[::-1]
