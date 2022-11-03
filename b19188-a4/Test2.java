class Test2 {
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
        int num_a;
        int i;
        int j;
        boolean vl;

        i = 0;
        j = 2;
        num_a = 5;
        vl = num_a <= i;
        while(vl) {
            vl = num_a <= i;
            i = i + j;
        }

        /* PRINTLIVEVARIABLES */ // OUTPUT : num_a
        return num_a;
    }
}