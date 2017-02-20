import org.omg.CORBA.PUBLIC_MEMBER;

import javax.naming.ldap.PagedResultsControl;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kciml on 2/19/2017.
 */
public class Facility {
    private String name;
    private String typeOfBuilding;
    private String hours;
    private Address address;
    private int maxCapacity;
    private int numOfRooms;
    private int numOfStaff;
    private int currentCapacity;
    private String detailBio;
    private boolean inUse = false;
    private Maintenance maintenance;
    private FacilityUse facilityUse;

    public static Scanner scanner = new Scanner(System.in);

    // CONSTRUCTOR //

    public Facility(String name, String typeOfBuilding, String hours, Address address,
                    int maxCapacity, int numOfRooms, int numOfStaff, Maintenance maintenance,
                    FacilityUse facilityUse) {
        this.name = name;
        this.typeOfBuilding = typeOfBuilding;
        this.hours = hours;
        this.address = address;
        this.maxCapacity = maxCapacity;
        this.numOfRooms = numOfRooms;
        this.numOfStaff = numOfStaff;
        this.currentCapacity = 0;
        this.maintenance = maintenance;
        this.facilityUse = facilityUse;
    }

    // GETTERS AND SETTERS //

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

    // MAINTENANCE GETTERS //

    public void getMakeFacilityMaintRequest(){
        maintenance.makeFacilityMaintRequest();
    }

    public void getListMaintRequests(){
        maintenance.listMaintRequests();
    }

    public void getScheduleMaintenance(){
        maintenance.scheduleMaintenance();
    }

    public void getListMaintenance() {maintenance.listMaintenance();}

    public void getCalcMaintenanceCostForFacility() {maintenance.calcMaintenanceCostForFacility();}

    // FACILITY DETAIL METHODS //

    public void getFacilityDetail(){ // Lists off all the details of the current facility //
        System.out.println("\nCurrent Facility Information: ");
        System.out.println("\nName: " + getName());
        System.out.println("Type of Bulding: " + getTypeOfBuilding());
        System.out.println("Address: " +  (this.address.getStreet()) + ". " + (this.address.getCity()) + ", " + (this.address.getState()) + " " + (this.address.getZip()));
        System.out.println("Max maxCapacity: " + getMaxCapacity());
        System.out.println("Number of Rooms: " + getNumOfRooms());
        System.out.println("Number of Staff Members: " + getNumOfStaff());
        System.out.println("Facility Description: " + getDetailBio());
    }

    // Calculates the available capacity in the facility

    public int availableCapacity(){return (getMaxCapacity() - getCurrentCapacity());}

    // Adds a detail to the facility //

    public void addFacilityDetail(){
        System.out.println("Please enter a description of the Facility: ");
        detailBio = scanner.nextLine();
        setDetailBio(detailBio);
    }

    // FACILITY USAGE GETTERS //

    public void getScheduleInspection() {facilityUse.scheduleInspection();}

    public void getListInspections(){facilityUse.listInspections();}


    // FACILITY USAGE METHODS //

    public void isInUseDuringInterval(){  // Lists open hours
        System.out.println("This facility is in use between the hours of: " + this.hours);
    }

    public void assignFacilityToUse(){ // Opens facility to being used
        System.out.println("Facility is now open! Staff are the only ones in the building.");
        this.currentCapacity = this.numOfStaff;
        this.inUse = true;
    }

    public void assignFaciltiyToUnused(){ // // Closes facility from being used
        vacateFacility();
        this.inUse = false;
    }

    public void addCurrentCapacity(){ // Adds to current capacity. Limits capacity to not going over max capacity
        int temp, amount;
        System.out.println("Please enter the amount of people you wish to add: ");
        amount = scanner.nextInt();
        temp = this.currentCapacity + amount;
        if(temp >= (this.maxCapacity + 1)){
            System.out.println("Max capacity of " + this.maxCapacity + " reached!");
            System.out.println("Overflow of people = " + (temp - maxCapacity));
            this.currentCapacity = this.maxCapacity;
        } else {
            this.currentCapacity = this.currentCapacity + amount;
            System.out.println("Current Capacity: " + this.currentCapacity);
        }
    }

    public void reduceCurrentCapacity(){ // Reduces capacity by specified amount. 0 is the lowest it can go.
        int amount;
        System.out.println("Please enter the amount of people you wish to subtract: ");
        amount = scanner.nextInt();
        if((this.currentCapacity - amount) <= 0){
            this.currentCapacity = 0;
            System.out.println("Current Capacity: " + this.currentCapacity);
        } else {
            this.currentCapacity = this.currentCapacity - amount;
            System.out.println("Current Capacity: " + this.currentCapacity);
        }
    }

    public void vacateFacility(){ // Vacates the facility
        System.out.println("Facility is now currently being vacated!");
        this.currentCapacity = 0;
    }

    public void getCalcUsageRate() { // Calculates usage rate of the facility by using its current capacity.
        double percent;
        percent = (double) this.currentCapacity / (double) this.maxCapacity;
        System.out.println("Current usage rate of facility is: %" +(String.format("%.2f", percent * 100)));
    }


}
