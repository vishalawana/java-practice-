
package Interfaces;

public interface Animal {
    default void eat() {
        System.out.println("Animal is eating");
    }

    void sleep();

}
