package Test;

public class PartTeacher extends Teacher {
	
	private int hoursPerWeek;

	public PartTeacher(String name, int hoursPerWeek) {
		super(name);
		this.hoursPerWeek = hoursPerWeek;
		super.setSalary(calculateSalary());
	}

	/**
	 * This method calculates the salary for a part time teacher
	 */
	public double calculateSalary() {
		return super.baseSalary * this.hoursPerWeek;
	}

}
