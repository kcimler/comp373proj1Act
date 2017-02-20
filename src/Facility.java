import java.util.ArrayList;

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

    public ArrayList <Log> unresolvedMaintRequests = new ArrayList<Log>();
    public ArrayList <Log> resolvedMaintRequests = new ArrayList<Log>();

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
}
