package cs502;

import static cs502.memmgr.MemMgr.*;

public class Main {
  public static void main(String[] args) {
    Object a;
    int a1;
    int a2;
    Object priyam_0;
    Object priyam_1;
    Object vTablePtr;
    String fnName;

    priyam_0 = alloc(12);
    store(priyam_0, 4, 0);
    store(priyam_0, 8, 0);

    priyam_1 = alloc(8);
    store(priyam_1, 0, "E__m1");
    store(priyam_1, 4, "E__m2");

    store(priyam_0, 0, priyam_1);
    a = priyam_0;

    vTablePtr = load(a, 0);
    fnName = (String) load(vTablePtr, 0);
    a1 = (Integer) callFunc(fnName, a, 10);
    System.out.println(a1);

    vTablePtr = load(a, 0);
    fnName = (String) load(vTablePtr, 4);
    a2 = (Integer) callFunc(fnName, a);
    System.out.println(a2);
  }
  public static int E__m1(Object mthis, int z) {
    int t1;
    int t2;
    int priyam_0;
    int priyam_1;
    int priyam_2;
    int priyam_3;

    priyam_0 = (Integer) load(mthis, 4);
    priyam_1 = (Integer) load(mthis, 8);
    priyam_2 = priyam_0 + priyam_1;
    t1 = priyam_2;
    priyam_3 = t1 + z;
    t2 = priyam_3;
    return t2;
  }

  public static int E__m2(Object mthis) {
    Object b;
    int x;
    int q;
    int r;
    Object priyam_0;
    Object priyam_1;
    Object vTablePtr;
    String fnName;

    priyam_0 = alloc(8);
    store(priyam_0, 4, 0);

    priyam_1 = alloc(8);
    store(priyam_1, 0, "F__m1");
    store(priyam_1, 4, "F__m2");

    store(priyam_0, 0, priyam_1);
    b = priyam_0;

    vTablePtr = load(b, 0);
    fnName = (String) load(vTablePtr, 0);
    x = (Integer) callFunc(fnName, b, 7);

    vTablePtr = load(b, 0);
    fnName = (String) load(vTablePtr, 4);
    q = (Integer) callFunc(fnName, b, 9);

    vTablePtr = load(b, 0);
    fnName = (String) load(vTablePtr, 4);
    r = (Integer) callFunc(fnName, b, 6);
    System.out.println(q);
    System.out.println(r);
    return x;
  }

  public static int F__m1(Object mthis, int z) {

    store(mthis, 4, z);
    return 1;
  }

  public static int F__m2(Object mthis, int z) {
    boolean y;
    boolean zx;
    int priyam_0;
    boolean priyam_1;
    int priyam_2;
    int priyam_3;

    priyam_0 = (Integer) load(mthis, 4);
    priyam_1 = z < priyam_0;
    zx = priyam_1;
    if (zx) {
    y = true;
    priyam_2 = z * z;
    store(mthis, 4, priyam_2);
    }
    else {
    y = false;
    priyam_3 = z / 2;
    store(mthis, 4, priyam_3);
    }
    System.out.println(y);
    priyam_0 = (Integer) load(mthis, 4);
    return priyam_0;
  }
}

