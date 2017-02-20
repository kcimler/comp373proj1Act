import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static ArrayList <Facility> myFacilities = new ArrayList<Facility>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	    boolean progQuit = false;
	    int choice = 0;
	    int facilityIndex = 0;
	    String tempName;

	    Facility testFacility1 = new Facility("Apartment", "Residence",
                new Address("1234 Awesome Street", "Milwaukee", "WI", "53118"),
                50, 8, 2);

	    Facility testFacility2 = new Facility("IC", "Educational",
                new Address("100 Loyola", "Chicago", "IL", "60660"),
                500, 200, 100);

	    myFacilities.add(testFacility1);   // Test facilites for the sake of the project
	    myFacilities.add(testFacility2);

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
                    addNewFacility();   // adds a new facility into the system
                    break;
                case 2:
                    removeFacility();   // removes a facility from the system
                    break;
                case 3:
                    //TODO
                    while(facilityIndex >= 0 && facilityIndex <= myFacilities.size()) {// runs until te user no longer is in an active facility
                        boolean detailMenu = false;
                        System.out.println("Available Facilities: ");
                        listFacilites();
                        System.out.println("Enter the name for which facility you would like to access, or press -1 to quit: ");
                        tempName = scanner.nextLine();
                        tempName.toLowerCase();
                        facilityIndex = checkForFacility(tempName);
                        System.out.println("Welcome to the facility details section!");
                        printFacilityDetailInstructions();
                        while(!detailMenu) {
                            System.out.println("Please enter your choice: ");
                            choice = scanner.nextInt();
                            scanner.nextLine();
                            switch (choice) {
                                case 1:
                                    System.out.println("Test 1");
                                    break;
                                case 2:
                                    System.out.println("Test 2");
                                    break;
                                case 3:
                                    System.out.println("Test 3");
                                    break;
                                case 4:
                                    detailMenu = true;
                                    break;
                                default:
                                    System.out.println("Invalid Choice. Try Again!");
                            }
                        }
                    }
                    break;
                case 4:
                    // TODO
                    // Facility Operations
                    break;
                case 5:
                    // TODO
                    // Maintenance Operations
                    break;
                case 6:
                    listFacilites();
                    break;
                case 7:
                    progQuit = true;
                    break;
                default:
                    System.out.println("Invalid response. Please try again: ");
            }
        }
    }

    public static void printMainMenuInstructions(){
        System.out.println("\n Press ");
        System.out.println("\t 0 - To print menu choices.");
        System.out.println("\t 1 - To add a Facility.");
        System.out.println("\t 2 - To remove a Facility.");
        System.out.println("\t 3 - To view Details of a Facility.");
        System.out.println("\t 4 - To access Facility Operations.");
        System.out.println("\t 5 - To access maintenance operations of a facility.");
        System.out.println("\t 6 - To list all current facilities.");
        System.out.println("\t 7 - To quit the program.");
    }

    public static void printFacilityDetailInstructions(){
        System.out.println("\n Press ");
        System.out.println("\t 0 - To print menu choices.");
        System.out.println("\t 1 - To add a Facility.");
        System.out.println("\t 2 - To remove a Facility.");

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

    public static void removeFacility(){
        String nameCheck;
        int temp;
        System.out.println("Please enter the name of the facility you would like to remove: ");
        nameCheck = scanner.nextLine();
        temp = checkForFacility(nameCheck);
        if(temp >= 0){
            myFacilities.remove(temp);
        }
    }

    public static int checkForFacility(String nameCheck){
        for (int i = 0; i < myFacilities.size(); i++){
            if(Objects.equals(myFacilities.get(i).getName().toLowerCase(), nameCheck.toLowerCase())){
                return i;
            }
        }

        return -1;
    }

    public static void listFacilites(){
        for (int i = 0; i < myFacilities.size(); i++){
            System.out.println((i+1) + ": " + myFacilities.get(i).getName());
        }
    }


}
