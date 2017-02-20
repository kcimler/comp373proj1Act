/**
 * Created by kciml on 2/20/2017.
 */
public class resolvedLog {

    private String title;
    private String description;
    private int month;
    private int day;
    private double cost;

    // CONSTRUCTOR //

    public resolvedLog(String title, String description, int month, int day, double cost) {
        this.title = title;
        this.description = description;
        this.month = month;
        this.day = day;
        this.cost = cost;
    }

    // GETTERS //

    public double getCost() {return cost;}

    public int getMonth() {return month;}

    public int getDay() {
        return day;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

