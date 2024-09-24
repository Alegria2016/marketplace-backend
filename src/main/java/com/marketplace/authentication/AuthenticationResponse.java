package com.marketplace.authentication;

import com.marketplace.models.dtos.UserResponse;

public class AuthenticationResponse {

    private boolean valid;
    private String token;

    private UserResponse user;

    public AuthenticationResponse(String token,boolean valid, UserResponse user) {
        this.token = token;
        this.valid = valid;
        this.user = user;
    }


    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
