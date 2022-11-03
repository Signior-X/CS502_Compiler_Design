class Test1 {
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
        boolean ptTemp1;
        int ptTemp2;
        int ptTemp3;
        int ptTemp4;
        int ptTemp5;
        Foobar ptTemp6;
        int ptTemp7;
        int ptTemp8;
        int ptTemp9;
        int ptTemp10;
        ptTemp2 = 0;
        ptTemp10 = 10;
        ptTemp7 = ptTemp10 - ptTemp2;
        ptTemp9 = ptTemp10 + ptTemp2;
        /* PRINTLIVEVARIABLES */ // OUTPUT : num,ptTemp2
        ptTemp1 = num <= ptTemp2;
        if (ptTemp1) {
            ptTemp3 = 1;
            num_a = ptTemp3;
            /* PRINTLIVEVARIABLES */ // OUTPUT : num_a
        } else {
            ptTemp6 = this;
            ptTemp8 = 1;
            ptTemp7 = num - ptTemp8;
            ptTemp5 = ptTemp6.Compute(ptTemp7);
            ptTemp4 = num * ptTemp5;
            num_a = ptTemp4;
            /* PRINTLIVEVARIABLES */ // OUTPUT : num_a
        }
        /* PRINTLIVEVARIABLES */ // OUTPUT : num_a
        return num_a;
    }
}