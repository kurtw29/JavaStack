package objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		Human personOne = new Human();
		Human personTwo = new Human();
		
		personOne.attack(personTwo);
		System.out.println("personOne health: "+ personOne.getHealth());
		System.out.println("personTwo health: "+ personTwo.getHealth());

	}

}
