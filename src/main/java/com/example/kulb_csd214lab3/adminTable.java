package com.example.kulb_csd214lab3;

public class adminTable {
    private int adminId;
    private String name;
    private String username;
    private String password;
    public adminTable(int adminId, String name, String username, String password) {
        this.adminId = adminId;
        this.name = name;
        this.username = username;
        this.password = password;
    }
    public int getAdminId() {
        return adminId;
    }
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

}