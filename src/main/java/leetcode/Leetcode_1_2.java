package leetcode;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Leetcode_1_2
{
    // https://leetcode.com/problems/two-sum/
    int[] p1(){
        List<Integer> nums_list = List.of(3,2,4); int target = 6;
        int[] nums = nums_list.stream().mapToInt(x->x.intValue()).toArray();

        for(int i=0; i < nums.length; i++) {
            for(int j=i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    log.info(" ( index: ) and  ( index: ) adds up to ", nums[i], i, nums[j], j, target);
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    // https://leetcode.com/problems/add-two-numbers/
    @ToString
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {};
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    ListNode p2(){
        //local
        ListNode l111 = new ListNode(3, null);
        ListNode l11 = new ListNode(4, l111);
        ListNode l1 = new ListNode(2, l11); // input-1

        ListNode l222 = new ListNode(4, null);
        ListNode l22 = new ListNode(6, l222);
        ListNode l2 = new ListNode(5, l22); // input-2
        System.out.println( "l1 " + l1);
        System.out.println( "l1 "+ l1);
        /*
        String n1Str = ""+l1.next.next.val + l1.next.val + l1.val;
        String n2Str = ""+l2.next.next.val + l2.next.val + l2.val;
        int result = Integer.parseInt(n2Str) + Integer.parseInt(n1Str);
        System.out.println("local hardcoded :  +  = ", n2Str, n1Str, result);
        */

        // generic
        ListNode currentNode = l1;
        StringBuilder n1_str = new StringBuilder("").append(currentNode.val);
        while(currentNode.next != null ){
            n1_str = n1_str.append(currentNode.next.val) ;
            currentNode = currentNode.next;
        }
        System.out.println( "n1 "+ n1_str);
        n1_str.reverse();
        System.out.println( "n1 reverse "+ n1_str);

        currentNode = l2;
        StringBuilder n2_str = new StringBuilder("").append(currentNode.val);
        while(currentNode.next != null ){
            n2_str = n2_str.append(currentNode.next.val) ;
            currentNode = currentNode.next;
        }
        System.out.println( "n2 "+ n2_str);
        n2_str.reverse();
        System.out.println( "n2 reverse " + n2_str);

        int sum = Integer.parseInt(n1_str.toString()) + Integer.parseInt(n2_str.toString());
        System.out.println("sum " + sum);

        char[] chararr = String.valueOf(sum).toCharArray();
        System.out.println("char Array of sum  "+ chararr.toString()); //807   8 < 0 < 7(return)

        ListNode result = new ListNode(Character.getNumericValue(chararr[chararr.length-1]));
        ListNode currentN =  result;
        for(int i = chararr.length-1 ; i >= 0  ; i--){
            if(i == 0 ) break;
            ListNode nextN = new ListNode(Character.getNumericValue(chararr[i-1]));
            currentN.next = nextN;
            currentN = nextN;
        }
        System.out.println("result " + result);
        return result;

    }

    //=================== RUN ===================
    public static void main(String[] args) {
        Leetcode_1_2 m = new Leetcode_1_2();
        m.p1();
        m.p2();
    }

}
