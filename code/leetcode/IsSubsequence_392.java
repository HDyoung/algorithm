package leetcode;

/**
 * IsSubsequence_392
 *
 * @author dongyoung
 * @since 2020-02-17
 */
public class IsSubsequence_392 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "axc";
        String t = "ahbgdc";

        System.out.println(solution.isSubsequence(s, t));
    }

    static class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.equals("")) {
                return true;
            }
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();

            int idx = 0;
            for (int i = 0; i < tChars.length; i++) {
                if (tChars[i] == sChars[idx]) {
                    idx++;
                    if (idx == sChars.length) {
                        return true;
                    }
                }
            }
            return idx == sChars.length;
        }
    }
}
