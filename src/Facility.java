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

    public static Scanner scanner = new Scanner(System.in);

    // Constructor //

    public Facility(String name, String typeOfBuilding, Address address,
                    int maxCapacity, int numOfRooms, int numOfStaff, Maintenance maintenance) {
        this.name = name;
        this.typeOfBuilding = typeOfBuilding;
        this.address = address;
        this.maxCapacity = maxCapacity;
        this.numOfRooms = numOfRooms;
        this.numOfStaff = numOfStaff;
        this.currentCapacity = numOfStaff;
        this.maintenance = maintenance;

    }

    // Getters and Setters //

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

    // Maintenance Getters //

    public void getMakeFacilityMaintRequest(){
        maintenance.makeFacilityMaintRequest();
    }

    public void getListMaintRequests(){
        maintenance.listMaintRequests();
    }

    public void getScheduleMaintenance(){
        maintenance.scheduleMaintenance();
    }

    public void getListMaintenance(){
        maintenance.listMaintenance();
    }

    // Facility Detail Operators //

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
