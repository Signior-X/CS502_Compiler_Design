class Test8 {
    public static void main(String[] a){
        TC07_1 mtTmp2;
        int mtTmp3;
        int mtTmp4;
        int mtTmp1;
        mtTmp2 = new TC07_1();
        mtTmp1 = mtTmp2.Start();
        System.out.println(mtTmp1);
    }
}

class TC07_1 {
    public int Start() {
        A o1;
        A o2;
        A o3;
        int m;
        boolean b;
        boolean c;
        boolean d;
        int n;
        int r;
        m = 5;
        n = 10;
        r = 20;
        o1 = new A();
        o2 = new A();
        b = m <= n;
        d = r <= n;
        /* PRINTLIVEVARIABLES */
        c = b && d;
        /* PRINTLIVEVARIABLES */
        while (c) {
            /* PRINTLIVEVARIABLES */
            if(b) {
                /* PRINTLIVEVARIABLES */
                o3 = o1;
            }
            else {
                /* PRINTLIVEVARIABLES */
                o3 = o2;
            }
            /* PRINTLIVEVARIABLES */
            c = c && b;
            /* PRINTLIVEVARIABLES */
        }
        /* PRINTLIVEVARIABLES */
        m = 20;
        /* PRINTLIVEVARIABLES */
        return m;
    }
}

class A {
    int num;
}