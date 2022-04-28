package amcode.consolui.model;

public class AlertViewModel {
    private int id;
    private String alertName;
    private String startTime;
    private String endTime;

    public AlertViewModel(int id, String alertName, String startTime, String endTime) {
        this.id = id;
        this.alertName = alertName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public String getAlertName() {
        return alertName;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return alertName + ": (" + startTime + "-" + endTime + ")";
    }
}
