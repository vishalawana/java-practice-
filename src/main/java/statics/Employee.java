package statics;

public class Employee {
    String name;
    static int count;

    Employee(String name){
        this.name = name;
        count++;
    }


    public static void main(String[] args){
        Employee vishal = new Employee("vishal");
        Employee akash = new Employee("akash");

        System.out.println(vishal.count);
        vishal.count = 100;
        System.out.println(akash.count);
    }
}
