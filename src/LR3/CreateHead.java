package LR3;

public class CreateHead {
    static class Node {
        int value;
        Node next;
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node head = null;
        for (int i = 5; i >= 1; i--) {
            head = new Node(i, head);
        }
        // Вывод списка для проверки
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }
}
