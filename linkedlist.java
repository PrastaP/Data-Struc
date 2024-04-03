class Node {
    int item;
    Node next;
    Node(int item) {
        this.item = item;
        this.next = null;}}
public class linkedlist {
    private Node head;
    public linkedlist() {
        this.head = null;}
    public void add(int item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;}}
    public void removeAfter(Node node) {
        if (node == null || node.next == null) {
            return;}
        node.next = node.next.next;}
    public linkedlist copy(Node node) {
        linkedlist newList = new linkedlist();
        Node current = node;
        while (current != null) {
            newList.add(current.item);
            current = current.next;}
        return newList;}
    public void removeDuplicate(Node node, int key) {
        Node current = node;
        Node previous = null;
        while (current != null) {
            if (current.item == key) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;}
            } else {
                previous = current;}
            current = current.next;}}
    public int max(Node node) {
        if (node == null) {
            return 0;}
        int max = node.item;
        while (node != null) {
            if (node.item > max) {
                max = node.item;}
            node = node.next;}
        return max;}
    public static void main(String[]args)
    {linkedlist list = new linkedlist();
        list.add(3);
        list.add(6);
        list.add(9);
        list.add(3);
        list.add(12);

        System.out.println("og list:");
        Node current = list.head;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;}
        System.out.println();

        Node nodeToRemoveAfter = list.head.next.next;
        list.removeAfter(nodeToRemoveAfter);

        System.out.println("after removing node " + nodeToRemoveAfter.item + ":");
        current = list.head;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;}
        System.out.println();

        linkedlist newList = list.copy(list.head);

        System.out.println("copied list:");
        current = newList.head;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;}
        System.out.println();

        list.removeDuplicate(list.head, 3);

        System.out.println("list after 3 duplicates:");
        current = list.head;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;}
        System.out.println();

        int max = list.max(list.head);
        System.out.println("max value: " + max);}}
