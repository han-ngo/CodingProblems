// import java.util.StringJoiner;
class Solution {
  public String reverseWords(String s) {
    char[] sArr = s.toCharArray();
    int len = s.length();
    int start = 0;
    for (int i=0; i<=len; i++) {
      if (i == len || sArr[i] == ' ') {
        swap(sArr, start, i-1);
        start = i+1;
      }
    }
    return String.valueOf(sArr);
  }
  
  private void swap(char[] sArr, int s, int e) {
    char temp;
    while (s < e) {
      temp = sArr[s];
      sArr[s] = sArr[e];
      sArr[e] = temp;
      s++;
      e--;
    }
  }
//   public String reverseWords(String s) {
//     String[] sChar = s.split("\\s+");
//     StringJoiner sj = new StringJoiner(" ");
//     for (String str : sChar) {
//       char[] curS = str.toCharArray();
//       reverseString(curS);
//       sj.add(String.valueOf(curS));
//     }
//     return sj.toString();
//   }

  // private void reverseString(char[] s) {
  //   int len = s.length;
  //   char temp;
  //   for (int i=0; i<len/2; i++) {
  //     temp = s[i];
  //     s[i] = s[len-i-1];
  //     s[len-i-1] = temp;
  //   }
  // }
}