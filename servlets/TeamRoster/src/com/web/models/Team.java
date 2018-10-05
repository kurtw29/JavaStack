package com.web.models;

import java.util.ArrayList;

public class Team {
	String name;
	ArrayList<Object> players;
	public Team(String name, ArrayList<Object> player) {
		this.name = name;
		this.players.add(player);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Object> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Object> players) {
		this.players = players;
	}
}
