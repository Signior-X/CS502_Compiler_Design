class Test2 {
    public static void main(String[] args) {
        System.out.println(10);
    }
}

class A2 {
    public int bar() {
        int a;
        int b;
        B2 obj;
        a = 10;
        b = 20;
        obj = new B2();
        a = obj.fooB(a); // 1 function error.
        a = obj.fooB(a, b);
        a = this.foo();
        a = this.bar();
        return 0;
    }

    public int foo() {

        return 1;
    }
}

class B2 extends A2 {
    public int fooB(int a, int b) {
        return a + b;
    }

}
