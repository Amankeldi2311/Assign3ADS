package tree;

import java.util.Iterator;
import java.util.Stack;

public class MyBinarySearchTree<K extends Comparable <K>, V> {
    private Node root;

    /**
     * Node class for the binary search tree.
     * This class is a generic class that can store any type of key and value.
     */
    public class Node {
        private K key;
        private V value;
        private Node left, right;
        // Node constructor
        public Node (K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    /**
     * @param x Node
     * @param key key of the node to be inserted in the tree
     * @param value value of the node to be inserted in the tree
     * @return Node
     */
    private Node put(Node x, K key, V value) {
        if (x == null) return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        return x;
    }
    public V get(K key) {
        return get(root, key);
    }
    private V get(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.value;
    }

    public void delete(K key) {
        root = delete(root, key);
    }
    private Node delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null  && x.left == null) return x;
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = min(x.left);
            x.key = t.key;
            x.value = t.value;
        }
        return x;
    }
    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }
    public Iterator<Node> iterator() {
        return new Iter();
    }
    private class Iter implements Iterator<Node> {
        private final Stack<Node> stack;

        public Iter() {
            this.stack = new Stack<>();
            addTree(root);
        }
        private void addTree(Node node){
            if (node == null) return;
            addTree(node.left);
            stack.push(node);
            addTree(node.right);

        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Node next() {
            return stack.pop();
        }
    }

}
