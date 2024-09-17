package com.mvc.homework.model;

public enum RoleEnum {
	ADMIN(1),
	MEMBER(2);

	private final Integer value;
	
	RoleEnum(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}

}
