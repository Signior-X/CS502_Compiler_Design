package cs502;

public class Test1 {
    public static void main(String[] args) {
        A a;
        int r;
        int p;
        a = new A();

        p = a.x;
        a.x = p;
    }
}

class A {
    int x;
    int y;

    public int m1(int z) {
        int t1;
        int t2;

        t1 = x + y;
        t2 = t1 + z;
        return t2;
    }


    public int m2() {
        return x;
    }

    public int m3() {
        System.out.println(3);
        return 3;
    }

    public int m4() {
        System.out.println(4);
        return 4;
    }

}