package com.boxproject.backend.Entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UserRequest {

    // @Max(10)
    // @Min(6)
    private Integer userid;

    // @NotNull(message = "Please enter a valid City name")
    private String username;

    // @NotNull(message = "Please enter a valid City name")
    private String password;

  
    private Long usermobile;

    // @NotNull(message = "Please enter a valid City name")
    private String name;

    private String role = "USER";

    public UserRequest(Integer userid, String username, String password, Long usermobile, String role, String name) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.usermobile = usermobile;
        this.role = role;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUsermobile() {
        return usermobile;
    }

    public void setUsermobile(Long usermobile) {
        this.usermobile = usermobile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", usermobile="
                + usermobile + ",role=" + role + ",name=" + name + "]";
    }

}
