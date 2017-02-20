/**
 * Created by kciml on 2/20/2017.
 */
public class resolvedLog {

    private String title;
    private String description;
    private int month;
    private int day;

    public resolvedLog(String title, String description, int month, int day) {
        this.title = title;
        this.description = description;
        this.month = month;
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

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

