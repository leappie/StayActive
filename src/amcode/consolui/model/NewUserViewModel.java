package amcode.consolui.model;

public class NewUserViewModel {
    private String username;
    private String password;
    private String level;

    public NewUserViewModel(String username, String password, String level) {
        this.username = username;
        this.password = password;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLevel() {
        return level;
    }
}
