package title;

 class OuterClass {
    static float gpa = 1.5F;
     static void display(){
          int age = 10;
        class  InnerClass {
            void display2(){
                System.out.println(age);
                System.out.println(gpa);
            }
        }
        InnerClass innerClass = new InnerClass();
        innerClass.display2();
    }

    public static void main(String[] args) {
        display();

    }
}
