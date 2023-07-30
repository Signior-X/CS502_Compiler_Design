/*2*/
import static a5.Memory.*;
class TC02 {
  public static void main(String[] args) {
    Object register__0;
    Object register__1;
    alloca(0);
    
    register__0 = new TestTC02();
    register__0 = ((TestTC02) register__0).foo();
    System.out.println(((int) register__0));
  }
}
class TestTC02 {
  public int foo() {
    Object register__0;
    Object register__1;
    alloca(1);
    
    store(0, 5);
    register__0 = 6;
    register__1 = ((int) load(0)) + ((int) register__0);
    register__0 = ((int) register__1) + ((int) load(0));
    register__1 = ((int) load(0)) - ((int) register__1);
    register__0 = ((int) register__0) - ((int) register__1);
    return ((int) register__0);
  }
}

