/*1*/
import static validator.a5.Memory.*;
class TC21 {
  public static void main(String[] a) {
    Object register__0;
    alloca(1);
    
    store(0, new Fac());
    register__0 = 10;
    register__0 = ((Fac) load(0)).ComputeFac(((int) register__0));
    System.out.println(((int) register__0));
  }
}
class Fac {
  public int ComputeFac(int num) {
    Object register__0;
    alloca(1);
    
    register__0 = 0;
    register__0 = num <= ((int) register__0);
    if (((boolean) register__0)) {
    register__0 = 1;
    register__0 = ((int) register__0);
    } else {
    store(0, new Fac());
    register__0 = 1;
    register__0 = num - ((int) register__0);
    register__0 = ((Fac) load(0)).ComputeFac(((int) register__0));
    register__0 = num * ((int) register__0);
    register__0 = ((int) register__0);
    }
    return ((int) register__0);
  }
}

