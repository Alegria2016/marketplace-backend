package com.marketplace.authentication;

public class AuthenticationResponse {

    private boolean valid;
    private String token;

    public AuthenticationResponse(String token,boolean valid) {
        this.token = token;
        this.valid = valid;
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
}
