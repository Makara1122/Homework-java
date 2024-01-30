package nestedclass;

// class OuterClass {
//    static String name = "Mom Makara";
//    static int id = 12345;
//    float gpa = 5.7F;
//
//    static class InnerClass {
//        static void dispaly()
//
//        {
//            System.out.println("This is " + name + "\n" + "and this is his id: " + id);
//            OuterClass outerClass = new OuterClass();
//            System.out.println("This is not static instance of OuterClass: " + outerClass.gpa);
//        }
//    }
//}
//public class Main{
//    public static void main(String[] args) {
//        OuterClass.InnerClass.dispaly();
//        System.out.println("This is name from OuterClass: " + OuterClass.name);
//    }
//}

//        Inner Class (none static inner classes)


    class  OuterClass {
        static int age = 19;

        class InnerClass{

      static void display(){
                System.out.println("This is instance of OuterClass: " + age);
            }
        }
    }

    public class Main {
        public static void main(String[] args) {
            System.out.println("This is main block ");

            OuterClass.InnerClass.display();

        }
}
