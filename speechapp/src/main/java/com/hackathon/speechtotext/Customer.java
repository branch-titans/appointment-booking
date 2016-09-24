package com.hackathon.speechtotext;

public class Customer {
	private String cin;

	private String name;

	public Customer() {}

	public Customer(String cin, String name) {
		this.cin = cin;
		this.name = name;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
