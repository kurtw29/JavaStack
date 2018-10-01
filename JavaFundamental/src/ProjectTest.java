
public class ProjectTest {
	public static void main(String[] args) {
		Project projectOne = new Project();
		System.out.println(projectOne.elevatorPitch());
		Project projectTwo = new Project("projectNameOne");
		System.out.println(projectTwo.elevatorPitch());
		Project projectThree = new Project("projectNameTwo", "projectDescTwo");
		System.out.println(projectThree.elevatorPitch());
	}
}
