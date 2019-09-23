package ecutb.model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String address;

    public Student(int id, String name, String email, String address){
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address;}
    public int getId() { return id; }
    public String getName() { return name; }
}
