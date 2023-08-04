package com.rabbit.buylocal.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Vendor {
	private long id;
	private String name;
	private String displayName;
	public Vendor(long id, String name, String displayName) {
		super();
		this.id = id;
		this.name = name;
		this.displayName = displayName;
	}
}
