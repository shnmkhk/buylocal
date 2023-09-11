package com.rabbit.buylocal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Country {
	private long id;
	private String name;
	private Country(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public static Country of(final long id, final String name) {
		return new Country(id, name);
	}
}
