import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimeTracker {
    private String sportName;
    private int timeSpent; // in minutes
    private String date;

    public TimeTracker(String sportName, int timeSpent, String date) {
        this.sportName = sportName;
        this.timeSpent = timeSpent;
        this.date = date;
    }

    public String getSportName() {
        return sportName;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public String getDate() {
        return date;
    }

    private static final List<TimeTracker> timeTrackers = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    private static void logActivity() {
        System.out.print("Enter the sport name: ");
        String sportName = sc.nextLine();

        System.out.print("Enter time spent (in minutes): ");
        int timeSpent = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        timeTrackers.add(new TimeTracker(sportName, timeSpent, date));
        System.out.println("Activity logged successfully!");
    }

    private static void viewActivities() {
        if (timeTrackers.isEmpty()) {
            System.out.println("No activities logged yet.");
            return;
        }

        for (TimeTracker tracker : timeTrackers) {
            System.out.println("Sport: " + tracker.getSportName() +
                    ", Time spent: " + tracker.getTimeSpent() + " minutes" +
                    ", Date: " + tracker.getDate());
        }
    }

    private static void calculateTotalTime() {
        int totalMinutes = 0;
        for (TimeTracker tracker : timeTrackers) {
            totalMinutes += tracker.getTimeSpent();
        }
        System.out.println("Total time spent on sports this week: " + totalMinutes + " minutes");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("1. Log a new activity");
            System.out.println("2. View logged activities");
            System.out.println("3. Calculate total time spent this week");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    logActivity();
                    break;
                case 2:
                    viewActivities();
                    break;
                case 3:
                    calculateTotalTime();
                    break;
                case 4:
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

}
