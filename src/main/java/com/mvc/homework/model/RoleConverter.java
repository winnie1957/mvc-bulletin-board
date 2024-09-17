package com.mvc.homework.model;

import java.util.Arrays;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RoleConverter implements AttributeConverter<RoleEnum, Integer>{

	@Override
	public Integer convertToDatabaseColumn(RoleEnum attribute) {
		
		return attribute.getValue();
	}

	@Override
	public RoleEnum convertToEntityAttribute(Integer dbData) {
		
		return Arrays.stream(RoleEnum.values())
				.filter(element -> dbData.equals(element.getValue()))
				.findFirst()
				.orElseThrow();
	}

}
