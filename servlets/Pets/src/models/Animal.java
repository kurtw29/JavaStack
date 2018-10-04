package models;

public class Animal implements Pet{
	private String name;
	private String breed;
	private int weight;
	
	public Animal(String name, String breed, int weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String showAffection() {
		return String.format("Your \"%s cat\", \"%s\" looked at you with some affection. You think.", breed, name );
	}
	
	
}
