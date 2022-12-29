public class BinarySearchTree {

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {
        this.root = insert(root, data);
    }

    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data >= data)
            root.left = insert(root.left, data);
        else root.right = insert(root.right, data);
        return root;
    }

    public boolean search(int data) {
        return search(this.root, data);
    }

    private boolean search(Node root, int data) {
        if (root == null)
            return false;
        if (root.data == data)
            return true;
        if (root.data > data)
            return search(root.left, data);
        return search(root.right, data);
    }

    public String toString() {
        return toString(root);
    }

    public String toString(Node root) {
        if (root == null) {
            return "";
        }
        return (toString(root.left) + root.data + " " + toString(root.right));
    }
}