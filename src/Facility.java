import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kciml on 2/19/2017.
 */
public class Facility {
    private String name;
    private String typeOfBuilding;
    private Address address;
    private int maxCapacity;
    private int numOfRooms;
    private int numOfStaff;
    private int currentCapacity;
    private String detailBio;
    private Maintenance maintenance;

    public ArrayList <Log> unresolvedMaintRequests = new ArrayList<Log>();
    public ArrayList <Log> resolvedMaintRequests = new ArrayList<Log>();
    public static Scanner scanner = new Scanner(System.in);

    public Facility(String name, String typeOfBuilding, Address address,
                    int maxCapacity, int numOfRooms, int numOfStaff) {
        this.name = name;
        this.typeOfBuilding = typeOfBuilding;
        this.address = address;
        this.maxCapacity = maxCapacity;
        this.numOfRooms = numOfRooms;
        this.numOfStaff = numOfStaff;
        this.currentCapacity = numOfStaff;

    }

    public void setDetailBio(String detailBio) {
        this.detailBio = detailBio;
    }

    public String getDetailBio() {
        return detailBio;
    }

    public String getName() {
        return name;
    }

    public String getTypeOfBuilding() {
        return typeOfBuilding;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public int getNumOfStaff() {
        return numOfStaff;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
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

    public void getFacilityDetail(){
        System.out.println("\nCurrent Facility Information: ");
        System.out.println("\nName: " + getName());
        System.out.println("Type of Bulding: " + getTypeOfBuilding());
        System.out.println("Address: " +  (this.address.getStreet()) + ". " + (this.address.getCity()) + ", " + (this.address.getState()) + " " + (this.address.getZip()));
        System.out.println("Max maxCapacity: " + getMaxCapacity());
        System.out.println("Number of Rooms: " + getNumOfRooms());
        System.out.println("Number of Staff Members: " + getNumOfStaff());
        System.out.println("Facility Description: " + getDetailBio());
    }

    public int availableCapacity(){
        return (getMaxCapacity() - getCurrentCapacity());
    }

    public void addFacilityDetail(){
        System.out.println("Please enter a description of the Facility: ");
        detailBio = scanner.nextLine();
        setDetailBio(detailBio);
    }
}
