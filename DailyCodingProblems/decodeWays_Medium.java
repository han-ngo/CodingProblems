class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        
        int[] memo = new int[len+1];
        memo[len] = 1;
        if (Integer.parseInt(s.charAt(len-1) + "") > 0) {
            memo[len-1] = 1;
        }
        
        int cur;
        for (int end = len-2; end >= 0; end--) {
            cur = Integer.parseInt(s.substring(end,end+2));
            if (s.charAt(end) == '0') {
                continue;
            } else if (cur <= 26) {
                memo[end] = memo[end+1] + memo[end+2];
            } else {
                memo[end] = memo[end+1];
            }
        }
        
        return memo[0];
    }
}