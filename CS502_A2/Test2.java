class Test2 {
    public static void main(String[] args) {
        System.out.println(10+10.5);
    }
}

class A {
    public float bar(boolean b) {
        int a;
        float f;
        a = 10;
        f = 10;
        // NOTE: Assignment of int to float is allowed, but not vice versa
        f = a;
        f = f * f;
        a = a - a;
        if (a <= f) {} // 1 Control error
        return a; // 1 Function error
    }

    public int test(A o1) {
        return 0;
    }

    public int priyam2() {
        return 1;
    }

    public boolean priyam(int a, int b, int c) {
        return true;
    }

    public boolean foo(float p) {
        int a;
        boolean c;
        Test4 t;
        A o1;
        B o2;
        C o3;
        c = false;
        t = new Test4();
        o1 = new B();
        o2 = new B();
        o3 = new C();
        // c = (o1 != o2);
        c = o2.priyam(1, 2, 3);
        p = ((10 + (10.1 + 1)) + 10); // 3 Binop errors, 1 Assignment error
        p = 20;
        p = this.bar(c);
        p = this.test(o1);
        p = this.test(o2);
        p = this.test(o3); // 1 Function error, 1 Assignment error
                           // Each argument matching failure
                           // will be a separate Function error
        c = (a <= p); // 1 Assignment error
        return c;
    }
}

class B extends A {}

class C extends B {}