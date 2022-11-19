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
        int[] arr_1;
        int arr_2;
        int arr_3;
        int tmp;
        tmp =10;
        arr_1 = new int[tmp];
        arr_3 = 0;
        /* PRINTLIVEVARIABLES */
        arr_2 = arr_1[arr_3];
        /* PRINTLIVEVARIABLES */
        return arr_2;
    }
}