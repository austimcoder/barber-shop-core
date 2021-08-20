package com.barbershop.core;

public class Customer {
	private String name;
	private Service service;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Customer(String name, Service service) {
		super();
		this.name = name;
		this.service = service;
	}
	
	
	
	
}
