package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class Leetcode_3
{
    public static void main(String[] args)
    {
        String s = "abccde"; //cdefg
        String result ="";
        int key = 0;
        char[] ca = s.toCharArray();
        Map<String, Integer> tracker = new HashMap<>();
        for(int i = 0; i < ca.length ; i++ ){
            System.out.println("loop-"+i+" / "+(ca.length-1)+ " :: "+ ca[i]);
            String tempSubString = ""+ca[i];
            for(int j = i; j < ca.length ; j++)
            {
                char compareToChar = j < ca.length -1  ? ca[j+1] : 0;
                if  (compareToChar == 0) break;

                if(ca[j] == compareToChar){
                    System.out.println("\t inner-loop-"+j+" || comparing  "+ca[j]+ " == "+ compareToChar + " break ");
                    break;
                }
                else{
                    tempSubString = tempSubString + compareToChar;
                    System.out.println("\t inner-loop-"+j+" || comparing  "+ca[j]+ " != "+ compareToChar + " continue");
                }
                int lenght = (j-i)+1;
                tracker.put(tempSubString, lenght);
            }
            // ==== format result ====
            System.out.println("\t tracker (substring by length) ::"+ tracker);
            Map<Integer, List<Map.Entry<String,Integer>>> s1 = tracker.entrySet().stream().collect(Collectors.groupingBy(x->x.getValue()));
            System.out.println("\t tracker_grouped ::"+ s1);
            key = s1.keySet().stream().sorted(Comparator.reverseOrder()).findFirst().get();
            System.out.println("\t longest ::"+ s1.get(key));

            result = s1.get(key).stream()
                    .map(x->x.getKey())
                    .collect(Collectors.joining(",", "", ""));
        }
        System.out.println("\n ===  FINAL Result === "+ result);
        //return key;
    }
}
/*
loop-0 / 5 :: a
	 inner-loop-0 || comparing  a != b continue
	 inner-loop-1 || comparing  b != c continue
	 inner-loop-2 || comparing  c == c break
	 tracker (substring by length) ::{ab=1, abc=2}
	 tracker_grouped ::{1=[ab=1], 2=[abc=2]}
	 longest ::[abc=2]
loop-1 / 5 :: b
	 inner-loop-1 || comparing  b != c continue
	 inner-loop-2 || comparing  c == c break
	 tracker (substring by length) ::{ab=1, bc=1, abc=2}
	 tracker_grouped ::{1=[ab=1, bc=1], 2=[abc=2]}
	 longest ::[abc=2]
loop-2 / 5 :: c
	 inner-loop-2 || comparing  c == c break
	 tracker (substring by length) ::{ab=1, bc=1, abc=2}
	 tracker_grouped ::{1=[ab=1, bc=1], 2=[abc=2]}
	 longest ::[abc=2]
loop-3 / 5 :: c
	 inner-loop-3 || comparing  c != d continue
	 inner-loop-4 || comparing  d != e continue
	 tracker (substring by length) ::{ab=1, bc=1, cd=1, abc=2, cde=2}
	 tracker_grouped ::{1=[ab=1, bc=1, cd=1], 2=[abc=2, cde=2]}
	 longest ::[abc=2, cde=2]
loop-4 / 5 :: d
	 inner-loop-4 || comparing  d != e continue
	 tracker (substring by length) ::{ab=1, bc=1, cd=1, de=1, abc=2, cde=2}
	 tracker_grouped ::{1=[ab=1, bc=1, cd=1, de=1], 2=[abc=2, cde=2]}
	 longest ::[abc=2, cde=2]
loop-5 / 5 :: e
	 tracker (substring by length) ::{ab=1, bc=1, cd=1, de=1, abc=2, cde=2}
	 tracker_grouped ::{1=[ab=1, bc=1, cd=1, de=1], 2=[abc=2, cde=2]}
	 longest ::[abc=2, cde=2]

 ===  FINAL Result === abc,cde

 */
