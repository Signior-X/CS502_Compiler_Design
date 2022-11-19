class Test4 {
    public static void main(String[] arg) {
        Foobar obj;
        int ret;
        int m_arg;
        m_arg = 10;
        obj = new Foobar();
        ret = obj.Compute(m_arg);
    }
}

class Foobar {
    public int Compute(int num) {
        int x;
        int p;
        int q;
        Test4 refA;
        Test4 refB;
        refA = new Test4();
        p =10;
        q = 20;
        /* PRINTLIVEVARIABLES */
        x = refA.bar(p,q); 
        System.out.println(x);
        return x;
    }

    public int bar(int p1, int p2) {
        /* PRINTLIVEVARIABLES */
        p2 = p1;
        /* PRINTLIVEVARIABLES */
        return p2;
    }
}