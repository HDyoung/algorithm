package leetcode;

import java.util.Stack;

/**
 * @author dongyoung
 * @since 2020/04/16
 */
public class ValidParenti {
    public static void main(String[] args) {
        String s ="(())((())()()(*)(*()(())())())()()((()())((()))(*";
        Solution solution = new Solution();
        System.out.println(solution.checkValidString(s));

    }


    static class Solution {
        public boolean checkValidString(String s) {
            Stack<Integer> stack = new Stack<>();
            Stack<Integer> star = new Stack<>();
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);
                if(ch == '('){
                    stack.add(i);
                }else if(ch == '*'){
                    star.add(i);
                }else{
                    if(stack.isEmpty()){
                        if(star.isEmpty()){
                            return false;
                        }else{
                            star.pop();
                        }
                    }else{
                        stack.pop();
                    }
                }
            }

            while ((!star.isEmpty()) && (!stack.isEmpty())){
                int starIdx = star.pop();
                int openIdx = stack.pop();
                if(openIdx > starIdx){
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
