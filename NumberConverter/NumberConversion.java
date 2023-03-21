package Poject;

import java.util.Scanner;

class Conversion {

    public static void decimalToOther(int decimal) {

        long dec = decimal;
        // Convert to binary
        String binary = Integer.toBinaryString(decimal);

        // Convert to octal
        String octal = Integer.toOctalString(decimal);

        // Convert to hexadecimal
        String hexadecimal = Integer.toHexString(decimal);

        System.out.println("\n---------------------------");
        System.out.println(">>> Conversion Results <<< ");
        System.out.println("---------------------------");

        //Print the results
        System.out.println("Decimal equivalent:  " + dec);
        System.out.println("Binary equivalent:  " + binary);
        System.out.println("Octal equivalent:  " + octal);
        System.out.println("Hexadecimal equivalent:  " + hexadecimal);

    }

    public static void binaryToOther(long binary) {
        // Convert binary to decimal
        int decimal = 0;
        int power = 0;
        while (binary != 0) {
            long digit = binary % 10;
            decimal += digit * Math.pow(2, power);
            power++;
            binary /= 10;
        }
        // Convert decimal to others
        decimalToOther(decimal);
    }

    public static void octalToOthers(int octal) {
        // Convert octal to decimal
        int decimal = 0;
        int power = 0;
        while (octal != 0) {
            int digit = octal % 10;
            decimal += digit * Math.pow(8, power);
            power++;
            octal /= 10;
        }

        // Convert decimal to binary
        decimalToOther(decimal);
    }

    public static void convertHexadecimalToOthers(String hexNumber) {
        int decimalNumber = Integer.parseInt(hexNumber, 16);
        decimalToOther(decimalNumber);
    }

}

class WelcomeAndInput extends Conversion {

    public static void screenCleaner() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void exitScreen() {
        screenCleaner();
        System.out.println("-------------------------------------------");
        System.out.println(" >>> Thank you 😊😊😊  <<< ");
        System.out.println(" >>> Rajib Kumar  <<< ");
        System.out.println("-------------------------------------------\n");

        System.out.println("> E-mail- rrajibkd@gmail.com \n");

        System.exit(0); // exit() function to close the program safely
    }

    public static void conversionTitle() {
        System.out.println("\n---------------------------");
        System.out.println(">>> Conversion Results <<< ");
        System.out.println("---------------------------");
    }

    public static void welcomeScreen() {
        Scanner input = new Scanner(System.in);
        int choice;

        screenCleaner();
        System.out.println("-------------------------------------------");
        System.out.println(">>> Welcome to Number System Converter <<<");
        System.out.println("-------------------------------------------\n");

        System.out.println(">> Select Conversion Type:");
        System.out.println("> 1. Binary Conversion");
        System.out.println("> 2. Decimal Conversion");
        System.out.println("> 3. Octal Conversion");
        System.out.println("> 4. Hexadecimal Conversion");
        System.out.println("> 5. Exit the Program\n");

        System.out.print("Enter the number & Hit ENTER: ");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                userInput(1);
                break;
            case 2:
                userInput(2);
                break;
            case 3:
                userInput(3);
                break;
            case 4:
                userInput(4);
                break;
            case 5:
                exitScreen();
                break;
            default:
                System.out.println("\nError: the number must be between 1 to 5.");
                System.out.println("Press any key to continue... ");
                input.nextLine(); // consume the remaining newline character
                input.nextLine(); // wait for the user to press a key
        }

    }

    public static int digitChecker(long num, int choice) {
        int rem, temp = 0, flag = 0;
        temp = (int) num;

        while (temp != 0) {
            rem = temp % 10;

            if ((rem == 0 || rem == 1) && choice == 1) { // binary, choice = 1
                temp = temp / 10;
            } else if (rem >= 0 && rem <= 9 && choice == 2) { // decimal, choice = 2
                temp = temp / 10;
            } else if (rem >= 0 && rem <= 7 && choice == 3) { // octal, choice = 3
                temp = temp / 10;
            } else {
                flag = 1;
                break;
            }
        }
        return flag;
    }


    public static void userInput(int choice) {

        Scanner sc = new Scanner(System.in);
        screenCleaner();
        if (choice == 1) { // Binary input validation code
            long bi;
            long flag = 0;

            System.out.print("Enter the binary: ");
            bi = sc.nextLong();

            flag = digitChecker(bi, choice);

            if (flag == 1) {
                System.out.println("\nError: Binary can only have the digits 0, 1. ");
                System.out.println("Press any key to continue... ");
                sc.nextLine();
                welcomeScreen();
            } else {
                binaryToOther(bi);
            }
        } else if (choice == 2) { // Decimal input validation code
            int deci;
            int flag = 0;

            System.out.print("Enter the decimal: ");
            deci = sc.nextInt();

            if (deci > 0) {
                flag = digitChecker(deci, choice);
            } else {
                flag = 1;
            }

            if (flag == 1) {
                System.out.println("\nError: Decimal number can't be negative. ");
                System.out.println("Press any key to continue... ");
                sc.nextLine();
                welcomeScreen();
            } else {
                decimalToOther(deci);
            }
        } else if (choice == 3) { // Octal input validation code
            int octal;
            int flag = 0;

            System.out.print("Enter the octal: ");
            octal = sc.nextInt();

            flag = digitChecker(octal, choice);

            if (flag == 1) {
                System.out.println("\nError: Octal digits can only be between 0 to 7. ");
                System.out.println("Press any key to continue... ");
                sc.nextLine();
                welcomeScreen();
            } else {
                octalToOthers(octal);
            }
        } else if (choice == 4) { // HexaDecimal input validation code
            Scanner scanner = new Scanner(System.in);
            String hexa;

            System.out.print("Enter the hexadecimal: ");
            hexa = scanner.nextLine();

            for (int j = 0; j < hexa.length(); j++) {
                char c = hexa.charAt(j);
                if (!Character.isDigit(c) && !(c >= 'A' && c <= 'F') && !(c >= 'a' && c <= 'f')) {
                    System.out.println("\n\nError: Hexadecimal digits can only be between 0 to 9 & A to F. \n");
                    System.out.println("Press any key to continue... \n");
                    scanner.nextLine();
                    welcomeScreen();
                    return;
                }
            }
            {
//                String Hexadecimal = String.valueOf(hexa);
                convertHexadecimalToOthers(hexa);
            }

        }
    }
}
public class NumberConversion {
    public static void main(String[] args) {
        WelcomeAndInput W = new WelcomeAndInput();
        W.welcomeScreen();

    }
}
