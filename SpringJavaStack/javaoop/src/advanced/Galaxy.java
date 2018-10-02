package advanced;

public class Galaxy extends Phone implements Ringable{
	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	
	public void displayInfo() {
		System.out.println("Galaxy "+this.getCarrier()+" from "+this.getCarrier());
	}
	
	public String ring() {
		return "Galaxy "+this.getVersionNumber()+" from "+this.getCarrier();
	}
	
	public String unlock() {
		return "Unlocking via finger print";
	}
	
}
