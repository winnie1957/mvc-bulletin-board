package com.mvc.homework.model;

public class UserDto {
	
	private String nickname;
	private String username;
	private RoleEnum role;

    /** constructor */
	public UserDto() {}
	
	public UserDto(String nickname, String username, RoleEnum role) {
		super();
		this.nickname = nickname;
		this.username = username;
		this.role = role;
	}


    /** getter setter */
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	/** toString */
	@Override
	public String toString() {
		return "UserEntity [nickname=" + nickname + ", username=" + username + "]";
	}

	
	
}
