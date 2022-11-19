class Test4 {
    public static void main(String[] args) {
        System.out.println(true + 1); // binop error
    }
}

class A4 {
    public int func(int z) {
        B4 b;
        int x;
        int k;
        boolean y;
        float f;
        b = new A4(); // assignment error.
        y = true;
        f = 1.05; // no error.
        x = 0;
        x = y; // assignment error.
        y = x + 5; // assignment error.
        z = x + 5;
        if (z) { // control flow error.
            x = x + 1;
        } else {
            x = x - 1;
        }
        if (z <= 0) {
            y = false;
        }
        k = this.test(f, 5); // 1 function error.
        return 1.01; // 1 function error.
    }

    public int test(int g, float c) {
        int p;
        p = this.func(6.5); // 1 function error.
        return 5;
    }
}

class B4 extends A4 {

}