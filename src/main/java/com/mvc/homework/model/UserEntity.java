package com.mvc.homework.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nickname;

	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	@Convert(converter = RoleConverter.class)
	private RoleEnum role;

    /** constructor */
	public UserEntity() {}

	public UserEntity(Long id) {
		super();
		this.id = id;
	}
	
	public UserEntity(String username, String password, RoleEnum role) {
		super();
		this.nickname = username;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public UserEntity(Long id, String nickname, String username, String password, RoleEnum role) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.username = username;
		this.password = password;
		this.role = role;
	}


    /** getter setter */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "UserEntity [id=" + id + ", nickname=" + nickname + ", username=" + username + ", password=" + password
				+ "]";
	}

	
	
}
