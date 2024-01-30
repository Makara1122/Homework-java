package nestedclass.localnestedclass;

class OuterClass {
    static String name = "Mam Makara";
    private static final int number = 10;

    public final static void display() {
        final int numberInMethodBlock = 200;
        System.out.println("This from inner class method");
        class InnerClass {
            static void displayInnerClass() {
                System.out.println("This is final effectively or instance of OuterClass: " + name);
                System.out.println("This is number: " + number);


            }
        }
        InnerClass.displayInnerClass();
    }
}

public class Main {
    public static void main(String[] args) {
        OuterClass.display();

    }
}
