package statics;

public class Demo {
  static int a = printA();
    static int b = printB();


    static{
        System.out.println("Static block executing");
        b= a* 10;
        
    }
    Demo() {
        System.out.println("constructor ");
    }
    static int printA() {
        System.out.println("Static variable a initialized");
        return 5;
    }
    static int printB() {
        System.out.println("Static variable b initialized");
        return 0;
    }

    public static void main(String[] args){
         System.out.println("Main started");
         System.out.println(Demo.a);

        // Demo obj = new Demo();
        // Demo d1 = new Demo();
        // Demo d2 = new Demo();
        // Demo d3 = new Demo();
    }
}
