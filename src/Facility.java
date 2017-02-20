import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kciml on 2/19/2017.
 */
public class Facility {
    private String name;
    private String typeOfBuilding;
    private Address address;
    private int capacity;
    private int numOfRooms;
    private int numOfStaff;
    private Maintenance maintenance;

    public ArrayList <Log> unresolvedMaintRequests = new ArrayList<Log>();
    public ArrayList <Log> resolvedMaintRequests = new ArrayList<Log>();
    public static Scanner scanner = new Scanner(System.in);

    public Facility(String name, String typeOfBuilding, Address address,
                    int capacity, int numOfRooms, int numOfStaff) {
        this.name = name;
        this.typeOfBuilding = typeOfBuilding;
        this.address = address;
        this.capacity = capacity;
        this.numOfRooms = numOfRooms;
        this.numOfStaff = numOfStaff;
    }

    public String getName() {
        return name;
    }

    public String getTypeOfBuilding() {
        return typeOfBuilding;
    }

    public Address getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public int getNumOfStaff() {
        return numOfStaff;
    }

    public void makeFacilityMaintRequest(){
        String title, description;
        System.out.println("Please enter the title for the request: ");
        title = scanner.nextLine();
        System.out.println("Please enter the description for the request: ");
        description = scanner.nextLine();
        Log temp = new Log(title, description);
        maintenance.makeFacilityMaintRequest(temp, unresolvedMaintRequests);

    }
}
