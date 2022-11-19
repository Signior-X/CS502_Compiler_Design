class Test6 {
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
        int mtTmp3;
        int mtTmp1;
        mtTmp3 = 10;

        System.out.println(mtTmp1);

        if (mtTmp1) {
            /* PRINTLIVEVARIABLES */
            mtTmp1 = mtTmp1 + mtTmp1;
            if (mtTmp1) {
                /* PRINTLIVEVARIABLES */
                mtTmp3 = mtTmp1;
                if (mtTmp1) {
                    /* PRINTLIVEVARIABLES */
                }
                else{
                    while (mtTmp3){}
                    if(mtTmp3){
                        /* PRINTLIVEVARIABLES */
                        mtTmp1 = mtTmp3;
                    }
                    else{

                    }
                }
            }
        }

        mtTmp1 = mtTmp1 + mtTmp3;
        return mtTmp1;
    }
}