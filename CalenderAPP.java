package Poject;
import java.util.Calendar;
import java.util.Scanner;

    class Calender{

        public static void findDay() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter year: ");
            int year = scanner.nextInt();
            System.out.print("Enter month: ");
            int month = scanner.nextInt();
            System.out.print("Enter day: ");
            int day = scanner.nextInt();

            Calendar cal = Calendar.getInstance();
            cal.set(year, month - 1, day);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            String weekday = days[dayOfWeek - 1];
            System.out.println("The date " + day + "/" + month + "/" + year + " falls on a " + weekday);
        }


        public static void printMonth() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter year: ");
            int year = scanner.nextInt();
            System.out.print("Enter month (1-12): ");
            int month = scanner.nextInt();

            Calendar cal = Calendar.getInstance();
            cal.set(year, month - 1, 1);
            int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            int numDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

            // Print the header row with day names
            String[] dayNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
            for (String day : dayNames) {
                System.out.printf("%4s", day);
            }
            System.out.println();

            // Calculate number of rows needed to display all days
            int numRows = (int) Math.ceil((numDaysInMonth + firstDayOfWeek - 1) / 7.0);

            // Loop through each row and print the days in that row
            int dayOfMonth = 1;
            for (int i = 1; i <= numRows; i++) {
                for (int j = 1; j <= 7; j++) {
                    if ((i == 1 && j < firstDayOfWeek) || dayOfMonth > numDaysInMonth) {
                        // Print an empty cell before the first day of the month or after the last day
                        System.out.printf("%4s", "");
                    } else {
                        // Print the day of the month
                        System.out.printf("%4d", dayOfMonth);
                        dayOfMonth++;
                    }
                }
                System.out.println();
            }
        }


        public static void addNote() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter note: ");
            String note = scanner.nextLine();

//            notes.add(note);
            System.out.println("Note added: " + note);
        }
    }
public class CalenderAPP extends Calender {
    Scanner scanner = new Scanner(System.in);

    void Input() {
        int choice = 0;

        while (choice != 4) {
            System.out.println("1. Find Out the Day");
            System.out.println("2. Print all the day of month");
            System.out.println("3. Add Note");
            System.out.println("4. EXIT");
            System.out.print("ENTER YOUR CHOICE: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    findDay();
                    break;
                case 2:

                    printMonth();
                    break;
                case 3:
                    addNote();
                    break;
                case 4:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        CalenderAPP C = new CalenderAPP();
        C.Input();


    }
}
