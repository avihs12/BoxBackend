package com.boxproject.backend.security;

import com.boxproject.backend.Entities.Userr;

public class JwtResponse {
    private Userr user;
    private String jwtToken;

    public JwtResponse(Userr user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public Userr getUser() {
        return user;
    }

    public void setUser(Userr user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
