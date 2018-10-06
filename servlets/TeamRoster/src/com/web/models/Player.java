package com.web.models;

public class Player {
	String firstName;
	String lastName;
	int age;
	private static int playerCounter = 0;
	private int id;
	
	public Player(String first, String last, int age) {
		this.firstName = first;
		this.lastName = last;
		this.age = age;
		Player.playerCounter++;
		this.id = Player.playerCounter-1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
