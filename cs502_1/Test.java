class Test extends C {
    public static void main(String[] args) { //no of params = 1
        System.out.println(new A().foo(10));
    }
}
class C {
    
}

class A {
    public int foo(int p) { //no of params = 1
        int x; //local var1
        double y; //local var2
        boolean b; //local var3
        int r; //local var4
        x = 10;
        y = 100.25;
        b = true;
        x = x + x;
        while (b) {
            y = y + x; //binop1
            if (y != 200) { //binop2
                b = false;
            }
        }
        r = this.bar();
        return r;
    }
    public int bar() { //no of params = 0
        int a; //local var1
        int b; //local var2
        int c; //local var3
        int d; //local var4
        a = 10;
        b = 20;
        c = a + b; //binop1
        d = a - b; //binop2
        if(d != (a * c)){ //binop3 //binop4
            a = c * d; //binop5
        }
        return a;
    }

    public double priyam() {
        double a;
        int[] abc;
        int [] abc2;
        int l;
        int b;
        b = 5;
        a = 1.3;
        abc = new int[2];
        abc2 = new int[1];
        abc[0] = 1;
        abc[1] = 3;
        abc2[0] = abc[0];
        l = abc[b];
        l = abc.length;
        return a;
    }
}
class B extends A {}