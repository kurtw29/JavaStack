package com.web.models;

import java.util.ArrayList;

public class Team {
	private String name;
	private ArrayList<Player> players = new ArrayList<Player>();
	private static ArrayList<Team> teamList = new ArrayList<Team>();
	private static int teamCounter = 0;
	private int id;
	
	public Team(String name) {
		this.name = name;
		Team.teamCounter++;
		this.id = Team.teamCounter-1;
		System.out.println("what's arrayList<teamList>?"+teamList);
		System.out.println("finishing constructing team");
	}
	
	//addPlayer: add a player to the playerList
	public void addToPlayerList(Player player, int teamId) {
		for(Team team: Team.teamList) {
			if(team.getId() == teamId) {
				players.add(player);				
			}else {
				System.out.println("wrong team ID to add player. teamId: "+teamId);
			}
		};
	}
	
	//method: get a selected team given an id
	public static Team getTeam(int id) {
		for(Team team: Team.teamList) {
			if(team.getId() == id) {
				return team;
			}
		}
		System.out.println("Did not find the team base on ID");
		return null;
	}
		
	//method: add the a team to the list
	public static void addToList(Team newTeam) {
		System.out.println("entered addToList(newTeam): newTeam:"+newTeam);
		System.out.println("what's arrayList<teamList>?"+teamList);
		Team.teamList.add(newTeam);
	}
	//get TeamList
	public static ArrayList<Team> getTeamList(){
		return Team.teamList;
	}
	//get & set team's "name"
	public String getName() {
		return name;
	}
	//remove a team method
	public static void removeFromList(int teamId) {
		for(int i =0; i<Team.getTeamList().size(); i++) {
			if(Team.getTeamList().get(i).getId() == teamId) {
				System.out.println("looping to remove: "+Team.getTeamList().get(i).getName());
				Team.teamList.remove(i);
			}
		}
		Team.teamCounter--;
	}
	public void setName(String name) {
		this.name = name;
	}
	//get & set team's players (array)
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	//get & set team's id
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//removePlayer: remove a player from the playerList
	public static void removePlayerList(int playerId, int teamId) {
		ArrayList<Player> arr = Team.getTeam(teamId).getPlayers();
		for(int i=0; i< Team.getTeam(teamId).getPlayers().size(); i++) {
			if(arr.get(i).getId() == playerId) {
				arr.remove(i);
			}else {
				System.out.println("problem finding the player with playerId: "+playerId);
			}
		}
		System.out.println("problem finding team with teamId: "+teamId);
	}
}
