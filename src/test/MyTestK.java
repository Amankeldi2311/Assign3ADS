package test;

import table.MyHashTable;

public class MyTestK {
    private int key;
    public MyTestK(int key) {
        this.key = key;
    }


    @Override
    public int hashCode() {
        return key * 10;
    }
}
