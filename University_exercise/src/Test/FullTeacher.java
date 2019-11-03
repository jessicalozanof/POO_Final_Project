package Test;

public class FullTeacher extends Teacher {
	
	private int experienceYears;

	public FullTeacher(String name, int experienceYears) {
		super(name);
		this.experienceYears = experienceYears;
		super.setSalary(calculateSalary());
	}
	
	/**
	 * This method calculates the salary for a full time teacher
	 */
	public double calculateSalary() {
		return super.baseSalary * this.experienceYears * 1.1;
	}
	
}
