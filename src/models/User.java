package models;

public class User {
    private int id;
    private String username;
    private String password;
    private String type; // "freelancer" or "client"
    
    // Constructors, getters, setters
    public boolean isFreelancer() {
        return "freelancer".equals(type);
    }
}