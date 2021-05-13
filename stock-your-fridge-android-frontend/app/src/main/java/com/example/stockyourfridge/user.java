package com.example.stockyourfridge;

public class user {

    private long userId;
    private String userName;
    private String password;
    private String email;
    private boolean isEnabled;

    public user(String userName, String password, String email, boolean isEnabled) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isEnabled = isEnabled;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
