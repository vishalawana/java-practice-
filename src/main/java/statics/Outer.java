package statics;

class Outer {
    int outerValue = 100;

    static class Inner {
        Outer c = new Outer();
        void show() {
            System.out.println(c.outerValue);
        }
    }

    public static void main(String[] args){

        Outer.Inner b = new Outer.Inner();
        b.show();
    }


}



