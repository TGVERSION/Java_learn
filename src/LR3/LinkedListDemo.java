package LR3;

public class LinkedListDemo {
    public static void main(String[] args) {
        // Построение с головы
        Node head = null;
        for (int i = 5; i >= 1; i--) {
            head = new Node(i, head);
        }
        System.out.print("Список (голова): ");
        printList(head);

        // Построение с хвоста
        Node head2 = null;
        Node tail = null;
        for (int i = 1; i <= 5; i++) {
            Node newNode = new Node(i, null);
            if (head2 == null) {
                head2 = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        System.out.print("Список (хвост): ");
        printList(head2);
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}

