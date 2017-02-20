/**
 * Created by kciml on 2/19/2017.
 */
public class Log {
    private String title;
    private String description;
    private int month;
    private int day;

    public Log(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
