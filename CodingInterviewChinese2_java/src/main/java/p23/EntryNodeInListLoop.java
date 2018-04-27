package p23;

import tools.ListNode;

public class EntryNodeInListLoop {
    public static ListNode entryNodeOfLoop(ListNode head) {
        if (head==null || head.next==null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while (true) {
            if (fast==null || fast.next==null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            count++;
            if (fast==slow)
                break;
        }
        fast = head;
        slow = head;
        for (int i=0;i<count;i++) {
            fast = fast.next;
        }
        while (fast!=slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    public static void test(String testName, ListNode head, ListNode entryNode)
    {
        if(testName != null)
            System.out.print(testName + " begins: ");

        if(entryNodeOfLoop(head) == entryNode)
            System.out.println("Passed.");
        else
            System.out.println("FAILED.---------------------------------");
    }

    // A list has a node, without a loop
    public static void test1()
    {
        ListNode pNode1 = new ListNode(1);

        test("test1", pNode1, null);

    }

    // A list has a node, with a loop
    public static void test2()
    {
        ListNode pNode1 = new ListNode(1);
        pNode1.next = pNode1;

        test("test2", pNode1, pNode1);

    }

    // A list has multiple nodes, with a loop
    public static void test3()
    {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        pNode1.next = pNode2;
        pNode2.next = pNode3;
        pNode3.next = pNode4;
        pNode4.next = pNode5;
        pNode5.next = pNode3;

        test("test3", pNode1, pNode3);

    }

    // A list has multiple nodes, with a loop
    public static void test4()
    {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        pNode1.next = pNode2;
        pNode2.next = pNode3;
        pNode3.next = pNode4;
        pNode4.next = pNode5;
        pNode5.next = pNode1;

        test("test4", pNode1, pNode1);

    }

    // A list has multiple nodes, with a loop
    public static void test5()
    {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        pNode1.next = pNode2;
        pNode2.next = pNode3;
        pNode3.next = pNode4;
        pNode4.next = pNode5;
        pNode5.next = pNode5;

        test("test5", pNode1, pNode5);

    }

    // A list has multiple nodes, without a loop
    public static void test6()
    {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        pNode1.next = pNode2;
        pNode2.next = pNode3;
        pNode3.next = pNode4;
        pNode4.next = pNode5;

        test("test6", pNode1, null);

    }

    // Empty list
    public static void test7()
    {
        test("test7", null, null);
    }

    public static void main(String[] args)
    {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
}
