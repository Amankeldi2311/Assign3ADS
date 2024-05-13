package test;

import table.MyHashTable;

public class MyTestingClass {


    public void test() {
        MyHashTable<MyTestK, MyStudent> testHighLoad = new MyHashTable<>();
        for (int i = 0; i < 10000; i++) {
            MyTestK key = new MyTestK(i);
            MyStudent value = new MyStudent(i);
            testHighLoad.put(key, value);
        }
    }
}
