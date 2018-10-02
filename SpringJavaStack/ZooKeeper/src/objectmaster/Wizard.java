package objectmaster;

public class Wizard extends Human{
	public Wizard() {
		this.setHealth(50);
		this.setIntelligence(8);
	}
	public void heal(Human other) {
		other.setHealth(other.getHealth() + this.getIntelligence());
	}
	
	public void fireball(Human other) {
		other.setHealth(other.getHealth() - this.getIntelligence()*3);
	}
}
