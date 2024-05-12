package test;

import table.MyHashTable;

public class MyTestk {
    public void test() {
        MyHashTable<MyTestingClass, MyStudent> testHighLoad = new MyHashTable<>();
        for(int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(i^0xddddd);
            MyStudent value = new MyStudent(i);
            testHighLoad.put(key, value);
        }
    }
}
