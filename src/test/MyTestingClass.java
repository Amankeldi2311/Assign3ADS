package test;

import table.MyHashTable;

public class MyTestingClass {


    public void test() {
        MyHashTable<MyTestK, MyStudent> testHighLoad = new MyHashTable<>();
        for (int i = 0; i < 10001; i++) {
            MyTestK key = new MyTestK(i, "Aman");
            MyStudent value = new MyStudent(i);
            testHighLoad.put(key, value);
        }
        System.out.println(testHighLoad.getSize());

        MyTestK key = new MyTestK(12500, "Aman");
        System.out.println(testHighLoad.get(key));

    }
}
