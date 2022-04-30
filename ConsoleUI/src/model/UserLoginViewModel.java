package model;

public class UserLoginViewModel {
    private String username;
    private String password;

    public UserLoginViewModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
