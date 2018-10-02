package objectmaster;

public class Samurai extends Human{
	private static int samuraiPopulation = 0;
	public Samurai() {
		this.setHealth(200);
		samuraiPopulation++;
//		Samurai.setSamuraiPopulation(Samurai.howMany() + 1);
	}
	
	public void deathBlow(Human other) {
		other.setHealth(0);
		this.setHealth(this.getHealth()/2);
	}
	
	public void meditate() {
		this.setHealth(this.getHealth()+this.getHealth()/2);
	}

	public static int howMany() {
		return samuraiPopulation;
	}

	public static void setSamuraiPopulation(int samuraiPopulation) {
		Samurai.samuraiPopulation = samuraiPopulation;
	}
}
