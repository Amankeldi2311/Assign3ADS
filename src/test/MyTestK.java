package test;

import table.MyHashTable;

/**
 * Testing class for MyStudent. This class used as student ID card.
 */
public class MyTestK {
    private int key;
    private String name;

    public MyTestK(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = key;
        if (name != null) {
            for (int i = 0; i < name.length(); i++) {
                result += name.charAt(i);
            }
        }
        return result;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
}
