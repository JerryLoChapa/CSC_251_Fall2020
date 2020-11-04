
public class JuniorVarsityPlayer implements Player {

	private String name, age, jerseryNumber, position;	
	
	public JuniorVarsityPlayer(String name, String age, String jerseryNumber, String position) {
		super();
		this.name = name;
		this.age = age;
		this.jerseryNumber = jerseryNumber;
		this.position = position;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}


	/**
	 * @return the jerseryNumber
	 */
	public String getJerseryNumber() {
		return jerseryNumber;
	}


	/**
	 * @param jerseryNumber the jerseryNumber to set
	 */
	public void setJerseryNumber(String jerseryNumber) {
		this.jerseryNumber = jerseryNumber;
	}


	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}


	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}


	@Override
	public String display() {
		// TODO Auto-generated method stub
		return "\n\tName: " + getName() + 
				"\n\tLeague: Junior Varsity" +
				"\n\tAge: " + getAge() + 
				"\n\tDesired Jersey Number: " + getJerseryNumber() +
				"\n\tDesired Position: " + getPosition();
	}

}
