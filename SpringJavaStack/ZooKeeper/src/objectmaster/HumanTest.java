package objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		Human personOne = new Human();
		Human personTwo = new Human();
		Wizard wizOne = new Wizard();
		Ninja ninjaOne = new Ninja();
		Samurai samOne = new Samurai();
		Samurai samTwo = new Samurai();
		
		System.out.println("samOne's health: "+ samOne.getHealth());
		wizOne.fireball(samOne);
		System.out.println("samOne's health: "+ samOne.getHealth());
		wizOne.heal(samOne);
		System.out.println("samOne's health: "+ samOne.getHealth());
		
		System.out.println("ninjaOne's health: "+ninjaOne.getHealth());
		ninjaOne.runAway();
		System.out.println("ninjaOne's health: "+ninjaOne.getHealth());
		ninjaOne.steal(samTwo);
		System.out.println("ninjaOne's health: "+ninjaOne.getHealth());
		System.out.println("samTwo's health: "+ samTwo.getHealth());
		samTwo.deathBlow(ninjaOne);
		System.out.println("ninjaOne's health: "+ninjaOne.getHealth());
		System.out.println("samTwo's health: "+ samTwo.getHealth());
		samTwo.meditate();
		System.out.println("samTwo's health: "+ samTwo.getHealth());
		System.out.println("sameOne howmany: "+Samurai.howMany());
		System.out.println("sameTwo howmany: "+Samurai.howMany());
		
		personOne.attack(personTwo);
		System.out.println("personOne health: "+ personOne.getHealth());
		System.out.println("personTwo health: "+ personTwo.getHealth());

	}

}
