class Test6 {
    public static void main(String[] args) {
        System.out.println((10 + 20.5) * (false + true)); // 2 Binop error
    }
}

class A6 {
    public int foo6(int a, float b, boolean c, int d) {
        int k;
        int m;
        k = (a + 10) + false; // 1 binop error + 1 assignment error.
        m = a + (10 + false); // 2 binop error + 1 assignment error.
        if (false)
            m = 20;
        if (true)
            m = 10;
        return m;
    }

    public int bar6(int a) {
        A6 b;
        int k;
        b = new A6();
        k = b.foo6(10.01, 10, 20, 20);// 2 function errors.
        return false; // 1 function error.
    }
}