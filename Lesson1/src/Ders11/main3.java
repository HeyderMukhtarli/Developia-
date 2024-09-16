package Ders11;

import java.math.BigDecimal;
import java.util.Arrays;

public class main3 {
    public static void main(String[] args) {
        int[] arr1={9, 9, 9, 9, 9, 9, 9};
        int[] arr2={9, 9, 9, 9};


        // Create the head of the linked list

        System.out.println(addTwoNumbers(createListNode(arr1),createListNode2(arr2)) )   ;

    }
    public static ListNode  addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode ln=new ListNode();
     BigDecimal a=new BigDecimal(1);
      BigDecimal sum=new BigDecimal(0);
      BigDecimal sum2=new BigDecimal(0);
     do {
         BigDecimal val=new BigDecimal(l1.val);
         sum = sum.add(a.multiply(val));
         l1=l1.next;
         a=a.multiply(new BigDecimal(10));

     }while (l1!=null);
     a=new BigDecimal(1);
        do {
            sum2=sum2.add(a.multiply(new BigDecimal(l2.val)));
            l2=l2.next;
            a=a.multiply(new BigDecimal(10));

        }while (l2!=null);
        BigDecimal sum3=sum2.add(sum);
        System.out.println(sum);
        System.out.println(sum2);;
        System.out.println(sum3);
        char[] chars=String.valueOf(sum3).toCharArray();

//        ListNode l=new ListNode();
//        ListNode head = null;
//        ListNode newHead = null;
//        ListNode next = null;
        int val= chars[chars.length-1]-'0';

        ListNode head = new ListNode(val);

        // Pointer to the current node, starting with head
        ListNode current = head;

        // Iterate over the remaining characters in reverse order
        for (int i = chars.length - 2; i >= 0; i--) {
            int val2 = chars[i] - '0';
            ListNode newNode = new ListNode(val2);

            // Link the new node to the current node
            current.next = newNode;

            // Move the current pointer to the new node
            current = newNode;
        }

        return head;




    }

    public static ListNode createListNode(int[] nums){
        ListNode ln=new ListNode(nums[0]);
        ListNode ln2=new ListNode(nums[1]);
//        System.out.println("A");
        ListNode ln3=new ListNode(nums[3]);
        ListNode ln4=new ListNode(nums[4]);
        ListNode ln5=new ListNode(nums[5]);
        ListNode ln6=new ListNode(nums[6]);
        ln2.next=ln3;
        ln3.next=ln4;
        ln4.next=ln5;
        ln5.next=ln6;
//        System.out.println(ln2.next.val);
        ln.next=ln2;
//        System.out.println(ln.next.next.val+"33");
        return ln;
    }

    public static ListNode createListNode2(int[] nums){
        ListNode ln=new ListNode(nums[0]);
        ListNode ln2=new ListNode(nums[1]);
//        System.out.println("A");
        ListNode ln3=new ListNode(nums[3]);

        ln2.next=ln3;

//        System.out.println(ln2.next.val);
        ln.next=ln2;
//        System.out.println(ln.next.next.val+"33");
        return ln;
    }


    static ListNode printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        return head;
    }

}
