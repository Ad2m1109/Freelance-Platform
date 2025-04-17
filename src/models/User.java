package models;

public class User {
    private int id;
    private String username;
    private String password;
    private String type;

    public User(int id, String username, String password, String type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    public void addUser(User user) {
        // Code to add user to the database
    }
    public void updateUser(User user) {
        // Code to update user in the database
    }
    public void deleteUser(User user) {
        // Code to delete user from the database
    }
    public User getUserByUsername(String username) {
        // Code to get user from the database
        return null;
    }

}