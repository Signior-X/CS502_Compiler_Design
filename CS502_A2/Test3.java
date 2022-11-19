class Test1 {
    public static void main(String[] args) {
        System.out.println(10+true); // 1 Binop error
    }
}

class A {
    public int bar(boolean b) {
        int a;
        float f;
        a = 10;
        f = 10;
        // NOTE: Assignment of int to float is allowed, but not vice versa
        f = a;
        a = f; // 1 Assignment error
        a = b; // 1 Assignment error
        if (a + f) {} // 1 Control error
        return b; // 1 Function error
    }

    public int test(A o1) {
        return 0;
    }

    public boolean foo(int p) {
        int a;
        boolean c;
        float d;
        Test1 t;
        A o1;
        B o2;
        C o3;
        D e;
        d = a*d;
        c = false;
        e = new D();
        t = new Test1();
        o1 = new B();
        o2 = new B();
        o3 = new C();
        a = ((10 + (10.1 + t)) + 10); // 3 Binop errors, 1 Assignment error
        a = ((10 + 10.1 )+ t); // 1 Binop error, 1 Assignment error
        a = 10 + (10.1 + t); // 2 Binop errors, 1 Assignment error
        a = (10 - ( 12* ( 19 - t ))); // 3 binop errors , 1 assignment error
        p = 20;
        p = 10/t; // 1 binop error, 1 assignmet error
        if(o1 != o2) {}
        if(o1 <= o2) {} // 1 Control error, 1 binop error
        if(( true && 5 )) {} // 1 Control error, 1 binop error
        if(( (!3) && 5 )) {} // 1 Control error, 1 binop error
        if(( (this.bar(c)) && (this.test(o1)) )) {} // 1 Control error, 1 binop error
        if(( (this.bar(c)) && true )) {} // 1 Control error, 1 binop error
        if(( (this.bar(c)) && 5 )) {} // 1 Control error, 1 binop error
        if(( (this.bar(c)) || 5 )) {} // 1 Control error, 1 binop error
        p = this.bar(c);
        p = this.test(o1);
        p = this.test(o2);
        p = this.test(o3);
        p = new B().test(e);
        p = (this.test(o3)) + (this.test(e));
                           // Each argument matching failure
                           // will be a separate Function error
        c = a + p; // 1 Assignment error
        p = a + p;
        return c;
    }

    public int test1(A o1) {
        return 0;
    }

}

class B extends A {
    public int food(int a, boolean b){
        return 1;
    }
}

class C extends B {
    public int food2(int a, boolean b){
        return 1;
    }
}

class D {}