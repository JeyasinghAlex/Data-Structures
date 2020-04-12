public class Node {
    /** Tree */
    int data;
    Node left;
    Node right;

    /** Linked List */
    Node next;
    Node dataNode;

    /** Tree */
    public Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    /** Linked List */
    public Node(Node node) {
        this.dataNode = node;
        this.next = null;
    }
}
