class Test3 {
    public static void main(String[] args) {
        System.out.println(5);
    }
}

class A3 {
    public int func() {
        A3 a;
        D3 d;
        int k;
        a = new D3();
        d = new D3();
        System.out.println(d.ff());
        k = this.fff(d);
        return 0;
    }

    public int fff(B3 b) {
        return 0;
    }
}

class B3 extends A3 {
}

class C3 extends B3 {
}

class D3 extends C3 {
    public int ff() {
        return 5;
    }
}
