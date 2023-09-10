package com.rabbit.buylocal.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Country {
	private long id;
	private String name;
	public Country(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
