package com.boxproject.backend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor  // Adds a default no-argument constructor
@AllArgsConstructor // Adds a constructor with all arguments
public class Userr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	private String username;
	private String password;
	private String name;
	private Long usermobile;
	private String role = "user";

	public Userr(Integer userid, String username, String password, Long usermobile, String role, String name) {
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
