package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dongyoung
 * @since 2020/04/18
 */
public class AndroidUnlockPattern {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfPatterns(1,2));
        StringBuilder builder;
        char[] ch;
    }

    static class Solution {
        int M;
        int N;
        int ans = 0;

        public int numberOfPatterns(int m, int n) {
            M = m;
            N = n;
            helper(new ArrayList<>(), new HashSet<>());
            return ans;
        }

        private void helper(List<Integer> patterns, Set<Integer> visit) {
            if (patterns.size() >= M && patterns.size() <= N) {
                System.out.println(patterns);
                ans += 1;
            }
            if (patterns.size() > N) {
                return;
            }

            for (int i = 1; i < 10; i++) {
                if (visit.contains(i)) {
                    continue;
                }
                if (isPossible(visit, i, patterns)) {
                    visit.add(i);
                    patterns.add(i);
                    helper(patterns, visit);
                    patterns.remove(patterns.size()-1);
                    visit.remove(i);
                }
            }
        }

        private boolean isPossible(Set<Integer> visit, int i, List<Integer> patterns) {
            if (patterns.size() == 0) {
                return true;
            }
            int prev = patterns.get(patterns.size()-1);
            if (prev == 5 || i==5) {
                return true;
            } else if (i % 2 == 1) {
                if (prev == (10 - i)) {
                    return visit.contains(5);
                }
                if (prev - 2 == i) {
                    return visit.contains(prev - 1);
                }
                if (prev - 6 == i) {
                    return visit.contains(prev - 3);
                }
                if (prev + 2 == i) {
                    return visit.contains(prev + 1);
                }
                if (prev + 6 == i) {
                    return visit.contains(prev + 3);
                }
            } else if (10 - prev == i) {
                return visit.contains(5);
            }
            return true;
        }
    }
}
