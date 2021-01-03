class Solution {
  public boolean canFormArray(int[] arr, int[][] pieces) {
    Map<Integer, int[]> map = new HashMap<>();
    for (int i=0; i<pieces.length; i++) {
      map.put(pieces[i][0], pieces[i]);
    }
    
    for (int i=0; i<arr.length;) {
      if (!map.containsKey(arr[i])) return false;
      int[] curP = map.get(arr[i]);
      for (int num : curP) {
        if (arr[i++] != num) return false;
      }
    }
    
    return true;
  }
  // public boolean canFormArray(int[] arr, int[][] pieces) {
  //   int arrIdx = 0, matchCount, curLen, tempIdx;
  //   boolean notMatch = false;
  //   while (arrIdx < arr.length) {
  //     matchCount = 0;
  //     for (int[] piece : pieces) {
  //       tempIdx = arrIdx;
  //       curLen = piece.length;
  //       for (int i=0; i<curLen; i++) {
  //         if (tempIdx < arr.length && arr[tempIdx++] == piece[i]) matchCount++;
  //         else break;
  //       }
  //       if (matchCount == curLen) break;
  //       else matchCount = 0;
  //     }
  //     if (matchCount == 0) return false;
  //     arrIdx += matchCount;
  //   }
  //   return true;
  // }
}