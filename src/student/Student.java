package student;
import validation.Validation;

import java.util.Scanner;

public class Student {


    int age;

    // i know clearly about how to instantiate array of object and how to instantiate object


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = Integer.parseInt(Validation.validation("Enter option: ",scanner,"[0-9]+"));
        Student[] students = new Student[option];

        // instantiate array of objects


        for (int i =0; i < option; i++){
            students[i] = new Student();

            // instantiate every object

            students[i].age = Integer.parseInt(Validation.validation("Enter student",scanner,"[0-9]+"));
        }
        for (int j =0; j < option; j++){
            System.out.println("this is student["+(j+1)+"]: " + students[j].age);
        }



    }
}
