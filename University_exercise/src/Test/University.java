package Test;

import java.util.ArrayList;
import java.util.List;
import Util.Util;

public class University {
	
	private List <Teacher> teachersList = new ArrayList <Teacher>();
	private List <Course> coursesList = new ArrayList <Course>();
	private List <Student> studentsList = new ArrayList <Student>();
	
	/**
	 * This method is used for add a new Teacher to the teacher's list
	 * @param teacher is the Teacher's abstraction
	 */
	public void addTeacher(Teacher teacher) {
		teachersList.add(teacher);
	}
	
	/**
	 * This method is used for add a new Course to the course's list
	 * @param course is the Course's abstraction
	 */
	public void addCourse(Course course) {
		coursesList.add(course);
	}
	
	/**
	 * This method is used for add a new Student to the student's list
	 * @param student is the Student's abstraction
	 */
	public void addStudent(Student student) {
		studentsList.add(student);
	}
	
	/**
	 * This method adds a new student added through console to the student's list
	 */
	public void addNewStudent() {
		System.out.println("Write the name of the new student");
		String name = Util.scanString();
		System.out.println("Write the ID of the new student");
		int id = Util.scanInt();
		System.out.println("Write the age of the new student");
		int age = Util.scanInt();
		addStudent(new Student(name, id, age));
	}

	/**
	 * This method adds a new course added through console to the course's list
	 */
	public void addNewCourse() {
		System.out.println("\nWrite the name of the new course");
		String name = Util.scanString();
		System.out.println("Write the number of the classroom");
		int classroom = Util.scanInt();
		System.out.println("Write the name of the selected teacher");
		String teacherName = Util.scanString();
		for (int i = 0; i < teachersList.size() ; i++) {
			if (teachersList.get(i).getName().equalsIgnoreCase(teacherName)) {
				coursesList.add(new Course (name, classroom, teachersList.get(i)));
			} 
		}
	}
	
	/**
	 * This method adds a selected amount of students to the list of students for the last course added
	 */
	public void addStudentToCourse() {
		System.out.println("¿How many students will you add to this course?");
		int studentsAmount = Util.scanInt();
		int studentsAdded = 0;
		while (studentsAmount > studentsAdded) {
			System.out.println("Write the student's name");
			String name = Util.scanString();			
			coursesList.get(coursesList.size()-1).addStudentsList(findStudentByName(name));
			studentsAdded = studentsAdded + 1;
		}
	}		
	
	/**
	 * This method finds the student from his name to retrieve the student's object		
	 * @param name is the String to find in student's names
	 * @return a Student's object
	 */
	public Student findStudentByName(String name) {
		int index = 0;
		for (int i = 0 ; i < studentsList.size() ; i++) {
			if (studentsList.get(i).getName().equalsIgnoreCase(name)) {
				index = i;
			} 
		}
		return studentsList.get(index);
	}

	/**
	 * This method finds the course from his name to retrieve the course's object		
	 * @param name is the String to find in course's names
	 * @return a Course's object
	 */
	public Course findCourseByName(String name) {
		int index = 0;
		for (int i = 0 ; i < coursesList.size() ; i++) {
			if (coursesList.get(i).getName().equalsIgnoreCase(name)) {
				index = i;
			} 
		}
		return coursesList.get(index);
	}		
	
	/**
	 * This method searches within the list of courses to find a given students and retrieve in which courses is he registered
	 */
	public void listCoursesForStudent() {
		System.out.println("Write the student's ID");
		int id = Util.scanInt();
		for (Course courses : coursesList) {
			for (Student students : courses.getStudentsList()) {
				if (students.getId() == id) {
					System.out.println("The student " + students.getName() + " takes the class: " +courses.getName());
				} 
			}
		}
	}
	
	/**
	 * This method retrieves the last student's object added to the list of students
	 * @return a Student's object
	 */
	public Student getLastStudentAdded() {
		return studentsList.get(studentsList.size()-1);
	}
	
	/**
	 * This method prints the teacher list for the university
	 */
	public void printTeachersList() {
		System.out.println("Teachers List");
		for (Teacher teachersList : teachersList) {
			System.out.println("Name: " + teachersList.getName() + ", Salary: " + teachersList.getSalary());
		}
	}
	
	/**
	 * This method prints the courses list for the university
	 */
	public void printCourses() {
		System.out.println("Courses List");
		for (Course courses : coursesList) {
			System.out.println("Name: " + courses.getName());
		}
	}
	
	/**
	 * This method prints all the information for a selected course through console
	 * @param selectedCourse is a String for the name of the course for which the user wants to have information
	 */
	public void printCourseInformation(String selectedCourse) {
		for (Course courses : coursesList) {
			if (courses.getName().equalsIgnoreCase(selectedCourse)) {
				System.out.println("The course " + courses.getName() + " is taught by the teacher " + courses.getTeacher().getName() + " in the classroom " + courses.getClassroom());
				if (courses.getStudentsList().size() > 0) {
					System.out.println("The students list from this course is:");
					for (Student students : courses.getStudentsList()) {
						System.out.println("-" + students.getName() + " Id: " + students.getId());
					}
				} else System.out.println("There are no students in this course");							
			}
		}		
	}

	public List<Teacher> getTeachersList() {
		return teachersList;
	}

	public List<Course> getCoursesList() {
		return coursesList;
	}

	public List<Student> getStudentsList() {
		return studentsList;
	}

}
