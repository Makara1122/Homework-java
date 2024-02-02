import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class Main {

    static String[] seat = new String[100];

    static Date[] dateTimeMor = new Date[100];
    static int[] idMor = new int[100];
    static int count = 0;
    static final int idForMorning = 1;
    static final int idForEvening = 2;
    static final int idForNight = 3;

    static int[] idHolder = new int[50];

    static int roommorning = 0;
    static int roomevening = 0;
    static int roomnight = 0;

    static int hallmorning = 0;
    static int hallevening = 0;
    static int hallnight = 0;

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
                    if (morningHall != null || eveningHall != null || nigthHall != null) {
                        hallShow(morningHall, eveningHall, nigthHall);
                        System.out.println("---------------------------------------------");
                    } else {
                        System.out.println("There is no hall right now !!");
                        System.out.println("---------------------------------------------");
                    }
                }
                case 4 -> {
                    showTime();
                    System.out.println("---------------------------------------------");
                }
                case 5 -> {
                    history();
                }
                case 6 -> {
                    rebootHistory();

                }
                default -> System.out.println("Invalid option: !!");
            }
        }
    }

    public static void hallShow(String[][] morningHall, String[][] eveningHall, String[][] nightHall) {

        System.out.println("-----------------------------");

        if (morningHall != null) {
            System.out.println("===================Hall Morning====================");
            for (int i = 0; i < morningHall.length; i++) {
                for (int j = 0; j < morningHall[0].length; j++) {
                    System.out.print(morningHall[i][j] + " ");
                }
                System.out.println(" ");
            }
        }
        System.out.println("");
        if (eveningHall != null) {
            System.out.println("===================Hall evening====================");
            for (int i = 0; i < eveningHall.length; i++) {
                for (int j = 0; j < eveningHall[0].length; j++) {
                    System.out.print(eveningHall[i][j] + " ");
                }
                System.out.println(" ");
            }
        }
        System.out.println("");
        if (nightHall != null) {
            System.out.println("===================Hall night====================");
            for (int i = 0; i < nightHall.length; i++) {
                for (int j = 0; j < nightHall[0].length; j++) {
                    System.out.print(nightHall[i][j] + " ");
                }
                System.out.println(" ");
            }
        }

    }

    public static void showOption() {
        System.out.println("[1]. Exit");
        System.out.println("[2]. Booking");
        System.out.println("[3]. showHall");
        System.out.println("[4]. showTime");
        System.out.println("[5]. history");
        System.out.println("[6]. Reboot history");
    }

    public static void history() {

        if (dateTimeMor[0] != null && idMor[0] !=0){
            for (int i = 0; i < count; i++) {

            if(idHolder[i] == 1){
                System.out.println("");
                System.out.println("\t\tStudent from morning Hall: ");
                System.out.println("");
            }else if (idHolder[i] == 2){
                System.out.println(" ");
                System.out.println("\t\tStudent from evening Hall: ");
                System.out.println(" ");
            }else if (idHolder[i] == 3){
                System.out.println(" ");
                System.out.println("\t\tStudent from night Hall: ");
                System.out.println(" ");
            }

                System.out.println("Student booked time: \t\t"+dateTimeMor[i] + "\t\t" + "id: "+idMor[i] + " \tSeat: "+ seat[i]);
            }
        }else {
            System.out.println("There is no student history::");
        }





    }

    public static int validation(String message, Scanner scanner, String regex) {
        while (true) {
            System.out.println(message);
            String number = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(number);

            boolean result = matcher.find();

            if (result) {

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


                return number;
            } else {
                System.out.println("Invalid validation: ");
            }
        }
    }

    public static void hallbooking(Scanner scanner) {
        System.out.println("[A]. Morning Hall");
        System.out.println("[B]. Evening Hall");
        System.out.println("[C]. Night Hall");
        String optionHall = validation2("Enter option A||B||C : ", scanner, "[a-zA-Z]+");
        switch (optionHall.toUpperCase(Locale.ROOT)) {
            case "A" -> {
                System.out.println("\t\tPleas input room and seat in morning Hall: ");
                int hall = validation("Enter room: ", scanner, "[0-9]+");
                int room = validation("Enter seat: ", scanner, "[0-9]+");
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

                    System.out.println("\t\tPlease input seat and room you want to book");
                    int roomInsert = validation("Enter seat: ", scanner, "[0-9]+") - 1;
                    int hallInsert = validation("Enter room: ", scanner, "[0-9]+") - 1;

                    roommorning = roomInsert+1;
                    hallmorning = hallInsert+1;
                    idHolder[count] = idForMorning;
                    morningHall[hallInsert][roomInsert] = validation2("Enter name room: ", scanner, "^[A-Z]-\\d+$");
                    seat[count] = morningHall[hallInsert][roomInsert];

                    dateTimeMor[count] = new Date();
                    idMor[count] = validation("Enter student id: ", scanner, "[0-9]+");
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


                    option1 = validation("[Type Number 10. for exit otherwise continue: ] ... for more operations :", scanner, "[0-9]+");

                    count++;
                }

            }

            case "B" -> {
                System.out.println("Enter room and seat for evening Hall: ");
                int eveninghall = validation("Enter room: ", scanner, "[0-9]+");
                int eveningroom = validation("Enter seat: ", scanner, "[0-9]+");
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

                    System.out.println("Enter room and seat for book: ");
                    int roomInsert = validation("Enter seat: ", scanner, "[0-9]+") - 1;
                    int hallInsert = validation("Enter room: ", scanner, "[0-9]+") - 1;

                    roomevening = roomInsert+1;
                    hallevening = hallInsert+1;
                    idHolder[count] = idForEvening;
                    eveningHall[hallInsert][roomInsert] = validation2("Enter room name: ", scanner, "^[A-Z]-\\d+$");
                    seat[count] = eveningHall[hallInsert][roomInsert];
                    dateTimeMor[count] = new Date();
                    idMor[count] = validation("Enter student id: ", scanner, "[0-9]+");
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


                    option1 = validation("[Type number 10. for exit otherwise continue: ] ... for more operations :", scanner, "[0-9]+");
                    count++;
                }

            }
            case "C" -> {
                System.out.println("Enter room and seat for night Hall: ");
                int hall = validation("Enter room: ", scanner, "[0-9]+");
                int room = validation("Enter seat: ", scanner, "[0-9]+");
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

                    System.out.println("Enter room and seat for book: ");
                    int roomInsert = validation("Enter seat: ", scanner, "[0-9]+") - 1;
                    int hallInsert = validation("Enter room: ", scanner, "[0-9]+") - 1;

                    roomnight = roomInsert+1;
                    hallnight = hallInsert+1;
                    idHolder[count] = idForNight;

                    nigthHall[hallInsert][roomInsert] = validation2("Enter room name: ", scanner, "^[A-Z]-\\d+$");
                    seat[count] = nigthHall[hallInsert][roomInsert];

                    dateTimeMor[count] = new Date();
                    idMor[count] = validation("Enter student id: ", scanner, "[0-9]+");
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


                    option1 = validation("[Type number 10. for exit otherwise continue: ] ... for more operations :", scanner, "[0-9]+");
                    count++;
                }


            }
        }
    }

    public static void showTime() {
        System.out.println("# Daily Showtime of CSTAD Hall: ");
        System.out.println("# A) Morning (10:00AM  -  12:30PM)");
        System.out.println("# B) Afternoon (03:00PM  -  05:30PM)");
        System.out.println("# C) Night (07:00PM  -  09:30PM)");
    }

    public static void rebootHistory(){
        System.out.println("Reboot Successfully !!");

        for (int i = 0; i < count; i++){
            dateTimeMor[i] = null;
            idMor[i] = 0;
        }

        for (int i = 0; i < hallmorning; i++){
            for (int j = 0; j < roommorning; j++){
                morningHall[i][j] = null;
            }
        }


        for (int i = 0; i < hallevening; i++){
            for (int j = 0; j < roomevening; j++){
                eveningHall[i][j] = null;
            }
        }



        for (int i = 0; i < hallnight; i++){
            for (int j = 0 ; j < roomnight; j++){
                nigthHall[i][j] = null;

            }
        }



    }
}

// push code on old repository