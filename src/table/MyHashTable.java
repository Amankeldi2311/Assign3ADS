package table;

/**
 * Class that realizes a hash table with separate chaining.
 * This class is a generic class that can store any type of key and value.
 * The hash table is implemented with an array of linked lists.
 *
 * @param <K> Type of the key,that will be used to store the value.
 * @param <V> Type of the value, that will be stored in the hash table.
 */
public class MyHashTable<K, V> {

    /**
     * HashNode class for the hash table.
     * This class is a generic class that can store any type of key and value.
     *
     * @param <K> Immutable type of the key.
     * @param <V> Any Object type.
     */
    private static class HashNode<K, V> {

        K key;
        V value;
        HashNode<K, V> next;

        /**
         * Creates a new HashNode with the given key and value.
         *
         * @param key   Key of the HashNode.
         * @param value Value of the HashNode.
         */
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Array that stores nodes of the hash table.
     */
    private HashNode<K, V>[] chainArray;
    private static final int M = 11;
    private int size;

    /**
     * Creates a new hash table with the given size.
     * The size of the hash table is the size of the array.
     *
     * @param M Size of the hash table.
     */
    public MyHashTable(int M) {
        chainArray = new HashNode[M];
        size = 0;
    }

    /**
     * Default constructor that creates a new hash table with the default size.
     */
    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    /**
     * Using default hash function to get the hash of the key.
     *
     * @param key key for node
     * @return Index of the key
     */
    private int hash(K key) {
        return key.hashCode();
    }

    /**
     * This method takes hash code of the key and calculates the index of the key.
     *
     * @param key key for calculating index
     * @return Index position of the key
     */
    private int getIndex(K key) {
        return Math.abs(hash(key) % M);
    }

    /**
     * Adds a new key and value to the hash table.
     *
     * @param key   key to be put in the hash table
     * @param value value to be put in the hash table
     */
    public void put(K key, V value) {
        int index = getIndex(key);
        HashNode<K, V> head = chainArray[index];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = chainArray[index];
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        chainArray[index] = newNode;
        size++;
    }

    public int getSize() {
        return size;
    }

    /**
     * This method finds the value of the key in the hash table.
     * If the key is not found, it returns null.
     *
     * @param key key to get the value
     * @return value of the key
     */
    public V get(K key) {
        int index = getIndex(key);
        HashNode<K, V> head = chainArray[index];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * This method removes the key and value from the hash table.
     *
     * @param key key for removing the value
     * @return Value of the key that is removed or null if the key is not found.
     */
    public V remove(K key) {
        int index = getIndex(key);
        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        if (prev != null) {
            prev.next = head.next;
        } else {
            chainArray[index] = head.next;
        }
        size--;
        return head.value;
    }

    /**
     * This method returns the number of key-value pairs in the hash table.
     *
     * @param value value for finding the key in key-value pair
     * @return key or null if the value is not found
     */
    public K getKey(V value) {
        for (HashNode<K, V> node : chainArray) {
            while (node != null) {
                if (node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }

    /**
     * This method returns true if the value is found in the hash table.
     * Otherwise, it returns false.
     *
     * @param value value for finding the key in key-value pair
     * @return true if the value is found in the hash table, false otherwise
     */
    public boolean contains(V value) {
        return getKey(value) != null;
    }
}
