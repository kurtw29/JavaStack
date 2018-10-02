package objectmaster;

public class Ninja extends Human {
	public Ninja() {
		this.setStealth(10);
	}
	
	public void steal(Human other) {
		other.setHealth(other.getHealth() - this.getStealth());
		this.setHealth(this.getHealth() + this.getStealth());
	}
	
	public void runAway() {
		this.setHealth(this.getHealth() - 10);
	}
}
