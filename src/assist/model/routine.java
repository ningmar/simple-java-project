package assist.model;

public class routine {
    int id;
    String starttime, endtime,activity,reference;

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public int getId() {
        return id;
    }

    public String getStarttime() {
        return starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public String getActivity() {
        return activity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
    
}
