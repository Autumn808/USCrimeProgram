import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsCrimeStats {
    private List<UsCrimeObject> stats = new ArrayList<>();
    private Scanner scanner;
    private static String fileName;
    private boolean exit = false;
    private String[] headerLine;

    public UsCrimeStats(String fileName) {
        this.fileName = fileName;
    }

    //Using a while loop to readfile
    public void readFile() {
        headerLine = scanner.nextLine().split(", ");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            stats.add(new UsCrimeObject(line));
        }
    }

    //Opening file
    public void openFile() {
        try {
            //Using scanner to scan file
            scanner = new Scanner(new File(fileName));
        } catch (Exception e) {
            System.out.println("Could not find file with Crimes Data.  File: " + e.getMessage() + " currentDir: " + System.getProperty("user.dir"));
        }
    }

    // Growth precentages
    public void growthPercentages() {
        for (int index = 0; index < stats.size() - 1; index++) {
            UsCrimeObject year1 = stats.get(index);
            UsCrimeObject year2 = stats.get(index);
            float growth = ((year2.getPopulation() - year1.getPopulation()) / year1.getPopulation()) * 100;
            System.out.println(year1.getYear() + "-" + year2.getYear() + ": " + growth + "%");
        }
    }


    //Highest murder rate
    public int maxMurderYear() {
        float maxMurders = stats.get(0).getMurderNonnegligentManslaughterRate();
        int year = stats.get(0).getYear();
        for(UsCrimeObject crimeClass : stats) {
            if (maxMurders < crimeClass.getMurderNonnegligentManslaughterRate()) {
                maxMurders = crimeClass.getMurderNonnegligentManslaughterRate();
                year = crimeClass.getYear();
            }
        }
        return year;
    }

    // Lowest murder rate
    public int minMurderYear () {
        int year = stats.get(0).getYear();
        float minMurderRate = stats.get(0).getMurderNonnegligentManslaughterRate();

        for (UsCrimeObject crimeClass : stats) {
            if (minMurderRate > crimeClass.getMurderNonnegligentManslaughterRate()) {
                minMurderRate = crimeClass.getMurderNonnegligentManslaughterRate();
                year = crimeClass.getYear();
            }
        }
        return year;
    }

    // Highest robbery rate
    public int maxRobberyYear () {

        int year = stats.get(0).getYear();
        float maxRoberyRate = stats.get(0).getRobberyRate();

        // determine the larger number and store it
        for (UsCrimeObject crimeClass : stats) {
            if (maxRoberyRate < crimeClass.getRobberyRate()) {
                maxRoberyRate = crimeClass.getRobberyRate();
                year = crimeClass.getYear();
            }
        }
        return year;
    }

    // lowest robbery rate
    public int minRobberyYear () {
        int year = stats.get(0).getYear();
        float minRoberyRate = stats.get(0).getRobberyRate();
        // determine the lower number and store it
        for (UsCrimeObject crimeClass : stats) {
            if (minRoberyRate > crimeClass.getRobberyRate()) {
                minRoberyRate = crimeClass.getRobberyRate();
                year = crimeClass.getYear();
            }
        }
        return year;
    }

    public void printMenu() {
        System.out.println("******** Welcome to the US Crime Statistical Application ************************");
        System.out.println("Enter the number of the question you want answered. Enter ‘Q’ to quit the program :");
        System.out.println("1. What were the percentages in population growth for each consecutive year from 1994 – 2013?");
        System.out.println("2. What year was the Murder rate the highest?");
        System.out.println("3. What year was the Murder rate the lowest?");
        System.out.println("4. What year was the Robbery rate the highest?");
        System.out.println("5. What year was the Robbery rate the lowest?");
        System.out.println("Q. Quit the program");
    }

    public String getUserSelection() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void runUserSelection(String selection) {
        switch (selection) {
            // print message, time elapsed, and exit if choice is 0
            case "1":
                System.out.println("The Murder rate was highest in " + maxMurderYear() + "\n");
                break;
            // display lowest murder year if choice is 2
            case "2":
                System.out.println("The Murder rate was lowest in " + minMurderYear() + "\n");
                break;
            // display highest robbery year if choice is 3
            case "3":
                System.out.println("The Robbery rate was highest in " + maxRobberyYear() + "\n");
                break;
            // display lowest robbery year if choice is 4
            case "4":
                System.out.println("The Robbery rate was lowest in " + minRobberyYear() + "\n");
                break;
            case "Q":
                System.out.println("Thank you for trying the US Crimes Statistics Program.");
                exit = true;
                return;
            default:
                System.out.println("Invalid Selection: " + selection);
        }
    }

    //menu
    //Display menu Method
    public void runProgram() {
        String selection;
        while(!exit) {
            printMenu();
            selection = getUserSelection();
            runUserSelection(selection);
        }

    }
}
