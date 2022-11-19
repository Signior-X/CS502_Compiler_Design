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
        int num_aux;
        boolean mtTmp4;
        int mtTmp5;
        int mtTmp6;
        int mtTmp7;
        Fac mtTmp9;
        int mtTmp10;
        int mtTmp11;
        int mtTmp8;
        int mtTmp13;
        int mtTmp12;		               
        boolean var0;
        int var1;
        int var2;
        int var3;
        mtTmp5 = 0;
        mtTmp13 = 10;
        mtTmp10 = mtTmp10 - mtTmp5;	
        mtTmp12 = mtTmp12 + mtTmp5;
        mtTmp4 = num <= mtTmp5;
        if (mtTmp4) {
            mtTmp6 = 1;
            num_aux = mtTmp6;
        } else {
            mtTmp9 = this;
            mtTmp11 = 1;
            mtTmp10 = num - mtTmp11;
            mtTmp8 = mtTmp9.ComputeFac(mtTmp10);
            mtTmp7 = num * mtTmp8;
            num_aux = mtTmp7;
        }
        mtTmp4 = false;
        var1 = 10;
        var0 = true;
        var3 = 99;
        while(var0) {
            var2 = var1 * var1;
            if(mtTmp4) {
                while(mtTmp4) {
                    System.out.println(var0);
                }
            }
            else {
                while(mtTmp4) {
                    System.out.println(var0);
                }
            }
            while (mtTmp4) {
                if(mtTmp4) {
                    System.out.println(var1);
                    while (mtTmp4) {
                        mtTmp8 = mtTmp13;
                        mtTmp10 = 1;
                        mtTmp7 = mtTmp10;
                        if (mtTmp4) {
                        } else {
                            {
                                mtTmp8 = mtTmp13;
                            }
                            if (mtTmp12) {
                                mtTmp13 = mtTmp8;
                            }
                        }
                    }
                }
            }
            var1 = var1 * var3;

            /* PRINTLIVEVARIABLES */     
        }
        return num_aux;
    }
}