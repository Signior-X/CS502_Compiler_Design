package cs502;
// call from one class to other
public class Test1 {
    public static void main(String[] args) {
        E a;
        int a1;
        int a2;
        a = new E();
        a1 = a.m1(10);
        System.out.println(a1);
        a2 = a.m2();
        System.out.println(a2);
    }
}
class E {
    int x;
    int y;
    public int m1(int z) {
        int t1;
        int t2;
        t1 = x + y;
        t2 = t1 + z;
        return t2;
    }
    public int m2() {
        F b;
        int x;
        int q;
        int r;
    	
    	b = new F();
    	// to initialize
        x = b.m1(7);
        q = b.m2(9);
        r = b.m2(6);

        System.out.println(q);
        System.out.println(r);
        
        return x;
        
    }
}
class F {
    int x;
    public int m1(int z) {
        x = z;
        return 1;
    }

    public int m2(int z) {
        boolean y;
        boolean zx;
        zx = z<x;
            if(zx) {
            y= true;
            x = z*z;
            }
            else{ y=false;
            x = z/2;
            }
            System.out.println(y);
            return x;
    }
}