package google;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author dongyoung
 * @since 2020/04/26
 */

//10,5),13,4),8,4,5),11),14),9,16),10),20,8
public class SplitArrayLargestSum {
    public static void main(String[] args) {
//        int num = 123;
//        String s1 = "pazunsabwlseseeiimsmftchpafqkquovuxhhkpvphw";
//        String s2= "nkrtxuiuhbcyqulfqyzgjjwjrlfwwxotcdtqsmfeing";
//        String str = "cba";
//        char[] chars = s1.toCharArray();
//        char[] chars2 = s2.toCharArray();
//        Arrays.sort(chars);
//        Arrays.sort(chars2);
        String s ="MANUAL:123";
        String ss = s.replace("MANUAL:","");
        System.out.println(ss);


    }

    static class Solution {
        public int splitArray(int[] nums, int m) {
            String s = "df";
            char ch = 'a';
            LinkedList list;
//            list.
            int len =nums.length;
            long total = 0;
            for(int i=0; i<len; i++){
                total += (long)nums[i];
            }
            if(m == 1){
                return (int)total;
            }

            long avg = total/m;
            long sum = 0;
            long ans = 0;
            for(int i=0; i<len; i++){
                sum += nums[i];
                if(sum > avg){
                    long inc = Math.max(sum, (total-sum)/(m-1));  // 88, 25 = 15
                    long tmp = sum-nums[i];
                    long dec = Math.max(tmp, (total-tmp)/(m-1));  // 88 14 = 18
                    if(inc > dec){
                        System.out.println(i-1);
                        ans = Math.max(ans,tmp);
                        total -= tmp;
                        sum = nums[i];

                    }else{
                        System.out.println(i);
                        ans = Math.max(ans,sum);
                        total -= sum;
                        sum = 0;
                    }
                    m--;
                }
                if(m == 1){
                    break;
                }
            }
            ans = Math.max(ans,total);
            return (int)ans;
        }
    }
}
