package Test;

import java.util.ArrayList;
import java.util.List;

public class Course {
	
	private String name;
	private int classroom;
	private Teacher teacher;
	private List <Student> studentsList;
	
	public Course(String name, int classroom, Teacher teacher) {
		this.name = name;
		this.classroom = classroom;
		this.teacher = teacher;
		this.studentsList = new ArrayList<Student>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClassroom() {
		return classroom;
	}

	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudentsList() {
		return studentsList;
	}

	public void addStudentsList(Student student) {
		studentsList.add(student);
	}
}
