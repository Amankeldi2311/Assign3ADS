import test.MyTestingClass;
import table.MyHashTable;


import tree.MyBinarySearchTree;

public class Main {
    public static void main(String[] args) {
        MyHashTable<String, Integer> hashTable = new MyHashTable<>();
        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);
        hashTable.put("four", 4);
        hashTable.put("five", 5);
        hashTable.put("six", 6);
        hashTable.put("seven", 7);
        hashTable.put("eight", 8);
        hashTable.put("nine", 9);
        hashTable.put("ten", 10);

        System.out.println(hashTable.get("one"));
        hashTable.remove("one");
        System.out.println(hashTable.get("one"));

        System.out.println(hashTable.getKey(10));

        MyBinarySearchTree<String, Integer> binarySearchTree = new MyBinarySearchTree<>();
        binarySearchTree.put("one", 1);
        binarySearchTree.put("two", 2);
        binarySearchTree.put("three", 3);
        binarySearchTree.put("four", 4);
        binarySearchTree.put("five", 5);
        binarySearchTree.put("six", 6);
        binarySearchTree.put("seven", 7);
        binarySearchTree.put("eight", 8);
        binarySearchTree.put("nine", 9);
        binarySearchTree.put("ten", 10);

        System.out.println(binarySearchTree.get("one"));
        binarySearchTree.delete("one");
        System.out.println(binarySearchTree.get("one"));



    }
}
