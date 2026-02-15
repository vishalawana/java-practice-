package generics;

public class CopyConstructorExample {

    private String title;
    private int version;

    public CopyConstructorExample(String title, int version) {
        this.title = title;
        this.version = version;
    }

    // Copy constructor
    public CopyConstructorExample(CopyConstructorExample other) {
        this.title = other.title;
        this.version = other.version;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CopyConstructorExample{title='" + title + "', version=" + version + "}";
    }

    public static void main(String[] args) {
        CopyConstructorExample original = new CopyConstructorExample("Generics Lesson", 1);
        CopyConstructorExample copied = new CopyConstructorExample(original);

        original.setTitle("Updated Generics Lesson");

        System.out.println("Original: " + original);
        System.out.println("Copied: " + copied);
    }
}
