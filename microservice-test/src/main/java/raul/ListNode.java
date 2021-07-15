package raul;

import java.util.List;

public class ListNode {

    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    static ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(10);
        ListNode node1 = new ListNode(14, node);
        ListNode node2 = new ListNode(3, node1);
        ListNode node3 = new ListNode(8, node2);

        ListNode result = reverse(node3);

        System.out.println(result);

    }


}
