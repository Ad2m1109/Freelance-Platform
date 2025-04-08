package models;

import java.util.Date;

public class Job {
    private int id;
    private String title;
    private String description;
    private int clientId;
    private Date postedDate;
    
    // Constructors, getters, setters
    public Job(int id, String title, String description, int clientId, Date postedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.clientId = clientId;
        this.postedDate = postedDate;
    }

}