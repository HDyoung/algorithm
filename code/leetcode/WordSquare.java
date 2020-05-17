package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordSquare {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for(String a:list2){
            System.out.println("dd");
        }

        list.add("abaa");
        list.add("ab");
        list.add("abaa");
        list.remove("abaa");
        String [] str;

        System.out.println(list);

    }

    public static boolean isPossible(int row, String word, List<String> list){
        if(row == 0){
            return true;
        }
        for(int i=0; i< row; i++){
            String aword = list.get(i);
            if(aword.charAt(row) != word.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
