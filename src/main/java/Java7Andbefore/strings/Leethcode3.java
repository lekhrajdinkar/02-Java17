package Java7Andbefore.strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Leethcode3 {
    public static void main(String[] args)
    {
        String s = "abccdefg"; //cdefg
        String result ="";
        char[] ca = s.toCharArray();
        Map<String, Integer> tracker = new HashMap<>();
        for(int i = 0; i < ca.length ; i++ ){
            System.out.println("loop-"+i+" / "+(ca.length-1)+ " :: "+ ca[i]);
            String temp = ""+ca[i];
            for(int j = i; j < ca.length ; j++)
            {
                char compareTo = j < ca.length -1  ? ca[j+1] : 0;  if  (compareTo == 0) break;
                if(ca[j] == ca[j+1]){
                    System.out.println("\t inner-loop-"+j+" || comparing  "+ca[j]+ " == "+ compareTo + " break ");
                    break;
                }
                else{
                    temp = temp + compareTo;
                    System.out.println("\t inner-loop-"+j+" || comparing  "+ca[j]+ " != "+ compareTo + " continue");
                }
                tracker.put(temp, j-i+1);
            }
            System.out.println("\t tracker ::"+ tracker);
            Map<Integer, List<Map.Entry<String,Integer>>> s1 = tracker.entrySet().stream().collect(Collectors.groupingBy(x->x.getValue()));
            System.out.println("\t tracker_grouped ::"+ s1);
            int key = s1.keySet().stream().sorted(Comparator.reverseOrder()).findFirst().get();
            System.out.println("\t longest ::"+ s1.get(key).get(0));
            result = s1.get(key).get(0).getKey();
        }
        System.out.println("\n ===  FINAL Result === "+ result);
    }
}
/*
loop-0 / 7 :: a
	 inner-loop-0 || comparing  a != b continue
	 inner-loop-1 || comparing  b != c continue
	 inner-loop-2 || comparing  c == c break
	 tracker ::{ab=1, abc=2}
	 tracker_grouped ::{1=[ab=1], 2=[abc=2]}
	 longest ::abc=2
loop-1 / 7 :: b
	 inner-loop-1 || comparing  b != c continue
	 inner-loop-2 || comparing  c == c break
	 tracker ::{ab=1, bc=1, abc=2}
	 tracker_grouped ::{1=[ab=1, bc=1], 2=[abc=2]}
	 longest ::abc=2
loop-2 / 7 :: c
	 inner-loop-2 || comparing  c == c break
	 tracker ::{ab=1, bc=1, abc=2}
	 tracker_grouped ::{1=[ab=1, bc=1], 2=[abc=2]}
	 longest ::abc=2
loop-3 / 7 :: c
	 inner-loop-3 || comparing  c != d continue
	 inner-loop-4 || comparing  d != e continue
	 inner-loop-5 || comparing  e != f continue
	 inner-loop-6 || comparing  f != g continue
	 tracker ::{ab=1, bc=1, cd=1, abc=2, cde=2, cdefg=4, cdef=3}
	 tracker_grouped ::{1=[ab=1, bc=1, cd=1], 2=[abc=2, cde=2], 3=[cdef=3], 4=[cdefg=4]}
	 longest ::cdefg=4
loop-4 / 7 :: d
	 inner-loop-4 || comparing  d != e continue
	 inner-loop-5 || comparing  e != f continue
	 inner-loop-6 || comparing  f != g continue
	 tracker ::{ab=1, bc=1, cd=1, de=1, abc=2, def=2, cde=2, cdefg=4, cdef=3, defg=3}
	 tracker_grouped ::{1=[ab=1, bc=1, cd=1, de=1], 2=[abc=2, def=2, cde=2], 3=[cdef=3, defg=3], 4=[cdefg=4]}
	 longest ::cdefg=4
loop-5 / 7 :: e
	 inner-loop-5 || comparing  e != f continue
	 inner-loop-6 || comparing  f != g continue
	 tracker ::{ab=1, bc=1, cd=1, de=1, ef=1, abc=2, def=2, cde=2, cdefg=4, efg=2, cdef=3, defg=3}
	 tracker_grouped ::{1=[ab=1, bc=1, cd=1, de=1, ef=1], 2=[abc=2, def=2, cde=2, efg=2], 3=[cdef=3, defg=3], 4=[cdefg=4]}
	 longest ::cdefg=4
loop-6 / 7 :: f
	 inner-loop-6 || comparing  f != g continue
	 tracker ::{ab=1, bc=1, cd=1, de=1, ef=1, fg=1, abc=2, def=2, cde=2, cdefg=4, efg=2, cdef=3, defg=3}
	 tracker_grouped ::{1=[ab=1, bc=1, cd=1, de=1, ef=1, fg=1], 2=[abc=2, def=2, cde=2, efg=2], 3=[cdef=3, defg=3], 4=[cdefg=4]}
	 longest ::cdefg=4
loop-7 / 7 :: g
	 tracker ::{ab=1, bc=1, cd=1, de=1, ef=1, fg=1, abc=2, def=2, cde=2, cdefg=4, efg=2, cdef=3, defg=3}
	 tracker_grouped ::{1=[ab=1, bc=1, cd=1, de=1, ef=1, fg=1], 2=[abc=2, def=2, cde=2, efg=2], 3=[cdef=3, defg=3], 4=[cdefg=4]}
	 longest ::cdefg=4

 ===  FINAL Result === cdefg

 */
