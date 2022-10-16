package cs502;

public class Test4 {
    public static void main(String[] args) {
        A x1;
        A x2;
        B x3;
        int o;
        int t1;
        int t2;
        int t3;
        boolean temp;

        t1 = 4;
        t2 = 5;
        t3 = 6;

        x1 = new B();
        x2 = new C();
        x3 = new C();

        x1.f1 = t1;
        x2.f1 = t2;
        x3.f1 = t3;

        o = x1.set(1);
        o = x2.set(2);
        o = x3.set(3);

        temp = true;
        while(temp) {
            t1 = x1.f1;
            t1 = t1 + 1;
            x1.f1 = t1;
            o = o + 1;
            temp = o < 10;
        }

        o = x1.f1;
        System.out.println(o);

        temp = o < 20;
        if (temp) {
            o = 20;
        }
        else {
        }
        System.out.println(o);

        o = x3.sm(4);
        System.out.println(o);
    }
}

class A {
    int f1;

    public int set(int x) {
        f1 = x;
        return 1;
    }

    public int get() {
        return f1;
    }
}

class B extends A {
    int f1;

    public int set(int x) {
        f1 = x;
        return 1;
    }

    public int get() {
        return f1;
    }

    public int sm(int x) {
        boolean temp;
        int res;
        int temp2;
        B temp3;

        temp3 = new B();
        temp = x < 2;
        if (temp) {
            res = 1;
        }
        else {
            temp2 = x - 1;
            temp2 = temp3.sm(temp2);
            res = x + temp2;
        }

        return res;
    }
}

class C extends B {
    int f1;

    public int set(int x) {
        f1 = x;
        return 1;
    }

    public int get() {
        return f1;
    }
}