import table.MyHashTable;

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
    }
}
