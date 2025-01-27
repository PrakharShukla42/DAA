import java.util.*;
class BinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    Node root;
    public BinaryTree() {
        root = null;
    }
    // Inorder Traversal (DFS)
    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    // Preorder Traversal (DFS)
    public void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }
    // Postorder Traversal (DFS)
    public void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }
    // Level Order Traversal (BFS)
    public void levelOrder(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.data + " ");

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }
    // Binary Search Tree (BST) insert method
    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        return node;
    }
    // Utility function to test tree traversals
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Constructing a Binary Search Tree (BST)
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        System.out.println("Inorder Traversal (DFS):");
        tree.inorder(tree.root);

        System.out.println("\nPreorder Traversal (DFS):");
        tree.preorder(tree.root);

        System.out.println("\nPostorder Traversal (DFS):");
        tree.postorder(tree.root);

        System.out.println("\nLevel Order Traversal (BFS):");
        tree.levelOrder(tree.root);
    }
}
