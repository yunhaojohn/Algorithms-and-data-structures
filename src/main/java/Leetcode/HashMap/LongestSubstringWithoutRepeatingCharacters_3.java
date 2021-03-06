package Leetcode.HashMap;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    // ArrayList
    // O(n^2) - 20ms
//    public int lengthOfLongestSubstring(String s) {
//        List<Character> list = new ArrayList<>();
//        int max = 0;
//        for (int i = 0; i < s.length(); i++){
//            // ArrayList.contains - O(n)
//            if (list.contains(s.charAt(i))){
//                while (list.get(0) != s.charAt(i))
//                    list.remove(0);
//                list.remove(0);
//            }
//            list.add(s.charAt(i));
//            if (list.size() > max) {
//                max = list.size();
//            }
//        }
//        return max;

        // Sliding Window + Hash set
        // O(n), 2n step most - 23ms
//        Set<Character> set = new HashSet<>();
//        int max = 0, i = 0, j = 0, len = s.length();
//        while (j < len){
//            if (set.contains(s.charAt(j)))
//                set.remove(s.charAt(i++));
//            else{
//                set.add(s.charAt(j++));
//            }
//            max = Math.max(max, j-i);
//        }
//        return max;

    // Hash table
    // O(n), n step most - 21ms
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i-left+1);
        }
        return res;
    }

    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters_3 obj = new LongestSubstringWithoutRepeatingCharacters_3();
        System.out.println(obj.lengthOfLongestSubstring("abba"));
    }
}
