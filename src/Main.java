import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList <Facility> myFacilities = new ArrayList<Facility>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	    boolean progQuit = false;
	    int choice = 0;
        System.out.println("Welcome to the Facility Manager!");
        printMainMenuInstructions();

        while (!progQuit){
            System.out.println("Please enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    printMainMenuInstructions();
                    break;
                case 1:
                    addNewFacility();
                    break;
                case 2:
                    // TODO
                    // remove facility functionality
                    break;
                case 3:
                    //TODO
                    // view details functionality
                    break;
                case 4:
                    // TODO
                    // view maintenance functionality
                    break;
                case 5:
                    listFacilites();
                    break;
                case 6:
                    progQuit = true;
                    break;
            }
        }
    }

    public static void printMainMenuInstructions(){
        System.out.println("\n Press ");
        System.out.println("\t 0 - To print menu choices.");
        System.out.println("\t 1 - To add a Facility.");
        System.out.println("\t 2 - To remove a Facility.");
        System.out.println("\t 3 - To view Details of a Facility.");
        System.out.println("\t 4 - To access maintenance operations of a facility.");
        System.out.println("\t 5 - To list all current facilities.");
        System.out.println("\t 6 - To quit the program.");
    }

    public static void addNewFacility(){
        String name, typeOfBuilding, street, city, state, zip ;
        int capacity, numOfRooms, numOfStaff;
        System.out.println("Please enter the name of the facility: ");
        name = scanner.nextLine();
        System.out.println("Please enter the type of building for the facility: ");
        typeOfBuilding = scanner.nextLine();
        System.out.println("Please enter JUST the street address (The rest will come later): ");
        street = scanner.nextLine();
        System.out.println("Please enter the city where the facility is located: ");
        city = scanner.nextLine();
        System.out.println("Please enter the state where the facility is located: ");
        state = scanner.nextLine();
        System.out.println("Please enter the zip code for the facility: ");
        zip = scanner.nextLine();
        System.out.println("please enter the maximum capacity available for the facility: ");
        capacity = scanner.nextInt();
        System.out.println("Please enter the number of rooms this facility has: ");
        numOfRooms = scanner.nextInt();
        System.out.println("Please enter the number of staff running the facility: ");
        numOfStaff = scanner.nextInt();
        myFacilities.add(new Facility(name, typeOfBuilding, new Address(street, city, state, zip),
                capacity, numOfRooms, numOfStaff));
        System.out.println("Done! The new facility has been added!");

    }

    public static void listFacilites(){
        for (int i = 0; i < myFacilities.size(); i++){
            System.out.println((i+1) + ": " + myFacilities.get(i).getName());
        }
    }
}
