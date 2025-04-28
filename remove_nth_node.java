// ListNode class definition
class ListNode {
    int val;
    ListNode next;

    // Constructor to create a new node with value
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class remove_nth_node {
    public ListNode removeNthListNode(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        
        // Move the fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) return null;  // In case n is greater than the length of the list
            fast = fast.next;
        }

        // If fast is null, it means we need to remove the first node
        if (fast == null) {
            return head.next;
        }

        // Move both slow and fast pointers until fast reaches the end
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the N-th node from the end
        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        remove_nth_node solution = new remove_nth_node();  // Corrected to use Solution class

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Remove the 2nd node from the end: 1 -> 2 -> 3 -> 5
        head = solution.removeNthListNode(head, 2);

        // Print the modified linked list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

