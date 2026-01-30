class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    ListNode head;

    public void insert(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void traverse() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public int getNthElement(int n) {
        ListNode temp = head;
        int count = 1;
        while (temp != null) {
            if (count == n) {
                return temp.data;
            }
            temp = temp.next;
            count++;
        }
        throw new IndexOutOfBoundsException("List has fewer than " + n + " elements.");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        for (int i = 1; i <= 10; i++) {
            list.insert(i * 10);
        }

        list.traverse();
        System.out.println("4th element: " + list.getNthElement(4));
    }
}