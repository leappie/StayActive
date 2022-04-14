package amcode.model.domain;

import amcode.enums.Level;

import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;
    private Level level;
    private List<Alert> alertList;


}
