package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.xml.internal.xsom.impl.scd.Iterators.Array;

/**
 * Demo
 * 23280666188154
 * @author dongyoung
 * @since 2019-12-22
 */
public class Demo {
    int[] nx = {-1,0};
    public static void main(String[] args) {
        List<Integer> slist = null;
        slist.get(0) = 3;
        slist.remove()
        slist.add();
    }

    class GCD
    {
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public int generalizedGCD(int num, int[] arr)
        {
            int result = 1;
            for(int i=0; i<num; i++){
                result = max(result, gcd(result,arr[i])
            }
            return result;
        }

        int max(int a, int b){
            return a > b ? a : b;
        }

        int gcd(int a, int b){
            if(a < b){
                int tmp = a;
                a = b;
                b = a;
            }
            while(b != 0){
                int r = a%b;
                a = b;
                b = r;
            }
            return a;
        }
        // METHOD SIGNATURE ENDS
    }
}
