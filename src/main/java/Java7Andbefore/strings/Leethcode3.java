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
            System.out.println("\t final ::"+ s1.get(key).get(0));
        }
    }
}
