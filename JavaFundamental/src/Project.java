
public class Project {
	//declare member variables
	private String name;
	private String description;
	
	//getter & setter for "name"
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//getter & setter for "description"
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	//elevatorPitch method
	public String elevatorPitch() {
		return this.name+" : "+this.description;		
	};
	public Project() {}
	public Project(String name) {
		this.name = name;
	};
	public Project(String name, String description) {
		this.name = name;
		this.description = description;
	};
	
}
