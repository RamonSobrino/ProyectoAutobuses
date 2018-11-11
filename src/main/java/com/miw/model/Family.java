package com.miw.model;

public class Family {
	private Integer id;
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Family(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	public Family() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
