package util;

import java.util.Arrays;
import java.util.Collection;

public class Print {
    public static void p(Object... o){
        System.out.println("\n==============");
        Arrays.stream(o).forEach(System.out::println);
    }

    public static void pc(String desc, Collection c){
        System.out.println("\n======= "+ desc +" ========");
        c.stream().forEach(System.out::println);
    }
}
