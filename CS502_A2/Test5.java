class Test2 {
    public static void main(String[] args) {
        System.out.println(args);
    }

}

class A {
    public boolean bar(boolean b) {
        int a;
        boolean f;
        if ((a + f) != 5) { // 2 Binop error
            b = true;
        } // 1 Control error
        f = a && f; // assn err // 1 binop err
        if (!a) { // 1 ctrl err
        }

        return b; // 1 Function error
    }
}
