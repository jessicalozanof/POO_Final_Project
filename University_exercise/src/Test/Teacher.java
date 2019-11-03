package Test;

public abstract class Teacher {
	
	private String name;
	private double salary;
	protected double baseSalary = 60;
	
	public Teacher(String name) {
		this.name = name;
	}

	public abstract double calculateSalary();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
