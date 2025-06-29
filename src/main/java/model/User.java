package model;

public class User {
    private int id;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public void setUserId(int id) {
    	this.id = id;
    }
    
    public int getUserId() {return this.id;}
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
