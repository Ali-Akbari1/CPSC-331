import java.util.ArrayList;


public class BinarySearchTree<T extends Comparable<T>> implements BinarySearchTreeInterface<T> {
    private class Node {
        T data;
        Node left, right;

        Node(T data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;
    private ArrayList<T> traversalList;
    private int current;

    public BinarySearchTree() {
        root = null;
        traversalList = new ArrayList<>();
        current = -1;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public void add(T element) {
        root = addRecursive(root, element);
    }

    private Node addRecursive(Node current, T element) {
        if (current == null) {
            return new Node(element);
        }

        if (element.compareTo(current.data) < 0) {
            current.left = addRecursive(current.left, element);
        } else if (element.compareTo(current.data) > 0) {
            current.right = addRecursive(current.right, element);
        } else {
            return current;
        }

        return current;
    }

    @Override
    public boolean contains(T element) {
        return containsRecursive(root, element);
    }

    private boolean containsRecursive(Node current, T element) {
        if (current == null) {
            return false;
        }

        if (element.compareTo(current.data) == 0) {
            return true;
        }

        return element.compareTo(current.data) < 0
            ? containsRecursive(current.left, element)
            : containsRecursive(current.right, element);
    }

    @Override
    public void remove(T element) {
        root = removeRecursive(root, element);
    }

    private Node removeRecursive(Node current, T element) {
        if (current == null) {
            return null;
        }

        if (element.compareTo(current.data) == 0) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            T smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = removeRecursive(current.right, smallestValue);
            return current;
        }

        if (element.compareTo(current.data) < 0) {
            current.left = removeRecursive(current.left, element);
        } else {
            current.right = removeRecursive(current.right, element);
        }
        return current;
    }

    private T findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    @Override
    public void reset(int order) {
        traversalList.clear();
        current = 0;
        switch (order) {
            case 0: // Inorder
                inorderRecursive(root);
                break;
            case 1: // Preorder
                preorderRecursive(root);
                break;
            case 2: // Postorder
                postorderRecursive(root);
                break;
            default:
                throw new IllegalArgumentException("Invalid order: " + order);
        }
    }

    @Override
    public T getNext(int order) {
        if (current >= 0 && current < traversalList.size()) {
            return traversalList.get(current++);
        }
        return null;
    }

    @Override
    public void inorderTraversal() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.data + " ");
            inorderRecursive(node.right);
        }
    }

    @Override
    public void postorderTraversal() {
        postorderRecursive(root);
        System.out.println();
    }

    private void postorderRecursive(Node node) {
        if (node != null) {
            postorderRecursive(node.left);
            postorderRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }

    @Override
    public void preorderTraversal() {
        preorderRecursive(root);
        System.out.println();
    }

    private void preorderRecursive(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderRecursive(node.left);
            preorderRecursive(node.right);
        }
    }

    public T findMax() {
        if (isEmpty()) {
            return null; 
        }
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public T findMin() {
        if (isEmpty()) {
            return null; 
        }
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    // Function to remove odd Values
    public void removeOddValues() {
        root = removeOddRecursive(root);
    }
    
    // Function to remove odd Values
    private Node removeOddRecursive(Node current) {
        if (current == null) {
            return null;
        }
    
        // Recursively remove odd values from left and right subtrees
        current.left = removeOddRecursive(current.left);
        current.right = removeOddRecursive(current.right);
    
        // Check if the current node's data is odd, and remove it if so
        if (current.data instanceof Integer) {
            Integer value = (Integer) current.data;
            if (value % 2 != 0) {
                if (current.left == null){
                    return current.right;
                }
                else if (current.right == null){
                    return current.left;
                }
                else{
                    Node minCurrent = findMin(current.right);

                    current.data = minCurrent.data;
                    current.right = removeRecursive(current.right, minCurrent.data);

                }

        }
    }
    return current;
}

    // Function to find the minimum
    private Node findMin(Node current){
        while(current.left != null){
            current = current.left;
        }
        return current;
    }
    

     // Function to find the height of a tree
    public int findHeight(Node node){
        

        if (node == null){
            return 0;
        }

        else{
            int rightHeight = findHeight(node.right);
            int leftHeight = findHeight(node.left);

            if (leftHeight > rightHeight){
                return (leftHeight + 1);

            }
            else {
                return (rightHeight + 1);
            }

        }


    }

    
    // Getter Method
    public Node getRoot(){
        return root;
    }

    

   
}