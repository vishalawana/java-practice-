package statics;

public class Test {
    int x = 10;
    static void show(){
         Test a = new Test();
        System.out.println(a.x);
    }
    public static void main(String[] args) {
    show();
}
}
