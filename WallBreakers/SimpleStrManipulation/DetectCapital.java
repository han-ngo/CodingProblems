class Solution {
    public boolean detectCapitalUse(String word) {
      int len = word.length();
      char[] wordArr = word.toCharArray();
      boolean isFirstCharCap = false;
      boolean isSecondCharCap = false;
      for (int i=0; i<len; i++) {
        if (Character.isUpperCase(wordArr[i])) {
          if (i == 0) isFirstCharCap = true;
          if (i == 1) isSecondCharCap = true;
        }
        if (i >= 1) break;
      }
      for (int i=2; i<len; i++) {
        if (isFirstCharCap && isSecondCharCap && Character.isLowerCase(wordArr[i])) {
          return false; // should be all cap
        } else if (isFirstCharCap && !isSecondCharCap && Character.isUpperCase(wordArr[i])) {
          return false; // should only have first char cap
        } else if (!isFirstCharCap && !isSecondCharCap && Character.isUpperCase(wordArr[i])) {
          return false; // should be all lower
        }
      }
      return isFirstCharCap == isSecondCharCap || (isFirstCharCap && !isSecondCharCap);
    }
}