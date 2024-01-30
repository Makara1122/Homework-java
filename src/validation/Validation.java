package validation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static String validation(String message, Scanner scanner,String regex){
        while (true){
            System.out.println(message);
            String number = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(number);
            boolean result = matcher.find();
            if (result){
                return number;
            }else {
                System.out.println("Invalid validation !!");
            }
        }
    }
}
