class Test11 {
    public static void main(String[] args) {
        System.out.println(10);
    }
}

class A {
    public int foo(boolean b) {
    	return false; // 1 function error
    }

    public int bar(boolean b) {
        int a;
        int b;
        A o1;
        o1 = new A();
        a = 10;
        b = o1.foo(); // 1 function error
    	return a + b;
    }
}

