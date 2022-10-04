package cs502;

import static cs502.memmgr.MemMgr.*;

public class Main {
  public static void main(String[] args) {
    Object b;
    int r;
    Object priyam_0;
    Object priyam_1;
    Object vTablePtr;
    String fnName;

    priyam_0 = alloc(20);
    store(priyam_0, 4, 0);
    store(priyam_0, 8, 0);
    store(priyam_0, 12, 0);
    store(priyam_0, 16, 0);

    priyam_1 = alloc(20);
    store(priyam_1, 0, "B__m1");
    store(priyam_1, 4, "A__m2");
    store(priyam_1, 8, "A__m3");
    store(priyam_1, 12, "A__m4");
    store(priyam_1, 16, "B__set");

    store(priyam_0, 0, priyam_1);
    b = priyam_0;

    vTablePtr = load(b, 0);
    fnName = (String) load(vTablePtr, 16);
    r = (Integer) callFunc(fnName);
    vTablePtr = load(b, 0);

    fnName = (String) load(vTablePtr, 0);
    r = (Integer) callFunc(fnName);
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
  public static int B__m1(Object mthis, int p) {
    int t1;
    int t2;
    int t3;
    int t4;
    int t5;
    Object t6;
    int priyam_0;
    Object vTablePtr;
    String fnName;

    t6 = mthis;
    vTablePtr = load(t6, 0);
    fnName = (String) load(vTablePtr, 4);
    t1 = (Integer) callFunc(fnName);
    priyam_0 = (Integer) load(mthis, 12);
    t2 = priyam_0 * 2;
    t3 = t1 + t2;
    t4 = t3 - p;
    t5 = t1 + t4;
    return t5;

  }
  public static int B__set(Object mthis, int a, int b) {

    store(mthis, 12, a);
    store(mthis, 16, b);
    return 5;

  }
}

