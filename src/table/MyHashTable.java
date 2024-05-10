package table;

public class MyHashTable<K, V> {

    private class HashNode<K, V> {

        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private HashNode<K, V>[] chainArray;
    private static final int M = 11;
    private int size;

    public MyHashTable(int M) {
        chainArray = new HashNode[M];
        size = 0;
    }

    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    private int hash(K key) {
        return key.hashCode();
    }

    private int getIndex(K key) {
        return Math.abs(hash(key) % M);
    }

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

    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> head = chainArray[i];
            while (head != null) {
                if (head.value.equals(value)) {
                    return head.key;
                }
                head = head.next;
            }
        }
        return null;
    }

    public boolean contains(V value) {
        return getKey(value) != null;
    }
}
