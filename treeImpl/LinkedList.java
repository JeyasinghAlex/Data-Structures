public class LinkedList {

    Node headNode = null;
    Node tailNode  = null;

    public void insertDataAtBack(Node dataNode) {
        Node node = new Node(dataNode);
        if(headNode == null) {
            headNode = node;
            tailNode = node;
        }else{
            tailNode.next = node;
            tailNode = node;
        }
    }

    public Node removeDataAtFront() {
        if(headNode == null) {
            return null;
        }

        Node dataNode = headNode.dataNode;
        headNode = headNode.next;

        /** if only one data */
        if(headNode == null) {
            tailNode = null;
        }
        return dataNode;
    }

    public boolean isEmpty() {
        return headNode == null;
    }
}
