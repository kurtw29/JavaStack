package models;

public class Dog extends Animal{
	public Dog(String name, String breed, int weight) {
		super(name, breed, weight);
	}
	
	public String showAffection() {
		if(this.getWeight() > 50) {
			return String.format("%s cuddled next to you", this.getName() );
		}else {
			return String.format("%s hopped onto your laps and cuddled you", this.getName()); 
		}
	}
}
