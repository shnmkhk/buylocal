package com.rabbit.buylocal.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Country {
	private long id;
	private String name;
	public Country(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
