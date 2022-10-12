package cs502;

import static cs502.memmgr.MemMgr.*;

public class Main {
  public static void main(String[] args) {
    Object a;
    int r;
    int p;
    Object priyam_0;
    Object priyam_1;
    int priyam_2;
    Object vTablePtr;
    String fnName;

    priyam_0 = alloc(12);
    store(priyam_0, 4, 0);
    store(priyam_0, 8, 0);

    priyam_1 = alloc(16);
    store(priyam_1, 0, "A__m1");
    store(priyam_1, 4, "A__m2");
    store(priyam_1, 8, "A__m3");
    store(priyam_1, 12, "A__m4");

    store(priyam_0, 0, priyam_1);
    a = priyam_0;

    vTablePtr = load(a, 0);
    fnName = (String) load(vTablePtr, 0);
    r = (Integer) callFunc(fnName, a, 10);
    priyam_2 = (Integer) load(a, 4);
    p = priyam_2;
    store(a, 4, p);
    System.out.println(r);

    vTablePtr = load(a, 0);
    fnName = (String) load(vTablePtr, 8);
    r = (Integer) callFunc(fnName, a);
    System.out.println(r);
  }
  public static int A__m1(Object mthis, int z) {
    int t1;
    int t2;
    int priyam_0;
    int priyam_1;

    priyam_0 = (Integer) load(mthis, 4);
    priyam_1 = (Integer) load(mthis, 8);
    t1 = priyam_0 + priyam_1;
    t2 = t1 + z;
    return t2;
  }

  public static int A__m2(Object mthis) {
    int priyam_0;

    priyam_0 = (Integer) load(mthis, 4);
    return priyam_0;
  }

  public static int A__m3(Object mthis) {

    System.out.println(3);
    return 3;
  }

  public static int A__m4(Object mthis) {

    System.out.println(4);
    return 4;
  }

}

