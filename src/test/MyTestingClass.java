package test;

public class MyTestingClass {
    private int key;

public MyTestingClass(int key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
    int temp = key;
    temp >>>= 16;
    return temp ^ 0xbbbbbbb;
    }
}
