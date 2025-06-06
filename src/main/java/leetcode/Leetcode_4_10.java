package leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Leetcode_4_10
{
    public static void main(String[] args)
    {
        Leetcode_4_10 m = new Leetcode_4_10();

        int[] nums1 = new  int[]{1,2}; int[] nums2 = new  int[]{3,4};
        m.p4_findMedianSortedArrays(nums1, nums2);

        m.p5_longestPalindrome("babab");
        m.p6();
        m.p7_reverse(123); m.p7_reverse(-123);
        m.p8();
        m.p10_isMatch("aa","a");
    }

    //https://leetcode.com/problems/median-of-two-sorted-arrays/
    void p4_findMedianSortedArrays(int[] nums1, int[] nums2){
        List<Integer> l1 = IntStream.of(nums1).boxed().collect(Collectors.toList());
        List<Integer> l2 = IntStream.of(nums2).boxed().collect(Collectors.toList());

        List<Integer> merged = new ArrayList<>();
        merged.addAll(l1);
        merged.addAll(l2);

        merged.sort(Integer::compareTo);

        int n = merged.size();
        double median = merged.size() % 2 ==0
                ? (merged.get(n/2 - 1) + merged.get(n/2)) / 2.0
                : merged.get(n/2);

        System.out.println("Median: " + median);
    }

    //https://leetcode.com/problems/longest-palindromic-substring/
    String p5_longestPalindrome(String s){
        Map<String,Integer> trackermap= new HashMap<>();
        for (int i =0; i<s.length();i++){
            for (int j =i+1; j<s.length();j++){
                if(i == s.length()-1) break;
                String sunStr = s.substring(i,j);
                if(new StringBuilder("").append(sunStr).reverse().toString().equals(sunStr))
                    trackermap.put(sunStr,sunStr.length());
            }
        }
        // ==== format result ====
        System.out.println("\t tracker (substring by length) ::"+ trackermap);
        Map<Integer, List<Map.Entry<String,Integer>>> s1 = trackermap.entrySet().stream().collect(Collectors.groupingBy(x->x.getValue()));
        System.out.println("\t tracker_grouped ::"+ s1);
        int key = s1.keySet().stream().sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println("\t longest ::"+ s1.get(key));
        String result = s1.get(key).stream()
                .map(x->x.getKey())
                .findFirst().get();
        System.out.println("\t result ::"+ result);
        return result;
    }

    // ZifZag Conversion
    void p6(){ }

    // https://leetcode.com/problems/reverse-integer/
    int p7_reverse(int x){
        int result = x>0
            ? Integer.parseInt(new StringBuilder("").append(String.valueOf(x)).reverse().toString())
            : Integer.parseInt("-"+new StringBuilder("").append(String.valueOf(x).substring(1)).reverse().toString());
        System.out.println("p7_reverse :: result ::" + result);
        return result;
    }

    void p8(){ }


    // https://leetcode.com/problems/palindrome-number/description/
    boolean p9(int x){
        if (x < 0) return false; // Negative numbers can't be palindromes
        return new StringBuilder("").append(x).reverse().toString().equals(String.valueOf(x));
    }

    // https://leetcode.com/problems/regular-expression-matching/
    boolean p10_isMatch(String s, String p)
    {
        // TODO - not working
        boolean result = true;
        char[] p1 = p.toCharArray();
        int string_next = 0;
        for(int i = 0 ; i < p1.length; i++){
            if(p1[i] == '.'){
                s.charAt(string_next);
                string_next ++;
            }else if(p1[i] == '*'){
                while(s.charAt(string_next) != p1[i+1]){
                    string_next ++;
                }
            }else{
                if(p1[i] == s.charAt(string_next)){
                    string_next ++;
                }else return false;
            }
        }
        System.out.println("p10_isMatch :: result ::" + result);
        return result;
    }
}
