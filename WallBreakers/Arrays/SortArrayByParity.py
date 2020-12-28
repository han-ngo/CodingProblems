class Solution:
    def sortArrayByParity(self, A: List[int]) -> List[int]:
        h, t = 0, len(A) - 1
        while h < t:
            if A[h] % 2 != 0 and A[t] % 2 == 0:
                A[h], A[t] = A[t], A[h]

            if A[h] % 2 == 0:
                h += 1
            if A[t] % 2 != 0:
                t -= 1

        return A
