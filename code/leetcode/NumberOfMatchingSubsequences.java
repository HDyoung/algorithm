package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * NumberOfMatchingSubsequences
 *
 * @author dongyoung
 * @since 2020-02-17
 */
public class NumberOfMatchingSubsequences {
    public static void main(String[] args) {

    }

    class Solution {
        public int numMatchingSubseq(String S, String[] words) {
            int cnt = 0;
            Arrays.sort(words, Comparator.reverseOrder());
            for (String word : words) {
                if (isSubsequence(S, word)) {
                    cnt++;
                } else {
                    nonsubSet.add(word);
                }
            }
            return cnt;
        }

        Set<String> subSet = new HashSet<>();
        Set<String> nonsubSet = new HashSet<>();

        public boolean isSubsequence(String s, String target) {
            if (target.equals("")) {
                return true;
            }
            if (subSet.contains(target)) {
                return true;
            }
            if (nonsubSet.contains(target)) {
                return false;
            }
            char[] sChars = s.toCharArray();
            char[] tChars = target.toCharArray();

            int idx = 0;
            for (int i = 0; i < sChars.length; i++) {
                if (tChars[idx] == sChars[i]) {
                    idx++;
                    subSet.add(target.substring(0, idx));
                    if (idx == tChars.length) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
