package LR3;

public class MyLinkedList {
    // Внутренний класс узла
    private static class Node {
        int value;
        Node next;
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head; // ссылка на первый элемент

    // методы с циклами

    // 1. Создание списка с головы (первым передаётся первый элемент)
    public void createHead(int... values) {
        head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            head = new Node(values[i], head);
        }
    }

    // 2. Создание списка с хвоста (сохраняет порядок)
    public void createTail(int... values) {
        head = null;
        Node tail = null;
        for (int v : values) {
            Node newNode = new Node(v, null);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
    }

    // 3. Вывод списка в строку
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

    // 4. Добавление в начало
    public void addFirst(int value) {
        head = new Node(value, head);
    }

    // 5. Добавление в конец
    public void addLast(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // 6. Вставка по индексу (0 – начало)
    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) throw new IndexOutOfBoundsException();
            current = current.next;
        }
        current.next = new Node(value, current.next);
    }

    // 7. Удаление первого элемента
    public void removeFirst() {
        if (head != null) head = head.next;
    }

    // 8. Удаление последнего элемента
    public void removeLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // 9. Удаление элемента по индексу
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null || current.next == null) throw new IndexOutOfBoundsException();
            current = current.next;
        }
        current.next = current.next.next;
    }

    // рекурсивные методы

    // 10. Создание списка с головы (рекурсия)
    public void createHeadRec(int... values) {
        head = createHeadRecHelper(values, 0);
    }

    private Node createHeadRecHelper(int[] values, int idx) {
        if (idx >= values.length) return null;
        return new Node(values[idx], createHeadRecHelper(values, idx + 1));
    }

    // 11. Создание списка с хвоста (рекурсия)
    public void createTailRec(int... values) {
        head = createTailRecHelper(values, 0);
    }

    private Node createTailRecHelper(int[] values, int idx) {
        if (idx >= values.length) return null;
        Node node = new Node(values[idx], null);
        node.next = createTailRecHelper(values, idx + 1);
        return node;
    }

    // 12. Рекурсивный вывод в строку
    public String toStringRec() {
        return toStringRecHelper(head);
    }

    private String toStringRecHelper(Node node) {
        if (node == null) return "";
        String rest = toStringRecHelper(node.next);
        return rest.isEmpty() ? String.valueOf(node.value) : node.value + " " + rest;
    }

    // тестирование
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // Циклические методы
        System.out.println("=== Циклические методы ===");
        list.createHead(3, 2, 1);
        System.out.println("createHead(3,2,1): " + list.toString());
        list.createTail(4, 5, 6);
        System.out.println("createTail(4,5,6): " + list.toString());
        list.addFirst(0);
        System.out.println("addFirst(0): " + list.toString());
        list.addLast(7);
        System.out.println("addLast(7): " + list.toString());
        list.insert(2, 99);
        System.out.println("insert(2,99): " + list.toString());
        list.removeFirst();
        System.out.println("removeFirst(): " + list.toString());
        list.removeLast();
        System.out.println("removeLast(): " + list.toString());
        list.remove(2);
        System.out.println("remove(2): " + list.toString());

        // Рекурсивные методы
        System.out.println("\n=== Рекурсивные методы ===");
        MyLinkedList list2 = new MyLinkedList();
        list2.createHeadRec(10, 20, 30);
        System.out.println("createHeadRec(10,20,30): " + list2.toStringRec());
        list2.createTailRec(40, 50, 60);
        System.out.println("createTailRec(40,50,60): " + list2.toStringRec());
    }
}
