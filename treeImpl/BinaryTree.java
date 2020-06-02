import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {

    Node root = null;
    /** Root node */
    public void insert(int data) {
        root = addRecursive(root, data);
    }
    
    /** Tree Forming */
    private Node addRecursive(Node currentNode, int data) {
        //fEmpty tree
        if (currentNode == null) {
            return new Node(data);
        } else if (data <= currentNode.data) {  //Equal data is consist in left sub tree :-
            currentNode.left = addRecursive(currentNode.left, data);
        } else {
            currentNode.right = addRecursive(currentNode.right, data);
        }
        return currentNode;
    }

    public Node getRootNode() {
        return root;
    }

    /** print format */
    /** root -> left -> right*/
    public void traversePreOrder(Node currentNode) {
        if(currentNode != null) {
            System.out.print(currentNode.data + " ");
            traversePreOrder(currentNode.left);
            traversePreOrder(currentNode.right);
        }
    }

    /** print format */
    /** left -> root -> right*/
    public void traverseInOrder(Node currentNode) {
        if(currentNode != null) {
            traverseInOrder(currentNode.left);
            System.out.print(currentNode.data + " ");
            traverseInOrder(currentNode.right);
        }
    }

    /** print format */
    /** left -> right -> root */
    public void traversePostOrder(Node currentNode) {
        if(currentNode != null) {
            traversePostOrder(currentNode.left);
            traversePostOrder(currentNode.right);
            System.out.print(currentNode.data + " ");
        }
    }

    public int finMinimum(Node currentNode) {
        if(currentNode == null) {
            System.out.println("Tree is Empty");
            return -1;
        }else if(currentNode.left == null) {
            return currentNode.data;
        }
        return finMinimum(currentNode.left);
    }

    public int findMaximum(Node currentNode) {
        if(currentNode == null) {
            System.out.println("Tree is Empty");
            return -1;
        }else if(currentNode.right == null) {
            return currentNode.data;
        }
        return findMaximum(currentNode.right);
    }

    public boolean isAvailable(Node currentNode, int data) {
        if(currentNode == null) {
            return false;
        }else if(currentNode.data == data) {
            return true;
        }
        return data <= currentNode.data ? isAvailable(currentNode.left, data) : isAvailable(currentNode.right, data);
    }

    /** Must again study */
    public int findHeightOfTree(Node currentNode) {
        if (currentNode == null) {
            return -1;
        }
        int leftHeight = findHeightOfTree(currentNode.left);
        int rightHeight = findHeightOfTree(currentNode.right);
        return Math.max(leftHeight, rightHeight);
    }

    /** Level Order Traverse */
    private Queue queue = new Queue();
    public void levelOrderTraverse(Node rootNode) {
        if(rootNode == null) {
            return;
        }

        /** while there is at least one discovered node */
        queue.enQueue(rootNode);
        while (!queue.isEmpty()) {
            //Current Node -> is Tree Node (parent node) :-
            Node currentNode = queue.deQueue();
            System.out.print(currentNode.data + " ");
            if(currentNode.left != null) queue.enQueue(currentNode.left);
            if(currentNode.right != null) queue.enQueue(currentNode.right);
        }
    }

    /** Check Binary Tree is Binary Search Tree or Not */
    /** Upper and Lower Bond */
    public boolean isBinaryTree(Node rootNode) {
        return utilIsBinaryTree(rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean utilIsBinaryTree(Node currentNode, int minValue, int maxValue) {
        if(currentNode == null) {
            return true;
        }
        return currentNode.data > minValue && currentNode.data < maxValue
                && utilIsBinaryTree(currentNode.left, minValue, currentNode.data)
                && utilIsBinaryTree(currentNode.right, currentNode.data, maxValue);
    }

    public Node remove(Node currentNode, int data) {
        if (currentNode == null) {
            return null;
        }else if (data < currentNode.data) {
            currentNode.left = remove(currentNode.left, data);
        }else if (data > currentNode.data) {
            currentNode.right = remove(currentNode.right, data);
        }else {
            //case 1 :- No child
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            }
            //case 2 :- One child
            if (currentNode.left == null) {
                return currentNode.right;
            }
            if (currentNode.right == null) {
                return currentNode.left;
            }
            //case 3 :- Two child -> remove node -> rearrange inorder predecessor( left sub tree maximum ) or inorder successor ( right sub tree minimum )
            int temp = finMinimum(currentNode.right);
            currentNode.data = temp;
            currentNode.right = remove(currentNode.right, temp);
            return currentNode;
        }
        return currentNode;
    }
    
    public void invertBinaryTree(Node currentNode) {
        
        if (currentNode == null) 
            return;
        
        invertBinaryTree(currentNode.left);
        invertBinaryTree(currentNode.right);
        
        Node temp = currentNode.left;
        currentNode.left = currentNode.right;
        currentNode.right = temp;
    }

    /** AVL Tree */ // Balance Tree :-
    /** Red Black Tree */
    
    
    
    
    
    
   /** Cousins in Binary Tree */
    
    
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        int first = findDepth(root, x, 1);
        int second = findDepth(root, y, 1);
        
        if (first != second) 
            return false;
        
        TreeNode node = findParant(root, root, x);
        
        if (node.left == null || node.right == null)
            return true;
        
        if (node.left.val == x && node.right.val == y || node.left.val == y && node.right.val == x)
            return false;
        
        return true;
            
    }
    
    private TreeNode findParant(TreeNode root, TreeNode parantNode, int data) {
        if (root == null) 
            return null;
        
        if (root.val == data) 
            return parantNode;
        
        TreeNode nod = findParant(root.left, root, data);
        
//         return (nod != null) ? nod : findParant(root.right, root, data);
        
        if (nod != null)
            return nod; 
        
        return findParant(root.right, root, data);
    }
    
    private int findDepth(TreeNode root, int data, int dpt) {
        if (root == null)
            return 0;
        
        if (root.val == data)
            return dpt;
        
        int level = findDepth(root.left, data, dpt + 1);
        
        //return (level != 0) ? level : findDepth(root.right, data, dpt + 1); 
        
        if (level != 0)
            return level;
        
        return findDepth(root.right, data, dpt + 1);
    }
}

}
