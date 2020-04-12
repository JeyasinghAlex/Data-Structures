public class Queue {

    private LinkedList list = new LinkedList();
    public void enQueue(Node node) {
        list.insertDataAtBack(node);
    }

    public Node deQueue() {
        return list.removeDataAtFront();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
