
public class Mammal {
	public int energy = 100;
	
	//getter
	public int getEenergy() {
		return energy;
	}
	
	//setter
	public void setEnergy(int value) {
		energy = value;
	}
	
	public int displayEnergy() {
		System.out.println("Energy level: "+ this.energy);
		return this.energy;
	}
}
