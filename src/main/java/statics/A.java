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
