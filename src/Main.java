import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class Main {
    String[] students ;
    int[] id;

    static String[][] morningHall;
    static String[][] eveningHall;
    static String[][] nigthHall;
    static int option = 0;
    static int option1 = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        while (option != 1) {
            showOption();
            option = validation("Enter option: ", scanner, "[0-9]+");
            switch (option) {
                case 1 -> exit(0);
                case 2 -> {
                    hallbooking(scanner);
                    System.out.println("---------------------------------------------");
                }

                case 3 -> {
                    if(morningHall != null || eveningHall != null || nigthHall != null) {
                        hallShow(morningHall,eveningHall,nigthHall);
                        System.out.println("---------------------------------------------");
                    }else {
                        System.out.println("There is no hall right now !!");
                        System.out.println("---------------------------------------------");
                    }
                }
                case 4 -> {
                    showTime();
                    System.out.println("---------------------------------------------");
                }
                default -> System.out.println("Invalid option: !!");
            }
        }
    }

    public static void hallShow(String[][] morningHall,String[][] eveningHall,String[][] nightHall) {

        System.out.println("-----------------------------");

        if (morningHall != null){
            System.out.println("===================Hall Morning====================");
            for (int i = 0; i < morningHall.length; i++) {
                for (int j = 0; j < morningHall[0].length; j++) {
                    System.out.print(morningHall[i][j] + " ");
                }
                System.out.println(" ");
            }
        }
        System.out.println("");
    if (eveningHall != null){
        System.out.println("===================Hall evening====================");
        for (int i = 0; i < eveningHall.length; i++) {
            for (int j = 0; j < eveningHall[0].length; j++) {
                System.out.print(eveningHall[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    System.out.println("");
        if (nightHall != null){
            System.out.println("===================Hall night====================");
            for (int i = 0; i < nightHall.length; i++) {
                for (int j = 0; j < nightHall[0].length; j++) {
                    System.out.print(nightHall[i][j] + " ");
                }
                System.out.println(" ");
            }
        }

    }

    public static void showOption(){
        System.out.println("[1]. Exit");
        System.out.println("[2]. Booking");
        System.out.println("[3]. showHall");
        System.out.println("[4]. showTime");
        System.out.println("[5]. history");
    }

    public static int validation(String message, Scanner scanner, String regex) {
        while (true) {
            System.out.println(message);
            String number = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(number);

            boolean result = matcher.find();

            if (result) {
                System.out.println("Successfully validation: ");
                int value = Integer.parseInt(number);
                return value;
            } else {
                System.out.println("Invalid validation: ");
            }
        }
    }

    public static String validation2(String message, Scanner scanner, String regex) {
        while (true) {
            System.out.println(message);
            String number = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(number);

            boolean result = matcher.find();

            if (result) {
                System.out.println("Successfully validation: ");

                return number;
            } else {
                System.out.println("Invalid validation: ");
            }
        }
    }

    public static void hallbooking(Scanner scanner) {
        String optionHall = validation2("Enter option A||B||C : ", scanner,"[a-zA-Z]+");
        switch (optionHall.toUpperCase(Locale.ROOT)){
            case "A" -> {

                int hall = validation("Enter hall: ", scanner, "[0-9]+");
                int room = validation("Enter room: ", scanner, "[0-9]+");
//
                morningHall = new String[hall][room];

                char a = 'A';
                for (int i = 0; i < hall; i++) {
                    for (int j = 0; j < room; j++) {
                        if (morningHall[i][j] == null) {

                            morningHall[i][j] = "|" + a + "-" + (j + 1) + ":AV|";

                        } else {
                            morningHall[i][j] = "|" + a + "-:BO|";
                        }
                        System.out.print(morningHall[i][j] + " ");


                    }
                    a++;
                    System.out.println("");
                }
                 option1 = 0;

                while (option1 != 10) {


                    int roomInsert = validation("Enter room: ", scanner, "[0-9]+") -1;
                    int hallInsert = validation("Enter hall: ", scanner, "[0-9]+") -1;


                    morningHall[hallInsert][roomInsert] = validation2("Enter string: ", scanner, "[a-zA-Z]+");
                    String result = morningHall[hallInsert][roomInsert];
                    for (int i = 0; i < hall; i++) {


                        for (int j = 0; j < room; j++) {
                            if (morningHall[i][j] == null) {

                                morningHall[i][j] = "|" + a + "-" + (j + 1) + ":AV|";

                            } else {
                                morningHall[hallInsert][roomInsert] = "|" + result + ":BO|";
                            }

                            System.out.print(morningHall[i][j] + " ");


                        }
                        System.out.println("");
                    }


                    option1 = validation("Enter option: [10. for exit ] ... for more operations :", scanner, "[0-9]+");

                }


            }

            case "B" -> {

                int eveninghall = validation("Enter hall: ", scanner, "[0-9]+");
                int eveningroom = validation("Enter room: ", scanner, "[0-9]+");
//
                eveningHall = new String[eveninghall][eveningroom];

                char a1 = 'A';
                for (int i = 0; i < eveninghall; i++) {
                    for (int j = 0; j < eveningroom; j++) {
                        if (eveningHall[i][j] == null) {

                            eveningHall[i][j] = "|" + a1 + "-" + (j + 1) + ":AV|";

                        } else {
                            eveningHall[i][j] = "|" + a1 + "-:BO|";
                        }
                        System.out.print(eveningHall[i][j] + " ");


                    }
                    a1++;
                    System.out.println("");
                }
                int option1 = 0;

                while (option1 != 10) {


                    int roomInsert = validation("Enter room: ", scanner, "[0-9]+") -1;
                    int hallInsert = validation("Enter hall: ", scanner, "[0-9]+") -1;


                    eveningHall[hallInsert][roomInsert] = validation2("Enter string: ", scanner, "[a-zA-Z]+");
                    String result = eveningHall[hallInsert][roomInsert];
                    for (int i = 0; i < eveninghall; i++) {


                        for (int j = 0; j < eveningroom; j++) {
                            if (eveningHall[i][j] == null) {

                                eveningHall[i][j] = "|" + a1 + "-" + (j + 1) + ":AV|";

                            } else {
                                eveningHall[hallInsert][roomInsert] = "|" + result + ":BO|";
                            }

                            System.out.print(eveningHall[i][j] + " ");


                        }
                        System.out.println();
                    }


                    option1 = validation("Enter option: [10. for exit ] ... for more operations :", scanner, "[0-9]+");

                }
            }
            case "C" -> {

                int hall = validation("Enter hall: ", scanner, "[0-9]+");
                int room = validation("Enter room: ", scanner, "[0-9]+");
//
                nigthHall = new String[hall][room];

                char a = 'A';
                for (int i = 0; i < hall; i++) {
                    for (int j = 0; j < room; j++) {
                        if (nigthHall[i][j] == null) {

                            nigthHall[i][j] = "|" + a + "-" + (j + 1) + ":AV|";

                        } else {
                            nigthHall[i][j] = "|" + a + "-:BO|";
                        }
                        System.out.print(nigthHall[i][j] + " ");


                    }
                    a++;
                    System.out.println("");
                }
                option1 = 0;

                while (option1 != 10) {


                    int roomInsert = validation("Enter room: ", scanner, "[0-9]+") -1;
                    int hallInsert = validation("Enter hall: ", scanner, "[0-9]+") -1;


                    nigthHall[hallInsert][roomInsert] = validation2("Enter string: ", scanner, "[a-zA-Z]+");
                    String result = nigthHall[hallInsert][roomInsert];
                    for (int i = 0; i < hall; i++) {


                        for (int j = 0; j < room; j++) {
                            if (nigthHall[i][j] == null) {

                                nigthHall[i][j] = "|" + a + "-" + (j + 1) + ":AV|";

                            } else {
                                nigthHall[hallInsert][roomInsert] = "|" + result + ":BO|";
                            }

                            System.out.print(nigthHall[i][j] + " ");


                        }
                        System.out.println();
                    }


                    option1 = validation("Enter option: [10. for exit ] ... for more operations :", scanner, "[0-9]+");

                }


            }
        }}

    public static void showTime(){
        System.out.println("# Daily Showtime of CSTAD Hall: ");
        System.out.println("# A) Morning (10:00AM  -  12:30PM)");
        System.out.println("# B) Afternoon (03:00PM  -  05:30PM)");
        System.out.println("# C) Night (07:00PM  -  09:30PM)");
    }
}