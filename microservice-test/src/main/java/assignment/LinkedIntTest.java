package assignment;

import com.fasterxml.jackson.databind.util.LinkedNode;

public class LinkedIntTest {

    private int size;


    private class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
}
