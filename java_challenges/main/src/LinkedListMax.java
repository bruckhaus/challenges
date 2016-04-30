class Node {
    int value;
    Node next;

    public Node(int v) {
        value = v;
        next = null;
    }

    public static int max(Node n) {
        if (n == null) return Integer.MIN_VALUE;
        return Math.max(n.value, max(n.next));
    }
}

class LinkedList {

    private Node first;
    private Node last;

    public LinkedList(int value) {
        Node n = new Node(value);
        first = n;
        last = n;
    }

    public void append(int i) {
        last.next = new Node(i);
        last = last.next;
    }

    public int max() {
        return Node.max(first);
    }
}