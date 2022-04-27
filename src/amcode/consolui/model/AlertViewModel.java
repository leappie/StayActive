package amcode.consolui.model;

public class AlertViewModel {
    private String alertName;
    private String startTime;
    private String endTime;

    public AlertViewModel(String alertName, String startTime, String endTime) {
        this.alertName = alertName;
        this.startTime = startTime;
        this.endTime = endTime;
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
}
