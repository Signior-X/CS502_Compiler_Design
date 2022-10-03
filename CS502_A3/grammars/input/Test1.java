package cs502;

public class Test1 {
    public static void main(String[] args) {
        A a;
        int r;
        a = new A();
        r = a.m1(10);
        System.out.println(r);
        r = a.m3();
        System.out.println(r);
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
        // this.x is not possible
        // so don't worry
        // ASK - What about global vars update
        // from one method
        // x = 3;

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
