package cs502;

public class Test3 {
    public static void main(String[] args) {
        A a;
        A b;
        B c;
        int o;

        a = new A();
        b = new B();
        c = new B();

        o = a.set(1, 2);
        System.out.println(o);
        o = b.set(3, 4);
        System.out.println(o);
        o = c.set(5, 6);
        System.out.println(o);

        o = a.f1;
        System.out.println(o);
        o = b.f1;
        System.out.println(o); // TO CHECK
        o = c.f1;
        System.out.println(o);

        o = a.get();
        System.out.println(o);
        o = b.get();
        System.out.println(o);
        o = c.get();
        System.out.println(o);
    }
}

class A {
    int f1;

    public int set(int x, int y) {
        f1 = x;
        return y;
    }

    public int get() {
        return f1;
    }
}

class B extends A {
    int f1;

    public int get() {
        return f1;
    }
}
