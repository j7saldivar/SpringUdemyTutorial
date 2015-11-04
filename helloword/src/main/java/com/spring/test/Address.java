package com.spring.test;

public class Address {

	private String street;
	private String postcode;
	
	public Address() {
	}

	
	public Address(String street, String postcode) {
		this.street = street;
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", postCode=" + postcode + "]";
	}
	
	public void init() {
		System.out.println("Bean created: " + this);
	}
		
}
