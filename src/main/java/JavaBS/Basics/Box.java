package JavaBS.Basics;

public class Box<T> {
    private T value;
    public void set(T value) {
        this.value = value;
    }
    public T get() {
        return value;
    }
    
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.set("Hello from Box.main");
        System.out.println(box.get());
    }
}
