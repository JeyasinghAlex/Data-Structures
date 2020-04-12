public class TreeMain {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
       tree.insert(12);
       tree.insert(5);
       tree.insert(15);
       tree.insert(3);
       tree.insert(7);
       tree.insert(13);
       tree.insert(17);
       tree.insert(16);
       tree.insert(19);
        tree.traversePreOrder(tree.getRootNode());
        System.out.println();
        tree.traverseInOrder(tree.getRootNode());
        System.out.println();
        tree.traversePostOrder(tree.getRootNode());
        System.out.println();
        System.out.println("Minimum is - " + tree.finMinimum(tree.root));
        System.out.println("Maximum is - " + tree.findMaximum(tree.root));
        System.out.println(tree.isAvailable(tree.getRootNode(), 2) ? "True" : "False");
        tree.levelOrderTraverse(tree.getRootNode());
        System.out.println();
        System.out.println(tree.isBinaryTree(tree.getRootNode()));
        tree.remove(tree.getRootNode(), 17   );
        tree.traverseInOrder(tree.getRootNode());
    }
}
