/**
 * Created by kciml on 2/19/2017.
 */
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    // CONSTRUCTOR //

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // GETTERS //

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}
