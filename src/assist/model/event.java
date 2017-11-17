
package assist.model;


import java.sql.Time;
import java.util.Date;

public class event {
    int id;
    String mydate;
    String mytime;
    String description;


    public void setId(int id) {
        this.id = id;
    }

    public void setMydate(String mydate) {
        this.mydate = mydate;
    }

    public void setMytime(String mytime) {
        this.mytime = mytime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getMydate() {
        return mydate;
    }

    public String getMytime() {
        return mytime;
    }

    public String getDescription() {
        return description;
    }
}
