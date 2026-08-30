/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // A -> B -> C
    // A -> A` -> B -> B` -> C -> C`
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node ptr = head;
        while (ptr  != null) {
            Node newNode = new Node(ptr.val, null, null);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = ptr.next.next;
        }

        ptr = head;

        while (ptr != null) {
            ptr.next.random = ptr.random != null? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        Node ptr_old_list = head;
        Node ptr_new_list = head.next;
        Node new_head = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = ptr_new_list.next != null?  ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }

        return new_head;
    }
}