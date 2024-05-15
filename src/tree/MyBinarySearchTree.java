package tree;

import java.util.Iterator;
import java.util.Stack;

public class MyBinarySearchTree<K extends Comparable<K>, V> {
    private Node<K, V> root;

    private int size = 0;

    /**
     * Node class for the binary search tree.
     * This class is a generic class that can store any type of key and value.
     */
    public static class Node<K, V> {

        private K key;
        private V value;
        private Node<K, V> left, right;
        // Node constructor

        public Node(K key, V value) {
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
     * Insert a new node in the tree
     * If the key already exists, update the value
     * If the key does not exist, insert a new node
     *
     * @param x     Node
     * @param key   key of the node to be inserted in the tree
     * @param value value of the node to be inserted in the tree
     * @return Node
     */
    private Node<K, V> put(Node<K, V> x, K key, V value) {
        if (x == null) {
            size++;
            return new Node<>(key, value);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        return x;
    }

    public int getSize() {
        return size;
    }

    public V get(K key) {
        return get(root, key);
    }

    /**
     * Find the value of the key in the tree
     * If the key is not found, return null
     * This method is a recursive method that searches the tree for the key
     *
     * @param x   Node
     * @param key key of the node to be found in the tree
     * @return value of the key in the tree
     */
    private V get(Node<K, V> x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.value;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    /**
     * Delete the node with the key from the tree
     *
     * @param x   Node
     * @param key key of the node to be deleted in the tree
     * @return Node of the tree
     */
    private Node<K, V> delete(Node<K, V> x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            size--;
            if (x.right == null && x.left == null) return x;
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node<K, V> t = min(x.left);
            x.key = t.key;
            x.value = t.value;
        }
        return x;
    }

    /**
     * Find the minimum node in the tree
     *
     * @param x Node
     * @return minimum node in the tree
     */
    private Node<K, V> min(Node<K, V> x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Iterator<Node<K, V>> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<Node<K, V>> {
        private final Stack<Node<K, V>> stack;

        public Iter() {
            this.stack = new Stack<>();
            addTree(root);
        }

        /**
         * Add the tree to the stack
         *
         * @param node Node
         */
        private void addTree(Node<K, V> node) {
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
        public Node<K, V> next() {
            return stack.pop();
        }
    }

}
