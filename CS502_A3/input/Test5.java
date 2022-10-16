package cs502;

public class Test5 {
    public static void main(String[] args) {
        A obj;
        int ans;
        int t1;
        String var;

        obj = new A();
        t1 = 3;
        var = null;

        ans = obj.foo();
        System.out.println(ans);
        obj.x = t1;
        ans = obj.x;
        System.out.println(ans);
        ans = obj.baz(8);
        System.out.println(ans);

        t1 = 5;
        obj.y = t1;
        ans = obj.priyam(obj, var);
        System.out.println(ans);
    }
}

class A {
    int x;
    int y;

    public int foo() {
        int x;
        x = 5;
        return x;
    }

    public int bar() {
        return x;
    }

    public int baz(int x) {
        return x;
    }

    public int priyam(A obj, String x) {
        int ans;
        ans = obj.y;
        System.out.println(x);
        return ans;
    }
}