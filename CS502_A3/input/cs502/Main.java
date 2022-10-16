package cs502;

import static cs502.memmgr.MemMgr.*;

public class Main {
  public static void main(String[] args) {
    Object x1;
    Object x2;
    Object x3;
    int o;
    int t1;
    int t2;
    int t3;
    Object priyam_0;
    Object priyam_1;
    Object priyam_2;
    Object priyam_3;
    Object priyam_4;
    Object priyam_5;
    int priyam_6;
    Object vTablePtr;
    String fnName;

    t1 = 4;
    t2 = 5;
    t3 = 6;
    priyam_0 = alloc(12);
    store(priyam_0, 4, 0);
    store(priyam_0, 8, 0);

    priyam_1 = alloc(8);
    store(priyam_1, 0, "B__set");
    store(priyam_1, 4, "B__get");

    store(priyam_0, 0, priyam_1);
    x1 = priyam_0;
    priyam_2 = alloc(16);
    store(priyam_2, 4, 0);
    store(priyam_2, 8, 0);
    store(priyam_2, 12, 0);

    priyam_3 = alloc(8);
    store(priyam_3, 0, "C__set");
    store(priyam_3, 4, "C__get");

    store(priyam_2, 0, priyam_3);
    x2 = priyam_2;
    priyam_4 = alloc(16);
    store(priyam_4, 4, 0);
    store(priyam_4, 8, 0);
    store(priyam_4, 12, 0);

    priyam_5 = alloc(8);
    store(priyam_5, 0, "C__set");
    store(priyam_5, 4, "C__get");

    store(priyam_4, 0, priyam_5);
    x3 = priyam_4;
    store(x1, 4, t1);
    store(x2, 4, t2);
    store(x3, 8, t3);

    vTablePtr = load(x1, 0);
    fnName = (String) load(vTablePtr, 0);
    o = (Integer) callFunc(fnName, x1, 1);

    vTablePtr = load(x2, 0);
    fnName = (String) load(vTablePtr, 0);
    o = (Integer) callFunc(fnName, x2, 2);

    vTablePtr = load(x3, 0);
    fnName = (String) load(vTablePtr, 0);
    o = (Integer) callFunc(fnName, x3, 3);
    priyam_6 = (Integer) load(x1, 4);
    o = priyam_6;
    System.out.println(o);
    priyam_6 = (Integer) load(x2, 4);
    o = priyam_6;
    System.out.println(o);
    priyam_6 = (Integer) load(x3, 8);
    o = priyam_6;
    System.out.println(o);

    vTablePtr = load(x1, 0);
    fnName = (String) load(vTablePtr, 4);
    o = (Integer) callFunc(fnName, x1);
    System.out.println(o);

    vTablePtr = load(x2, 0);
    fnName = (String) load(vTablePtr, 4);
    o = (Integer) callFunc(fnName, x2);
    System.out.println(o);

    vTablePtr = load(x3, 0);
    fnName = (String) load(vTablePtr, 4);
    o = (Integer) callFunc(fnName, x3);
    System.out.println(o);
  }
  public static int A__set(Object mthis, int x) {

    store(mthis, 4, x);
    return 1;
  }

  public static int A__get(Object mthis) {
    int priyam_0;

    priyam_0 = (Integer) load(mthis, 4);
    return priyam_0;
  }

  public static int B__set(Object mthis, int x) {

    store(mthis, 8, x);
    return 1;
  }

  public static int B__get(Object mthis) {
    int priyam_0;

    priyam_0 = (Integer) load(mthis, 8);
    return priyam_0;
  }

  public static int C__set(Object mthis, int x) {

    store(mthis, 12, x);
    return 1;
  }

  public static int C__get(Object mthis) {
    int priyam_0;

    priyam_0 = (Integer) load(mthis, 12);
    return priyam_0;
  }

}

