package com.emerald.dto;

public class Login {
    private int loginId;
    private int userId;
    private String password;

    public Login(int loginId, int userId, String password) {
        this.loginId = loginId;
        this.userId = userId;
        this.password = password;
    }
}
