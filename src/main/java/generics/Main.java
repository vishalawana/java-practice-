package generics;

public class Main {
    public static void main(String[] args){
        // Box<String> stringBox = new Box<>("hello");
        // System.out.println("String Value: " + stringBox.getValue());
        // System.out.println("Is Empty: " + stringBox.isEmpty());

        // stringBox.setValue(null);
        // System.out.println("after setvalue: " + stringBox.isEmpty());
        //  Box<Integer> integerBox = new Box<>(100);

        // integerBox.setValue(200);
        //   System.out.println("Integer Value: " + integerBox.getValue());
        // System.out.println("Is Empty: " + integerBox.isEmpty());

        User user = new User("vishal", 25);
        Box<User> userBox = new Box<>(user);
        System.out.println("\nUser Value: " + userBox.getValue());
    }
}
