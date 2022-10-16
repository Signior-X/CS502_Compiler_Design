package cs502;

import static cs502.memmgr.MemMgr.*;

public class Main {
  public static void main(String[] args) {
    Object obj;
    int ans;
    int t1;
    String var;
    Object priyam_0;
    Object priyam_1;
    int priyam_2;
    Object vTablePtr;
    String fnName;

    priyam_0 = alloc(12);
    store(priyam_0, 4, 0);
    store(priyam_0, 8, 0);

    priyam_1 = alloc(16);
    store(priyam_1, 0, "A__foo");
    store(priyam_1, 4, "A__bar");
    store(priyam_1, 8, "A__baz");
    store(priyam_1, 12, "A__priyam");

    store(priyam_0, 0, priyam_1);
    obj = priyam_0;
    t1 = 3;
    var = null;

    vTablePtr = load(obj, 0);
    fnName = (String) load(vTablePtr, 0);
    ans = (Integer) callFunc(fnName, obj);
    System.out.println(ans);
    store(obj, 4, t1);
    priyam_2 = (Integer) load(obj, 4);
    ans = priyam_2;
    System.out.println(ans);

    vTablePtr = load(obj, 0);
    fnName = (String) load(vTablePtr, 8);
    ans = (Integer) callFunc(fnName, obj, 8);
    System.out.println(ans);
    t1 = 5;
    store(obj, 8, t1);

    vTablePtr = load(obj, 0);
    fnName = (String) load(vTablePtr, 12);
    ans = (Integer) callFunc(fnName, obj, obj, var);
    System.out.println(ans);
  }
  public static int A__foo(Object mthis) {
    int x;

    x = 5;
    return x;
  }

  public static int A__bar(Object mthis) {
    int priyam_0;

    priyam_0 = (Integer) load(mthis, 4);
    return priyam_0;
  }

  public static int A__baz(Object mthis, int x) {

    return x;
  }

  public static int A__priyam(Object mthis, Object obj, String x) {
    int ans;
    int priyam_0;

    priyam_0 = (Integer) load(obj, 8);
    ans = priyam_0;
    System.out.println(x);
    return ans;
  }

}

