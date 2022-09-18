public class Test2 {
    public static void main(String args[]) {
        Animal a = new Monkey();

        // System.out.println(((Animal) a).y);
        System.out.println(((Monkey) a).y);

        Animal b = new Animal();

        // System.out.println(((Monkey) b).x);
        int c = 5;
        double d = 6;

        // int e = c / 2; // Perfect
        // int e = c / 2.0; // Error
        // if right hand side is any of double/float type and getting stored in int, give error

        // we can't do a + b also as they are not valid objects to add

        Animal obj1 = new DeepMonkey();
    }
}

class Animal {
    int x;
    int y;

    Animal() {
        x = 2;
        y = 3;
    }

    int foo() {
        return 1;
    }
}

class Monkey extends Animal {
    int y;
    int z;

    Monkey() {
        x = 4;
        y = 5;
        z = 6;
    }

    int foo() {
        return 2;
    }
}

class DeepMonkey extends Monkey {

}