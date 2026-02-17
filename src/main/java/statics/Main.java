package statics;

class A {
    static void show() {
        System.out.println("A");
    }

    void display() {
        show();
    }
}

class B extends A {
    static void show() {
        System.out.println("B");
    }
}

public class Main {
    public static void main(String[] args) {
        A obj = new B();
        obj.display();
    }
}
