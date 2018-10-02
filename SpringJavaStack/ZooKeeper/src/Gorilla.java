
public class Gorilla extends Mammal{
	
	public void throwSomething() {
		System.out.println(this.getClass() + "threw something");
		this.energy -= 5;
	}

	public void eatBananas() {
		System.out.println(this.getClass() + "is happily eating a banana");
		this.energy += 10;
	}
	
	public void climb() {
		System.out.println(this.getClass() + "is climbing a tree");
		this.energy -= 10;
	}

}
