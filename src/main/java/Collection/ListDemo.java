package Collection;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public class ListDemo
{
    private static void p(Object ...o){
        System.out.println("\n==============");
        Arrays.stream(o).forEach(System.out::println);
    }

    private static void pc(String desc, Collection c){
        System.out.println("\n======= "+ desc +" ========");
        c.stream().forEach(System.out::println);
    }

    public static void main(String a[]){
        Collections.unmodifiableList(new ArrayList<>()); // create immutable list
        arrayList_Create();
        arrayList_Search("Anna");
        arrayList_MultiThreadEnv();

        LinkedList_test();
    }

    static void arrayList_Create(){
        List<Integer> list = null;

        // A.Create - add/remove
        list = List.of(1,2,3);
        list = new ArrayList(); list.add(0); list.add(1) ; list.remove(1) ; pc("CREATE : ",list);
        list = new ArrayList(IntStream.range(0,10).boxed().collect(Collectors.toList())); pc("CREATE from Collection : ",list);

        //reverse original list
        Collections.reverse(list);pc("REVERSE : ", list);

        // B. iterate
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            Integer item = itr.next();
            // list.add(22); // FAIL-FAST :: java.util.ConcurrentModificationException
            System.out.print("-------"+item);
        }

        ListIterator<Integer> litr = new ArrayList(list).listIterator();
        while(litr.hasPrevious()){
            Integer item = litr.previous();
            System.out.print("-------"+item);
        }
    }

    static void arrayList_Search(String text){
        List<String> list = IntStream
                .range(0,5)
                .boxed()
                .map(i->Integer.toHexString(i))//           here
                .collect(toCollection(ArrayList::new));
                //.collect(Collectors.toList());
        list.add("Anna");
        pc("Search List : ",list);

        //Search : 1
        List<String> res = list.stream()
                .filter(s->s.contains(text))
                .collect(Collectors.toList());
        pc("Search result : ",res);

        //Search : 2
        Collections.sort(list);
        int indexFound = Collections.binarySearch(list, text);
        p(indexFound); //5
    }


    // ===== Concurrency ======

    static void arrayList_MultiThreadEnv(){
        // 1. CopyOnWriteArrayList
        // add/remove create new snapshot of list
        // thread safe
            CopyOnWriteArrayList list = new CopyOnWriteArrayList(new Integer[]{0,1,2});

            list.add(100);
            Iterator<Integer> itr = list.iterator();
            list.add(200);


        //itr.forEachRemaining(i->p(i));
        while(itr.hasNext()){
            Integer item = itr.next(); System.out.print("-------"+item); // 0,1,2 / no 100
        }
    }

    // ====== Linked List +=====

    static void LinkedList_test(){
        LinkedList list = new LinkedList<String>();
        list.add("item1");list.add("item2");list.add("item2");list.add("item2");
        list.addLast("item-last");
        list.addFirst("item-First");
        list.stream().forEach(System.out::println); // maintains insertion order

        // prg: get Random
        int randomIndex = (int) (new Random().nextFloat() * list.size())+1;
        randomIndex = new Random().nextInt(list.size());
        p("RANDOM Element from List : ", list.get(randomIndex));

        p(list.getFirst(),list.getLast(),list.get(2));

        // --- Partitioning ---

        p(list.stream().collect(Collectors.groupingBy(s->s+"__KEY")));
        // Map<T, List<T>>
        // {item-First__KEY=[item-First], item-last__KEY=[item-last], item1__KEY=[item1], item2__KEY=[item2, item2, item2]}

        p(list.stream().collect(Collectors.partitioningBy(s-> false)));
        // Map<booleAN, List<T>>
        // {false=[item-First, item1, item2, item-last], true=[]}


    }
}
